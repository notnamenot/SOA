package test;

import pl.edu.agh.soa.model.Contact;
import pl.edu.agh.soa.model.Student;

public class TestClient {
    public static void main(String[] args) {

        Client client = new Client();

        System.out.println(client.getStudents()); // 200
        System.out.println(client.getStudents("SOA")); // 200
        System.out.println(client.getStudent(666670)); // 200
        System.out.println(client.getStudent(30)); //  404
        System.out.println(client.getStudentCourses(666671)); // 200

        String token = client.getToken("ninja","ninja"); // valid for 15min
        Student student = Student.builder()
                .firstName("Ewa")
                .lastName("Nowa")
                .albumNo(666559)
                .addCourse("SOA")
                .addCourse("UNIX")
                .build();
        client.addStudent(student, token); // 201

        student.setAlbumNr(666558); // already exists
        client.addStudent(student, token); // 409

        student.addCourse("UNIX");
        client.updateStudent(student, token); // 204

        student.setAlbumNr(667);    // doesn't exist
        client.updateStudent(student, token); // 404

        client.deleteStudent(666556, token); // 204
        client.deleteStudent(667, token); // 404

        client.getAvatar();

        System.out.println(client.getProtoBuffStudent());

        System.out.println(client.getStudentGroup(666671)); // 200
        System.out.println(client.getStudentGroup(666670)); // 404

        Contact contact = new Contact(666670,608553669);
        client.addContact(contact,token); // 409

        System.out.println(client.getContact(666670)); // 200

        client.close();
    }
}
