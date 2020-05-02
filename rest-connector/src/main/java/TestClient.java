import pl.edu.agh.soa.model.Student;

import java.io.IOException;

public class TestClient {
    public static void main(String[] args) {

        Client client = new Client();

        System.out.println(client.getStudents()); // 200
        System.out.println(client.getStudents("SOA")); // 200
        System.out.println(client.getStudent(30)); // 200
        System.out.println(client.getStudent(10)); // doesn't exist - 404
        System.out.println(client.getStudentCourses(30)); // 200

        String token = client.getToken("ninja","ninja"); // valid for 15min
        Student student = Student.builder()
                .firstName("Ala")
                .lastName("Makota")
                .albumNo(666)
                .addCourse("SOA")
                .addCourse("IO")
                .build();
        client.addStudent(student, token); // 201

        student.setAlbumNr(30); // already exists
        client.addStudent(student, token); // 409

        student.addCourse("UNIX");
        client.updateStudent(student, token); // 204

        student.setAlbumNr(667);    // doesn't exist
        client.updateStudent(student, token); // 404

        client.deleteStudent(30, token); // 204
        client.deleteStudent(667, token); // 404

        client.getAvatar();

        client.close();
    }
}
