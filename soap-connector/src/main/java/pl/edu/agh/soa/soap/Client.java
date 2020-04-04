package pl.edu.agh.soa.soap;

import javax.xml.ws.BindingProvider;
import java.awt.*;
import java.io.*;
import java.util.Base64;
import java.util.List;

public class Client {
    public static void main(String[] args) {

        StudentServiceImplService service = new StudentServiceImplService();
        StudentService serviceI = service.getStudentPort();
        setCredentials((BindingProvider) serviceI);

        List<Student> students = serviceI.getAllStudents();
        System.out.println("\nlist all students: " + printStudentList(students));

        List<Student> students2 = serviceI.getStudentsAttendingCourse("SOA");
        System.out.println("\nlist students who attend SOA: " + printStudentList(students2));

        Student addedStudent = serviceI.addStudentWithFirstNameLastNameAlbumNo("Ala","Makota",123);
        System.out.println("\nadded student: " + printStudent(addedStudent));

        Student student = serviceI.getStudentByAlbumNo(30);
        System.out.println("\ngot student by albumNo = 30: " + printStudent(student));

        Student student2 = serviceI.addCourseToStudent(30,"UNIX");
        System.out.println("\nadded course to student with albumNo = 30: " + printStudent(student2));


        byte[] avatar = serviceI.getAvatar(30);
        avatar = Base64.getDecoder().decode(avatar);
        System.out.println("\ngot avatar:");

        writeByte(avatar);
    }

    public static void setCredentials(BindingProvider port){
        port.getRequestContext().put("javax.xml.ws.security.auth.username","ninja");
        port.getRequestContext().put("javax.xml.ws.security.auth.password","ninja");
    }

    private static String printStudent(Student student) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\nfirstName: ").append(student.getFirstName())
            .append("\nlastName: ").append(student.getLastName())
            .append("\nalbumNo: ").append(student.getAlbumNo());
        if (student.getCourses() != null)
            sb.append("\ncourses: ").append(student.getCourses().getCourse());
        return sb.toString();
    }
    private static String printStudentList(List<Student> students) {
        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            sb.append(printStudent(student));
        }
        return sb.toString();
    }

    // Path of a file
    static String FILEPATH = "gotAvatar.png";
    static File file = new File(FILEPATH);

    // Method which write the bytes into a file
    static void writeByte(byte[] bytes)
    {
        try {
            OutputStream os = new FileOutputStream(file);
            os.write(bytes);
            os.close();
            Desktop dt = Desktop.getDesktop();
            dt.open(file);
        }
        catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }



}
