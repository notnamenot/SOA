package test;

import pl.edu.agh.soa.model.Student;

public class TestClient {
    public static void main(String[] args) {

        Client client = new Client();

//        System.out.println(client.getStudents()); // 200
//        System.out.println(client.getStudents("SOA")); // 200
//        System.out.println(client.getStudent(666670)); // 200
//        System.out.println(client.getStudent(30)); // doesn't exist - 404
//        System.out.println(client.getStudentCourses(666671)); // 200
//
//        String token = client.getToken("ninja","ninja"); // valid for 15min
//        Student student = Student.builder()
//                .firstName("Anna")
//                .lastName("Nowak")
//                .albumNo(666556)
//                .addCourse("IO")
//                .build();
//        client.addStudent(student, token); // 201
//
//        student.setAlbumNr(666556); // already exists
//        client.addStudent(student, token); // 409
//
//        student.addCourse("UNIX");
//        client.updateStudent(student, token); // 204
//
//        student.setAlbumNr(667);    // doesn't exist
//        client.updateStudent(student, token); // 404
//
//        client.deleteStudent(666556, token); // 204
//        client.deleteStudent(667, token); // 404
//
//        //client.getAvatar();
//
//        System.out.println(client.getProtoBuffStudent());

        System.out.println(client.getStudentGroup(666671));
    }
}
