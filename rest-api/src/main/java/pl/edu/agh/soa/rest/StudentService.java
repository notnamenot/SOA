package pl.edu.agh.soa.rest;

import pl.edu.agh.soa.soap.model.Student;
import pl.edu.agh.soa.soap.model.StudentList;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.lang.Object;
import java.util.Base64;
//import utils.Base64Utils;

import static java.util.stream.Collectors.toList;
import static org.jboss.ws.api.Log.LOGGER;

@Path("students")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
//@Stateless
public class StudentService {

    @Context
    private UriInfo uriInfo;

    @Inject
    private StudentList students; //instance żeby przy każdym żądaniu był nowy obiekt

    @GET
    @Path("/")
    public Response getStudents(@QueryParam("course") String course,
                                @QueryParam("firstName") String firstName) {
        List<Student> filteredStudents = students.filter(course, firstName);
        LOGGER.info("getStudents:\tcourse:\n " + course + ";firsName:" + firstName + ";filteredStudents:" + filteredStudents);
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

        File file = new File("resources/abc.txt");
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);

        return Response.ok(encoded).status(Response.Status.OK).build();    // 200
    }

    @POST
    @Path("/")
    public Response addStudentWithFirstNameLastNameAlbumNo(Student student) {

        URI uri =  uriInfo.getAbsolutePath(); //żeby zwrócić ścieżkę do nowego zasobu
        LOGGER.info("addStudentWithFirstNameLastNameAlbumNo:\n " + student);

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
            LOGGER.info("addStudentWithFirstNameLastNameAlbumNo:\n " + students);
            return Response.ok(student).status(Response.Status.CREATED).build(); //.created(uri) // 201
        }
    }

    @PUT
    @Path("/")
    public Response editStudent(Student student) {
        if (!students.exists(student.getAlbumNo()))
            return Response.notModified().status(Response.Status.NOT_FOUND).build();

        students.getStudent(student.getAlbumNo()).updateFromStudent(student);
        return Response.ok().status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{albumNo}")
    public Response deleteStudent(@PathParam("albumNo") int albumNo) {
        if (!students.exists(albumNo))
            return Response.notModified().status(Response.Status.NOT_FOUND).build(); //404

        students.deleteStudent(albumNo);
        return Response.ok().status(Response.Status.NO_CONTENT).build(); //204
    }


//    private Student addNewStudent(Student student) {
////        List<Student> students = initialStudentList();
//        Student newStudent = Student.builder()
//                .firstName(student.getFirsName())
//                .lastName(student.getLastName())
//                .albumNo(student.getAlbumNo())
//                .courses(student.getCourses())
//                .build();
////        students.addStudent(newStudent);
//        return newStudent;
//    }



//    private boolean studentExists(int albumNo) {
////        List<Student> students = initialStudentList();
////        return false;//students.getAll().stream().anyMatch(s -> s.getAlbumNo() == (albumNo));
//        return students.getStudent(albumNo) != null;
//    }
//
//    private Student findStudent(int albumNo) {
//         return students
//                .getAll()
//                .stream()
//                .filter(s -> s.getAlbumNo() == albumNo)
//                .findFirst()
//                .orElse(null);
//    }

//    private List<Student> findStudentsWithCourse(String course) {
//        return students
//                .getAll()
//                .stream()
//                .filter(s -> s.getCourses().contains(course))
//                .collect(toList());
////                .collect(Collectors.toList());
////                .findFirst()
////                .orElse(null);
//    }


    // our "database"
//    private List<Student> initialStudentList() {
//        Student student1 = Student.builder()
//                .firstName("Jan")
//                .lastName("Kowalski")
//                .albumNo(20)
//                .addCourse("SOA")
//                .addCourse("IO")
//                .build();
//        Student student2 = Student.builder()
//                .firstName("Anna")
//                .lastName("Nowak")
//                .albumNo(30)
//                .addCourse("SOA")
//                .addCourse("IO")
//                .build();
//        Student student3 = Student.builder()
//                .firstName("Ewa")
//                .lastName("Wąż")
//                .albumNo(50)
//                .addCourse("UNIX")
//                .addCourse("IO")
//                .build();
//        Student student4 = Student.builder()
//                .firstName("Adam")
//                .lastName("Chwast")
//                .albumNo(60)
//                .build();
//        //return Arrays.asList(student1, student2, student3, student4);
//        //https://javastart.pl/baza-wiedzy/wyjatki/unsupportedoperationexception
//        return new ArrayList<>(Arrays.asList(student1, student2, student3, student4));
//    }
}
