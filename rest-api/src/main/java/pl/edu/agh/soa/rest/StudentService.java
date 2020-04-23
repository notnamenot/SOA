package pl.edu.agh.soa.rest;

import pl.edu.agh.soa.soap.model.Student;
import pl.edu.agh.soa.soap.model.StudentList;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.jboss.ws.api.Log.LOGGER;

@Path("students")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
//@Stateless
public class StudentService {

    @Context
    private UriInfo uriInfo;
//
    @Inject
    private StudentList students; //instance żeby przy każdym żądaniu był nowy obiekt

//    @Inject
//    Test test;

    @GET
//    @Produces(MediaType.APPLICATION_JSON)
    //@Path("all")
    @Path("/")
    public Response getAllStudents() {
        //List<Student> students = initialStudentList();

//        LOGGER.info("getAllStudents:\n " + students.getAll());

//        return Response.ok(students.getAll()).status(Response.Status.OK).build();
        return Response.ok(students).status(Response.Status.OK).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentByAlbumNo(@QueryParam("albumNo") int albumNo) {
//        List<Student> students = initialStudentList();

        Student foundStudent = students
                .getAll()
                .stream()
                .filter(s -> s.getAlbumNo() == albumNo)
                .findFirst()
                .orElse(null);

        LOGGER.info("getStudentByAlbumNo:\n " + albumNo + "\n" + foundStudent);

        if (foundStudent == null)
            return Response.notModified().status(Response.Status.BAD_REQUEST).build();
        return Response.ok(foundStudent).status(Response.Status.OK).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("add")
    public Response addStudentWithFirstNameLastNameAlbumNo(Student student) {

//        List<Student> students = initialStudentList();

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

        if (studentExists(student.getAlbumNo()))
            return Response.notModified().status(Response.Status.BAD_REQUEST).build();
        else {
            Student newStudent = addNewStudent(student);
            return Response.ok(newStudent).status(Response.Status.CREATED).build(); //.created(uri)

        }
    }

    private Student addNewStudent(Student student) {
//        List<Student> students = initialStudentList();
        Student newStudent = Student.builder()
                .firstName(student.getFirsName())
                .lastName(student.getLastName())
                .albumNo(student.getAlbumNo())
                .courses(student.getCourses())
                .build();
//        students.addStudent(newStudent);
        return newStudent;
    }

    private boolean studentExists(int albumNo) {
//        List<Student> students = initialStudentList();
        return false;//students.getAll().stream().anyMatch(s -> s.getAlbumNo() == (albumNo));
    }

    // our "database"
    private List<Student> initialStudentList() {
        Student student1 = Student.builder()
                .firstName("Jan")
                .lastName("Kowalski")
                .albumNo(20)
                .addCourse("SOA")
                .addCourse("IO")
                .build();
        Student student2 = Student.builder()
                .firstName("Anna")
                .lastName("Nowak")
                .albumNo(30)
                .addCourse("SOA")
                .addCourse("IO")
                .build();
        Student student3 = Student.builder()
                .firstName("Ewa")
                .lastName("Wąż")
                .albumNo(50)
                .addCourse("UNIX")
                .addCourse("IO")
                .build();
        Student student4 = Student.builder()
                .firstName("Adam")
                .lastName("Chwast")
                .albumNo(60)
                .build();
        //return Arrays.asList(student1, student2, student3, student4);
        //https://javastart.pl/baza-wiedzy/wyjatki/unsupportedoperationexception
        return new ArrayList<>(Arrays.asList(student1, student2, student3, student4));
    }
}
