package pl.edu.agh.soa.soap;

import pl.edu.agh.soa.soap.models.Student;

//import org.jboss.ejb3.annotation.SecurityDomain;
import org.jboss.annotation.security.SecurityDomain;
import org.jboss.ws.api.annotation.WebContext;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.WebServiceException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.logging.Logger;

@Stateless
@WebService(name = "HelloWorldServiceType", portName = "HelloWorldPort", targetNamespace = "https://soap.soa.pl/lab1/ws")
@SecurityDomain("my-security-domain") // in standalone.xml
@DeclareRoles({"MyRole"}) // manager, admin..
@WebContext(contextRoot="lab1", urlPattern="/HelloWorld", authMethod="BASIC", transportGuarantee="NONE")
@SOAPBinding(style=SOAPBinding.Style.DOCUMENT, use=SOAPBinding.Use.LITERAL) //specify the mapping between the Web service and the SOAP message protocol
public class HelloWorld {
    @WebMethod()
    @RolesAllowed("MyRole")
    public String sayHello(@WebParam(name = "message") String message) {
        return "Here is the message: '" + message + "'";
    }

    private static final Logger LOGGER = Logger.getLogger("InfoLogging");

    @PermitAll
    @WebMethod(operationName = "getStudentByAlbumNo")
    @WebResult(name = "returnStudent")
    public Student getStudentByAlbumNo(@WebParam(name="albumNo") int albumNo) {
        List<Student> students = initialStudentList();
        Student foundStudent = null;

        for (Student student : students){
            if (student.getAlbumNo() == albumNo) {
                foundStudent = student;
                break;
            }
        }

        LOGGER.info("getStudentByAlbumNo:\n " + albumNo + "\n" + foundStudent);
        return foundStudent;
    }

    @PermitAll
    @WebMethod(operationName = "addStudent")
    public Student addStudentWithFirstNameLastNameAlbumNo(@WebParam(name="firstName") String firstName, @WebParam(name="lastName") String lastName, @WebParam(name="albumNo") int albumNo) {

        List<Student> students = initialStudentList();

        Student student = Student.builder()
                .firstName(firstName)
                .lastName(lastName)
                .albumNo(albumNo)
                .build();
        students.add(student);

        LOGGER.info("addStudentWithFirstNameLastNameAlbumNo:\n " + student);
        return student;
    }

    @PermitAll
    @WebMethod(operationName = "addCourseToStudent")
    public Student addCourseToStudent(@WebParam(name="albumNo") int albumNo, @WebParam(name="course") String course) {

        List<Student> students = initialStudentList();
        Student foundStudent = null;

        for (Student student : students){
            if (student.getAlbumNo() == albumNo) {
                student.addCourse(course);
                foundStudent = student;
                break;
            }
        }

        LOGGER.info("addCourseToStudent:\n " + course + "\n" + foundStudent);
        return foundStudent;
    }

    @PermitAll
    @WebMethod
    public List<String> getStudentCourses(@WebParam(name="albumNo") int albumNo){
        List<Student> students = initialStudentList();
        Student foundStudent = null;
        List<String> courses = null;

        for (Student student : students){
            if (student.getAlbumNo() == albumNo) {
                courses = student.getCourses();
                break;
            }
        }

        LOGGER.info("getStudentCourses:  albumNo:"+ albumNo + "\n" + courses);
        return courses;
    }

    @PermitAll
    @WebMethod(operationName = "deleteStudentCourse")
    public Student deleteStudentCourse(@WebParam(name="albumNo") int albumNo, @WebParam(name="course") String course) {

        List<Student> students = initialStudentList();
        Student foundStudent = null;

        for (Student student : students){
            if (student.getAlbumNo() == albumNo) {
                student.deleteCourse(course);
                foundStudent = student;
                break;
            }
        }

        LOGGER.info("deleteStudentCourse:\n " + course + "\n" + foundStudent);
        return foundStudent;
    }

    @PermitAll
    @WebMethod(operationName = "getAllStudents")
    public List<Student> getAllStudents() {
        List<Student> students = initialStudentList();

        LOGGER.info("getAllStudents:\n " + students);
        return students;
    }

    @PermitAll
    @WebMethod(operationName = "getStudentsAttendingCourse")
    public List<Student> getStudentsAttendingCourse(@WebParam(name="course") String filteredCourse) {
        List<Student> students = initialStudentList();
        List<Student> studentsAttendingCourse = new ArrayList<>();
        List<String> allCourses;

        for (Student student : students){
            allCourses = student.getCourses();
            if (allCourses != null && allCourses.contains(filteredCourse))
                studentsAttendingCourse.add(student);
        }

        LOGGER.info("getStudentsAttendingCourse: " + filteredCourse + "\n" + studentsAttendingCourse);
        return studentsAttendingCourse;
    }

    @PermitAll
    @WebMethod(operationName = "getAvatar")
    public byte[] getAvatar(@WebParam(name = "albumNo") int albumNo) {

        try{
            String fileName = ".\\avatar.png";
            Path path  = Paths.get(fileName);
            LOGGER.info("getAvatar: path:" + path.toAbsolutePath()); // in wildfly cotalogue

            byte[] fileContent = Files.readAllBytes(path.toAbsolutePath());
//          String encodedFile = Base64.getEncoder().encodeToString(fileContent);
//          encodedFile = new String(Base64.encodeBase64(bytes), "UTF-8");

            return Base64.getEncoder().encode(fileContent);

        } catch (IOException ex) {
            System.err.println(ex);
            throw new WebServiceException(ex);
        }
    }


    // our "database"
    private List<Student> initialStudentList () {
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
        return new ArrayList<>(Arrays.asList(student1, student2, student3, student4));
    }
}
