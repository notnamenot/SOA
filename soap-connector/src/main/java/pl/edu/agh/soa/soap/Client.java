package pl.edu.agh.soa.soap;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

public class Client {
    public static void main(String[] args) {

        HelloWorldService service = new HelloWorldService();
        HelloWorldServiceType serviceType = service.getHelloWorldPort();
        setCredentials((BindingProvider)serviceType);

        Student addedStudent = serviceType.addStudent("Ala","Makota",123);
        System.out.println("addedStudent" + addedStudent);

        List<Student> students = serviceType.getStudentsAttendingCourse("SOA");
        System.out.println("listedStudents" + students);

        byte[] avatar = serviceType.getAvatar(30);
        avatar = Base64.getDecoder().decode(avatar);

    }

    public static void setCredentials(BindingProvider port){
        port.getRequestContext().put("javax.xml.ws.security.auth.username","ninja");
        port.getRequestContext().put("javax.xml.ws.security.auth.password","ninja");
    }

}
