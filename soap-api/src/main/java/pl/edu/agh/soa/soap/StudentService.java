package pl.edu.agh.soa.soap;

import pl.edu.agh.soa.soap.models.Student;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface StudentService {
    public String sayHello(@WebParam(name = "message") String message);

    public Student addStudentWithFirstNameLastNameAlbumNo(@WebParam(name="firstName") String firstName, @WebParam(name="lastName") String lastName, @WebParam(name="albumNo") int albumNo);
    public Student addCourseToStudent(@WebParam(name="albumNo") int albumNo, @WebParam(name="course") String course);
    public Student deleteStudentCourse(@WebParam(name="albumNo") int albumNo, @WebParam(name="course") String course);
    public Student getStudentByAlbumNo(@WebParam(name="albumNo") int albumNo);
    public List<Student> getAllStudents();
    public List<Student> getStudentsAttendingCourse(@WebParam(name="course") String filteredCourse);
    public List<String> getStudentCourses(@WebParam(name="albumNo") int albumNo);
    public byte[] getAvatar(@WebParam(name = "albumNo") int albumNo);
}
