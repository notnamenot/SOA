package pl.edu.agh.soa.rest;

import org.apache.commons.io.FileUtils;
import pl.edu.agh.soa.model.Student;
import pl.edu.agh.soa.model.StudentList;
import pl.edu.agh.soa.rest.jwt.JWTTokenNeeded;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
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

//        return Response.ok(Base64Utils.encoder("/home/piotr/SOA/Zadanie1/lab/soap-api/src/main/resources/avatar.png"))
//                .status(Response.Status.OK).build();

        String fileName = "/avatar.png";
        InputStream inputStream = this.getClass().getResourceAsStream(fileName);
        System.out.println(inputStream);
        byte[] targetArray = new byte[inputStream.available()];
//        inputStream.read(targetArray);
        String encoded = Base64.getEncoder().encodeToString(targetArray);

        File file = new File("resources/avatar.png");
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);

        InputStream inputStream2 = this.getClass().getResourceAsStream("avatar.png");
        byte[] targetArray2 = new byte[inputStream.available()];
        String encoded2 = Base64.getEncoder().encodeToString(targetArray2);

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL resource = classLoader.getResource( "avatar.png");
        System.out.println("URL:" + (resource != null ? resource.toString() : null));

        InputStream resource2 = classLoader.getResourceAsStream("avatar.png");
        if (resource2 == null) throw new AssertionError();
        System.out.println("InputStream" + resource2.available());
        byte[] targetArray3 = new byte[resource2.available()];
        String encoded3 = Base64.getEncoder().encodeToString(targetArray3);

        ClassLoader cl = this.getClass().getClassLoader();
        URL r = cl.getResource( "avatar.png");
        System.out.println("URL2:" + (r != null ? r.toString() : null));
//        InputStream inStream = this.getClass().getClassLoader().getResourceAsStream("avatar.png");
//        byte[] targetArray4 = new byte[inStream.available()];
//        String encoded4 = Base64.getEncoder().encodeToString(targetArray4);
//        System.out.println("e4: " + encoded4);

        byte[] bytes = IOUtils.toByteArray(resource2);
//        File file2 = new File(resource.getFile());
//        String absolutePath2 = file.getAbsolutePath();
//        System.out.println("ap" + absolutePath2);
//        String encoded3 = Base64.getEncoder().encodeToString( Files.readAllBytes(file2.toPath()));

//        URL resource2 = this.getClass().getResource("avatar.png");
//        InputStream inputStream3 = resource2.openStream();

        byte[] fileContent = FileUtils.readFileToByteArray(new File("D:\\Studia\\s6\\soa\\soap\\lab1\\rest-api\\WEB-INF\\avatar.png"));
//        fileContent = FileUtils.readFileToByteArray(new File("avatar.png"));
//        System.out.println("Path : " + new File("avatar.png").getAbsolutePath());
        String encodedString = Base64.getEncoder().encodeToString(fileContent);

        return Response.ok(encodedString).status(Response.Status.OK).build();    // 200
    }

    @POST
    @Path("/")
    @JWTTokenNeeded
    public Response addStudentWithFirstNameLastNameAlbumNo(Student student) {

//        URI uri =  uriInfo.getAbsolutePath(); //żeby zwrócić ścieżkę do nowego zasobu
        LOGGER.info("addStudentWithFirstNameLastNameAlbumNo:\n " + student.toString());

        /*
        LOGGER.info("getAbsolutePath:\n " + uri);
        LOGGER.info("getPath:\n " + uriInfo.getPath());
        LOGGER.info("getBaseUri:\n " + uriInfo.getBaseUri());
        LOGGER.info("getRequestUri:\n " + uriInfo.getRequestUri());
        LOGGER.info("getMatchedURIs:\n " + uriInfo.getMatchedURIs());
        LOGGER.info("getPathParameters:\n " + uriInfo.getPathParameters());
        LOGGER.info("getPathSegments:\n " + uriInfo.getPathSegments());
         */

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
}
