import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import pl.edu.agh.soa.model.Student;
import pl.edu.agh.soa.model.StudentOuterClass;
import pl.edu.agh.soa.model.User;

import javax.imageio.ImageIO;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Base64;
import java.util.List;

public class Client {

    private static final String BASE_API_URL = "http://localhost:8080/rest-api/api";

    private ResteasyClient client;
    private ResteasyWebTarget target;
    private Response response;

    public Client() {
        client = new ResteasyClientBuilder().build();
        target = client.target(BASE_API_URL);
    }

    public List<Student> getStudents(String course) {
        printMethodName();

        target = target.path("students");
        if (course != null) {
            target = target.queryParam("course",course);
        }

        response = target.request(MediaType.APPLICATION_JSON).get();
        printResponseStatusInfo();
        List<Student> students = response.readEntity(new GenericType<List<Student>>() {});
        reset();
        return students;
    }
    public List<Student> getStudents() {
        printMethodName();
        return getStudents(null);
    }

    public Student getStudent(int albumNo) {
        printMethodName();

        target = target.path("students").path(Integer.toString(albumNo));
        response = target.request().get();

        printResponseStatusInfo();

        Student student = null;
        if (response.getStatusInfo() == Response.Status.OK) {
            student = response.readEntity(new GenericType<Student>() {});
        }
        reset();
        return student;
    }

    public List<String> getStudentCourses(int albumNo) {
        printMethodName();

        target = target.path("students").path(Integer.toString(albumNo)).path("courses");
        response = target.request().get();

        printResponseStatusInfo();

        List<String> courses = null;
        if (response.getStatusInfo() == Response.Status.OK) {
            courses = response.readEntity(new GenericType<List<String>>() {});
        }
        reset();
        return courses;
    }

    public String getToken(String login, String pass) {
        printMethodName();

        User user = new User(login,pass);
        target = target.path("auth").path("login");

        response = target.request().post(Entity.entity(user, MediaType.APPLICATION_JSON));

        String token = response.getHeaderString("Authorization");
        System.out.println(token);

        reset();
        return token;
    }

    public void addStudent(Student student, String token) {
        printMethodName();

        target = target.path("students");
        response = target.request().header("Authorization", token).post(Entity.entity(student, MediaType.APPLICATION_JSON ));
        printResponseStatusInfo();

        reset();
    }

    public void updateStudent(Student student, String token) {
        printMethodName();

        target = target.path("students").path(Integer.toString(student.getAlbumNo()));
        response = target.request().header("Authorization", token).put(Entity.entity(student, MediaType.APPLICATION_JSON ));
        printResponseStatusInfo();

        reset();
    }

    public void deleteStudent(int albumNo,String token) {
        printMethodName();

        target = target.path("students").path(Integer.toString(albumNo));
        response = target.request().header("Authorization", token).delete();
        printResponseStatusInfo();

        reset();
    }

    public void getAvatar() {
        printMethodName();

        target = target.path("students").path("avatar");
        response = target.request().get();

        printResponseStatusInfo();

        String avatar = response.readEntity(String.class);
//        System.out.println(new String(avatar));

//        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
//        FileUtils.writeByteArrayToFile(new File(outputFileName), decodedBytes);

        byte[] decoded = Base64.getDecoder().decode(avatar);//.toString();
//        System.out.println(new String(decoded));

        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(decoded);
            BufferedImage bImage2 = ImageIO.read(bis);
            ImageIO.write(bImage2, "jpg", new File("output.jpg"));

            Desktop dt = Desktop.getDesktop();
            dt.open(new File("output.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reset();
        }
    }


    public String getProtoBuffStudent() {
        printMethodName();

        target = target.path("students").path("protobuf");

        InputStream response = target
                .request()
                .header("accept", "application/protobuf")
                .get(InputStream.class);
//        response = target.request().header("accept", "application/protobuf").get();

//        StudentOuterClass student = response.readEntity(new GenericType<StudentOuterClass>() {});
//        printResponseStatusInfo();
//        List<Student> students = response.readEntity(new GenericType<List<Student>>() {});

        try {
            StudentOuterClass.Student student = StudentOuterClass.Student.parseFrom(IOUtils.toByteArray(response));
            return student.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reset();
        }
        return "nope";
    }


    private void printMethodName() {
        System.out.println("\nMethod name: " + new Throwable().getStackTrace()[1].getMethodName());
    }

    private void printResponseStatusInfo() {
        System.out.println("Response: " + MessageFormat.format("{0} {1}", response.getStatus(), response.getStatusInfo()));
    }

    private void reset() {
        target = client.target(BASE_API_URL);
        response = null;
    }

    public void close() {
        this.client.close();
    }


}
