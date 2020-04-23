package pl.edu.agh.soa.soap;

import pl.edu.agh.soa.soap.model.Student;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface StudentService {
    String sayHello(@WebParam(name = "message") String message);

    Student addStudentWithFirstNameLastNameAlbumNo(@WebParam(name = "firstName") String firstName, @WebParam(name = "lastName") String lastName, @WebParam(name = "albumNo") int albumNo);
    Student addCourseToStudent(@WebParam(name = "albumNo") int albumNo, @WebParam(name = "course") String course);
    Student deleteStudentCourse(@WebParam(name = "albumNo") int albumNo, @WebParam(name = "course") String course);
    Student getStudentByAlbumNo(@WebParam(name = "albumNo") int albumNo);
    List<Student> getAllStudents();
    List<Student> getStudentsAttendingCourse(@WebParam(name = "course") String filteredCourse);
    List<String> getStudentCourses(@WebParam(name = "albumNo") int albumNo);
    byte[] getAvatar(@WebParam(name = "albumNo") int albumNo);
}
