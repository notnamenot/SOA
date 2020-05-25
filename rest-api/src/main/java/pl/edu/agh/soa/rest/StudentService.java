package pl.edu.agh.soa.rest;

import pl.edu.agh.soa.dao.StudentServiceDAO;
import pl.edu.agh.soa.jpa.StudentsManager;
import pl.edu.agh.soa.model.Contact;
import pl.edu.agh.soa.model.Group;
import pl.edu.agh.soa.model.Student;
import pl.edu.agh.soa.model.StudentList;
import pl.edu.agh.soa.model.StudentOuterClass;
import pl.edu.agh.soa.rest.jwt.JWTTokenNeeded;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Base64;
import java.util.logging.Logger;
//import utils.Base64Utils;
import org.apache.commons.io.IOUtils;
import io.swagger.annotations.*;

import static org.jboss.ws.api.Log.LOGGER;

@Stateless
@Api(value = "Student Service")
@Path("students")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class StudentService {

    @Inject
    private StudentList students;

    @EJB
    StudentServiceDAO dao = new StudentServiceDAO();

    @GET
    @Path("/")
    @ApiOperation(value = "Retrieve all students")//, response = Student.class, responseContainer = "List")
    @ApiResponses({@ApiResponse(code=200, message="Success")})
//    public Response getStudents(@Context UriInfo ui) {
//        MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
    public Response getStudents(@ApiParam(value = "course to filter students by", required = false) @QueryParam("course") String course,
                                @ApiParam(value = "first name to filter students by", required = false) @QueryParam("firstName") String firstName) {

        try {
            List<Student> filteredStudents = dao.findStudents(course, firstName);
            for (Student s : filteredStudents) { LOGGER.info("found"+s); }
            return Response.ok(filteredStudents).status(Response.Status.OK).variant(null).build(); //200
        }
        catch(Exception ex) {
            LOGGER.info("\n\nStudents NOT FOUND!\n\n\n");
            return Response.notModified().status(Response.Status.NOT_FOUND).build(); //404
        }

//        List<Student> filteredStudents = students.filter(course, firstName);
//        LOGGER.info("getStudents:\tcourse:\n " + course + ";firstName:" + firstName + ";filteredStudents:" + filteredStudents.toString());
//        return Response.ok(filteredStudents).status(Response.Status.OK).variant(null).build(); //200
    }

    @GET
    @Path("/{albumNo}")
    @ApiOperation(value = "Retrieve student by albumNo")
    @ApiResponses({@ApiResponse(code=200, message="Success"), @ApiResponse(code=404, message="Not Found")})
    public Response getStudentByAlbumNo(@ApiParam(value = "albumNo of student to be retrieved", required=true) @PathParam("albumNo") int albumNo) {

        try {
            Student student = dao.findStudent(albumNo);
            LOGGER.info("\n\n\nstudent:\n\n\n\n" + student);
            return Response.ok(student).status(Response.Status.OK).build();    // 200
        }
        catch (Exception ex) {
            LOGGER.info("\n\nStudent with albumNo=" + albumNo + "NOT FOUND!\n\n\n");
            return Response.notModified().status(Response.Status.NOT_FOUND).build(); //404
        }


//        if (!students.exist(albumNo))
//            return Response.notModified().status(Response.Status.NOT_FOUND).build(); //404
//
//        Student student = students.getStudent(albumNo);
//        LOGGER.info("getStudentByAlbumNo:\talbumNo\n " + albumNo + ";student:\n" + student);
//        return Response.ok(student).status(Response.Status.OK).build();    // 200
    }

    @GET
    @Path("/{albumNo}/courses")
    @ApiOperation(value = "Retrieve student's courses")
    @ApiResponses({@ApiResponse(code=200, message="Success"), @ApiResponse(code=404, message="Not Found")})
    public Response getStudentCourses(@ApiParam(value = "albumNo of student whose courses are to be retrieved") @PathParam("albumNo") int albumNo) {

        try {
            Student student = dao.findStudent(albumNo);
            LOGGER.info("\n\n\nstudent:\n\n\n\n" + student);
            return Response.ok(student.getCourses()).status(Response.Status.OK).build();    // 200
        }
        catch (Exception ex) {
            LOGGER.info("\n\nStudent with albumNo=" + albumNo + "NOT FOUND!\n\n\n");
            return Response.notModified().status(Response.Status.NOT_FOUND).build(); //404
        }

//        if (!students.exist(albumNo))
//            return Response.notModified().status(Response.Status.NOT_FOUND).build(); //404
//
//        List<String> studentCourses = students.getStudent(albumNo).getCourses();
//        LOGGER.info("getStudentByAlbumNo:\n " + albumNo + "\n" + studentCourses);
//
//        return Response.ok(studentCourses).status(Response.Status.OK).build();    // 200
    }

    @GET
    @Path("avatar")
    @Produces(MediaType.TEXT_PLAIN)
    @ApiOperation(value = "Retrieve avatar", notes = "returns base64 encoded string")
    @ApiResponses({@ApiResponse(code=200, message="Success")})
    public Response getStudentAvatar() throws IOException {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader(); //If we don't create any threads in the entire application, the main thread will end up with the system class loader as their context class loader.
        URL url = classLoader.getResource( "avatar.png");
        LOGGER.info("URL:" + (url != null ? url.toString() : null));

        InputStream resource = classLoader.getResourceAsStream("avatar.png"); // webapp/WEB-INF
        byte[] byteArrayResource = IOUtils.toByteArray(resource); // ByteStreams.toByteArray(resource2);
        String encoded = Base64.getEncoder().encodeToString(byteArrayResource);

        return Response.ok(encoded).status(Response.Status.OK).build();    // 200
    }

    @POST
    @Path("/")
    @JWTTokenNeeded
    @ApiOperation(value = "Add student", authorizations = { @Authorization(value = "jwt")}, notes = "jwt auth needed" )
    @ApiResponses({@ApiResponse(code=201, message="Created"), @ApiResponse(code=409, message="Conflict")})
    public Response addStudentWithFirstNameLastNameAlbumNo(@ApiParam(value = "student to be added", required = true) Student student) {
        LOGGER.info("addStudentWithFirstNameLastNameAlbumNo:\n " + student.toString());

        try {
            dao.addStudent(student);
            LOGGER.info("\n\n\nstudent:\n\n\n\n" + student);
            return Response.ok().status(Response.Status.CREATED).build(); //.created(uri) // 201
        }
        catch (Exception e) {
            LOGGER.info("Exception!:\n " + students.toString());
            return Response.notModified().status(Response.Status.CONFLICT).build(); // 409 The request could not be completed due to a conflict with the current state of the resource.
        }
//        if (students.exist(student.getAlbumNo()))
//            return Response.notModified().status(Response.Status.CONFLICT).build(); //409 The request could not be completed due to a conflict with the current state of the resource.
//        else {
//            students.addStudent(student);
//            LOGGER.info("addStudentWithFirstNameLastNameAlbumNo:\n " + students.toString());
//            return Response.ok().status(Response.Status.CREATED).build(); //.created(uri) // 201
//        }
    }

    @PUT
    @Path("/{albumNo}")
    @JWTTokenNeeded
    @ApiOperation(value = "Update student", authorizations = { @Authorization(value = "jwt")}, notes = "jwt auth needed" )
    @ApiResponses({@ApiResponse(code = 204, message = "No Content"), @ApiResponse(code = 404, message = "Not Found")})
    public Response editStudent(@ApiParam(value = "student to be edited", required = true) Student student) {

        try {
            dao.editStudent(student);
            LOGGER.info("\n\n\nstudent:\n\n\n\n" + student);
            return Response.ok().status(Response.Status.NO_CONTENT).build();    // 204
        }
        catch (Exception ex) {
            LOGGER.info("Exception!:\n " + students.toString());
            return Response.notModified().status(Response.Status.NOT_FOUND).build(); // 404
        }

//        if (!students.exist(student.getAlbumNo()))
//            return Response.notModified().status(Response.Status.NOT_FOUND).build(); // 404
//
//        students.getStudent(student.getAlbumNo()).updateFromStudent(student);
//        return Response.ok().status(Response.Status.NO_CONTENT).build();    // 204
    }

    @DELETE
    @Path("/{albumNo}")
    @JWTTokenNeeded
    @ApiOperation(value = "Remove student", authorizations = { @Authorization(value = "jwt")}, notes = "jwt auth needed" )
    @ApiResponses({@ApiResponse(code = 204, message = "No Content"), @ApiResponse(code = 404, message = "Not Found")})
    public Response deleteStudent(@ApiParam(value = "student to be removed", required = true) @PathParam("albumNo") int albumNo) {

        try {
            dao.deleteStudent(albumNo);
            LOGGER.info("\n\n\nremove student:" + albumNo);
            return Response.ok().status(Response.Status.NO_CONTENT).build();    // 204
        }
        catch (Exception ex) {
            LOGGER.info("Exception! removing :\n " + albumNo);
            return Response.notModified().status(Response.Status.NOT_FOUND).build(); // 404
        }

//        if (!students.exist(albumNo))
//            return Response.notModified().status(Response.Status.NOT_FOUND).build(); //404
//
//        students.deleteStudent(albumNo);
//        return Response.ok().status(Response.Status.NO_CONTENT).build(); //204
    }

    @GET
    @Path("/protobuf")
    @Produces("application/protobuf")
    @ApiOperation(value = "Retrieve ProtocolBuffer Student")
    public Response getProtoStudent() {
        StudentOuterClass.Student.Builder builder = StudentOuterClass.Student.newBuilder();

        List<String> courses = new ArrayList<>();
        courses.add("SOA");
        courses.add("UNIX");
        builder.addAllCourses(courses);
        builder
                .setFirstName("Ala")
                .setLastName("Makota")
                .setAlbumNo(666);
        StudentOuterClass.Student student = builder.build();

        return Response.ok(student.toByteArray(), "application/protobuf").build();
    }


    @GET
    @Path("/{albumNo}/group")
    @ApiOperation(value = "Retrieve student's group")
    @ApiResponses({@ApiResponse(code=200, message="Success"), @ApiResponse(code=404, message="Not Found")})
    public Response getStudentGroup(@ApiParam(value = "albumNo of student whose group is to be retrieved") @PathParam("albumNo") int albumNo) {

        try {
            Group group = dao.findGroup(albumNo);
            LOGGER.info("\n\n\ngroup:\n\n\n\n" + group.toString());
            return Response.ok(group).status(Response.Status.OK).build();    // 200
        }
        catch (Exception ex) {
            LOGGER.info("\n\ngroup error!!\n\n\n");
            return Response.notModified().status(Response.Status.NOT_FOUND).build(); //404
        }
    }


    @POST
    @Path("/{albumNo}/contact")
    @JWTTokenNeeded
    @ApiOperation(value = "Add contact to studwwnt", authorizations = { @Authorization(value = "jwt")}, notes = "jwt auth needed" )
    @ApiResponses({@ApiResponse(code=201, message="Created"), @ApiResponse(code=409, message="Conflict")})
    public Response addContactToStudent(@ApiParam(value = "contact to be added", required = true) Contact contact) {
        LOGGER.info("addContactToStudent:\n " + contact.toString());

        try {
            dao.addContact(contact);
            LOGGER.info("\n\n\nstudent:\n\n\n\n" + contact.toString());
            return Response.ok().status(Response.Status.CREATED).build(); //.created(uri) // 201
        }
        catch (Exception e) {
            LOGGER.info("Exception inc ontact!:\n " + contact.toString());
            return Response.notModified().status(Response.Status.CONFLICT).build(); // 409 The request could not be completed due to a conflict with the current state of the resource.
        }
    }

    @GET
    @Path("/{albumNo}/contact")
    @ApiOperation(value = "Retrieve student's contact")
    @ApiResponses({@ApiResponse(code=200, message="Success"), @ApiResponse(code=404, message="Not Found")})
    public Response getStudentContact(@ApiParam(value = "albumNo of student whose contact is to be retrieved") @PathParam("albumNo") int albumNo) {

        try {
            Contact contact = dao.findContact(albumNo);
            LOGGER.info("\n\n\ngroup:\n\n\n\n" + contact.toString());
            return Response.ok(contact).status(Response.Status.OK).build();    // 200
        }
        catch (Exception ex) {
            LOGGER.info("\n\ncontact error!!\n\n\n");
            return Response.notModified().status(Response.Status.NOT_FOUND).build(); //404
        }
    }


}
