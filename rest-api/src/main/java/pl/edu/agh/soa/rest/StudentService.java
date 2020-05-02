package pl.edu.agh.soa.rest;

import com.google.common.io.ByteStreams;
import org.apache.commons.io.FileUtils;
import pl.edu.agh.soa.model.Student;
import pl.edu.agh.soa.model.StudentList;
import pl.edu.agh.soa.model.StudentOuterClass;
import pl.edu.agh.soa.rest.jwt.JWTTokenNeeded;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Base64;
//import utils.Base64Utils;
import org.apache.commons.io.IOUtils;

import static org.jboss.ws.api.Log.LOGGER;

@Path("students")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
//@Stateless
public class StudentService {

//    @Context
//    private UriInfo uriInfo;

    @Inject
    private StudentList students; //instance żeby przy każdym żądaniu był nowy obiekt


    @GET
    @Path("/")
//    public Response getStudents(@Context UriInfo ui) {
//        MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
    public Response getStudents(@QueryParam("course") String course,
                                @QueryParam("firstName") String firstName) {
        List<Student> filteredStudents = students.filter(course, firstName);
        LOGGER.info("getStudents:\tcourse:\n " + course + ";firsName:" + firstName + ";filteredStudents:" + filteredStudents.toString());
        return Response.ok(filteredStudents).status(Response.Status.OK).variant(null).build(); //200
    }

    @GET
    @Path("/{albumNo}")
    public Response getStudentByAlbumNo(@PathParam("albumNo") int albumNo) {
        if (!students.exists(albumNo))
            return Response.notModified().status(Response.Status.NOT_FOUND).build(); //404

        Student student = students.getStudent(albumNo);
        LOGGER.info("getStudentByAlbumNo:\talbumNo\n " + albumNo + ";student:\n" + student);
        return Response.ok(student).status(Response.Status.OK).build();    // 200
    }

    @GET
    @Path("/{albumNo}/courses")
    public Response getStudentCourses(@PathParam("albumNo") int albumNo) {
        if (!students.exists(albumNo))
            return Response.notModified().status(Response.Status.NOT_FOUND).build(); //404

        List<String> studentCourses = students.getStudent(albumNo).getCourses();
        LOGGER.info("getStudentByAlbumNo:\n " + albumNo + "\n" + studentCourses);
        return Response.ok(studentCourses).status(Response.Status.OK).build();    // 200
    }

    @GET
//    @Path("/{albumNo}/avatar")
    @Path("avatar")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getStudentAvatar() throws IOException {
//        if (!students.exists(albumNo))
//            return Response.notModified().status(Response.Status.NOT_FOUND).build(); //404

//        File file = new File("img/avatar.png");
//        String absolutePath = file.getAbsolutePath();
//        System.out.println(absolutePath);
//
//        InputStream inputStream = this.getClass().getResourceAsStream("img\\avatar.png");
//        byte[] targetArray2 = new byte[inputStream.available()];//tylko wielekość
//        String encoded2 = Base64.getEncoder().encodeToString(targetArray2);

//        ClassLoader cl = this.getClass().getClassLoader();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader(); //If we don't create any threads in the entire application, the main thread will end up with the system class loader as their context class loader.
        URL resource = classLoader.getResource( "avatar.png");
        System.out.println("URL:" + (resource != null ? resource.toString() : null));
//        InputStream input = classLoader.getResourceAsStream("avatar.png");

        InputStream resource2 = classLoader.getResourceAsStream("avatar.png");
//        System.out.println("InputStream" + resource2.available());
////        byte[] targetArray3 = new byte[resource2.available()];
        assert resource2 != null;
        byte[] targetArray3 = IOUtils.toByteArray(resource2);//ByteStreams.toByteArray(resource2);
        String encoded3 = Base64.getEncoder().encodeToString(targetArray3);
        System.out.println("encoded3"+encoded3);

////        byte[] fileContent = FileUtils.readFileToByteArray(new File("D:\\Studia\\s6\\soa\\soap\\lab1\\rest-api\\WEB-INF\\avatar.png"));
//        byte[] fileContent = FileUtils.readFileToByteArray(new File("img\\avatar.png"));//D:\Programy\WildFly\wildfly-18.0.1\bin\img\avatar.png
//        fileContent = FileUtils.readFileToByteArray(new File("img\\avatar.png"));
////        System.out.println("Path : " + new File("avatar.png").getAbsolutePath());
//        String encodedString = Base64.getEncoder().encodeToString(fileContent);

        return Response.ok(encoded3).status(Response.Status.OK).build();    // 200
    }

    @POST
    @Path("/")
    @JWTTokenNeeded
    public Response addStudentWithFirstNameLastNameAlbumNo(Student student) {
        LOGGER.info("addStudentWithFirstNameLastNameAlbumNo:\n " + student.toString());

        if (students.exists(student.getAlbumNo()))
            return Response.notModified().status(Response.Status.CONFLICT).build(); //409 The request could not be completed due to a conflict with the current state of the resource.
        else {
            students.addStudent(student);
            LOGGER.info("addStudentWithFirstNameLastNameAlbumNo:\n " + students.toString());
            return Response.ok().status(Response.Status.CREATED).build(); //.created(uri) // 201
        }
    }

    @PUT
    @Path("/{albumNo}")
    @JWTTokenNeeded
    public Response editStudent(Student student) {
        if (!students.exists(student.getAlbumNo()))
            return Response.notModified().status(Response.Status.NOT_FOUND).build();

        students.getStudent(student.getAlbumNo()).updateFromStudent(student);
        return Response.ok().status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{albumNo}")
    @JWTTokenNeeded
    public Response deleteStudent(@PathParam("albumNo") int albumNo) {
        if (!students.exists(albumNo))
            return Response.notModified().status(Response.Status.NOT_FOUND).build(); //404

        students.deleteStudent(albumNo);
        return Response.ok().status(Response.Status.NO_CONTENT).build(); //204
    }

    @GET
    @Path("/protobuf")
    @Produces("application/protobuf")//APPLICATION_OCTET_STREAM)
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
}
