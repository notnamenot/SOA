package pl.edu.agh.soa.rest;

import io.swagger.jaxrs.config.BeanConfig;
import pl.edu.agh.soa.rest.jwt.JWTTokenNeededFilter;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

// albo to albo zmiana web.xml i pom.xml
@ApplicationPath("/api")
public class StudentServiceApp extends Application {

    public StudentServiceApp() {
        init();
    }

//    @Override
//    public Set<Class<?>> getClasses() {
//        HashSet<Class<?>> classes = new HashSet<>();
//        classes.add(StudentService.class);
//        classes.add(JWTTokenNeededFilter.class);
//
//        classes.add(io.swagger.jaxrs.listing.ApiListingResource.class);
//        classes.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
//        return classes;
//    }



    private void init() {
        // Swagger class that holds its configuration
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
//        beanConfig.setSchemes(new String[] {"http"});
//        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/rest-api/api"); // auto-generate a swagger.json here, context-root
        beanConfig.setResourcePackage("pl.edu.agh.soa.rest");
        beanConfig.setTitle("Student service documentation");
        beanConfig.setScan(true);
    }
    // http://localhost:8080/rest-api/api/swagger.json
    // http://localhost:8080/rest-api/docs
}
