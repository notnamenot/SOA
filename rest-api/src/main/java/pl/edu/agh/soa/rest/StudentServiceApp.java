package pl.edu.agh.soa.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

// albo to albo zmiana web.xml i pom.xml
@ApplicationPath("/")
public class StudentServiceApp extends Application {

//    @Override
//    public Set<Class<?>> getClasses() {
//        HashSet<Class<?>> classes = new HashSet<>();
//        classes.add(StudentService.class);
//        return classes;
//    }

//    register(StudentService.class);
}
