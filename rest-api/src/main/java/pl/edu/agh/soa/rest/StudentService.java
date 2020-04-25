package pl.edu.agh.soa.rest;

//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import pl.edu.agh.soa.rest.jwt.JWTTokenNeeded;
import pl.edu.agh.soa.model.Student;
import pl.edu.agh.soa.model.StudentList;

//import javax.crypto.KeyGenerator;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Base64;
//import utils.Base64Utils;
import org.apache.commons.io.IOUtils;

//import static io.jsonwebtoken.impl.JwtMap.toDate;
//import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static org.jboss.ws.api.Log.LOGGER;

@Path("students")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
//@Stateless
public class StudentService {

    @Context
    private UriInfo uriInfo;

    @Inject
    private StudentList students; //instance żeby przy każdym żądaniu był nowy obiekt

//    @Inject
//    private KeyGenerator keyGenerator;

    @GET
    @Path("/")
    public Response getStudents(@QueryParam("course") String course,
                                @QueryParam("firstName") String firstName) {
        List<Student> filteredStudents = students.filter(course, firstName);
        LOGGER.info("getStudents:\tcourse:\n " + course + ";firsName:" + firstName + ";filteredStudents:" + filteredStudents.toString());
        return Response.ok(filteredStudents).status(Response.Status.OK).variant(null).build(); //200
    }

    @GET
    @Path("/{albumNo}")
    public Response getStudentByAlbumNo(@PathParam("albumNo") int albumNo) {
        if (!students.exists(albumNo))
            return Response.notModified().status(Response.Status.NOT_FOUND).build(); //404

        Student student = students.getStudent(albumNo);
        LOGGER.info("getStudentByAlbumNo:\talbumNo\n " + albumNo + ";student:\n" + student);
        return Response.ok(student).status(Response.Status.OK).build();    // 200
    }

    @GET
    @Path("/{albumNo}/courses")
    public Response getStudentCourses(@PathParam("albumNo") int albumNo) {
        if (!students.exists(albumNo))
            return Response.notModified().status(Response.Status.NOT_FOUND).build(); //404

        List<String> studentCourses = students.getStudent(albumNo).getCourses();
        LOGGER.info("getStudentByAlbumNo:\n " + albumNo + "\n" + studentCourses);
        return Response.ok(studentCourses).status(Response.Status.OK).build();    // 200
    }

    @GET
//    @Path("/{albumNo}/avatar")
    @Path("avatar")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getStudentAvatar() throws IOException {
//        if (!students.exists(albumNo))
//            return Response.notModified().status(Response.Status.NOT_FOUND).build(); //404

//        return Response.ok(Base64Utils.encoder("/home/piotr/SOA/Zadanie1/lab/soap-api/src/main/resources/avatar.png"))
//                .status(Response.Status.OK).build();

        String fileName = "/avatar.png";
        InputStream inputStream = this.getClass().getResourceAsStream(fileName);
        System.out.println(inputStream);
        byte[] targetArray = new byte[inputStream.available()];
//        inputStream.read(targetArray);
        String encoded = Base64.getEncoder().encodeToString(targetArray);

        File file = new File("resources/avatar.png");
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);

        InputStream inputStream2 = this.getClass().getResourceAsStream("avatar.png");
        byte[] targetArray2 = new byte[inputStream.available()];
        String encoded2 = Base64.getEncoder().encodeToString(targetArray2);

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL resource = classLoader.getResource( "avatar.png");
        System.out.println("URL:" + resource.toString());

        InputStream resource2 = classLoader.getResourceAsStream("avatar.png");
        System.out.println("InputStream" + resource2.available());
        byte[] targetArray3 = new byte[resource2.available()];
        String encoded3 = Base64.getEncoder().encodeToString(targetArray3);

        byte[] bytes = IOUtils.toByteArray(resource2);
//        File file2 = new File(resource.getFile());
//        String absolutePath2 = file.getAbsolutePath();
//        System.out.println("ap" + absolutePath2);
//        String encoded3 = Base64.getEncoder().encodeToString( Files.readAllBytes(file2.toPath()));

//        URL resource2 = this.getClass().getResource("avatar.png");
//        InputStream inputStream3 = resource2.openStream();

        return Response.ok(encoded3).status(Response.Status.OK).build();    // 200
    }

    @POST
    @Path("/")
//    @JWTTokenNeeded  // annotation that binds to a filter
    public Response addStudentWithFirstNameLastNameAlbumNo(Student student) {

        URI uri =  uriInfo.getAbsolutePath(); //żeby zwrócić ścieżkę do nowego zasobu
        LOGGER.info("addStudentWithFirstNameLastNameAlbumNo:\n " + student.toString());

        /*
        LOGGER.info("getAbsolutePath:\n " + uri);
        LOGGER.info("getPath:\n " + uriInfo.getPath());
        LOGGER.info("getBaseUri:\n " + uriInfo.getBaseUri());
        LOGGER.info("getRequestUri:\n " + uriInfo.getRequestUri());
        LOGGER.info("getMatchedURIs:\n " + uriInfo.getMatchedURIs());
        LOGGER.info("getPathParameters:\n " + uriInfo.getPathParameters());
        LOGGER.info("getPathSegments:\n " + uriInfo.getPathSegments());
         */

        if (students.exists(student.getAlbumNo()))
            return Response.notModified().status(Response.Status.CONFLICT).build(); //409 The request could not be completed due to a conflict with the current state of the resource.
        else {
            students.addStudent(student);
            LOGGER.info("addStudentWithFirstNameLastNameAlbumNo:\n " + students.toString());
            return Response.ok(student).status(Response.Status.CREATED).build(); //.created(uri) // 201
        }
    }

    @PUT
    @Path("/")
    public Response editStudent(Student student) {
        if (!students.exists(student.getAlbumNo()))
            return Response.notModified().status(Response.Status.NOT_FOUND).build();

        students.getStudent(student.getAlbumNo()).updateFromStudent(student);
        return Response.ok().status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{albumNo}")
    public Response deleteStudent(@PathParam("albumNo") int albumNo) {
        if (!students.exists(albumNo))
            return Response.notModified().status(Response.Status.NOT_FOUND).build(); //404

        students.deleteStudent(albumNo);
        return Response.ok().status(Response.Status.NO_CONTENT).build(); //204
    }
//
//    @POST
//    @Path("login")
//    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//    public Response authenticateUser(@FormParam("login") String login,
//                                     @FormParam("password") String password) {
//        try {
//
//            // Authenticate the user using the credentials provided
////            authenticate(login, password);
//
//            // Issue a token for the user
//            String token = issueToken(login);
//
//            // Return the token on the response
//            return Response.ok().header(AUTHORIZATION, "Bearer " + token).build();
//
//        } catch (Exception e) {
//            return Response.status(Response.Status.UNAUTHORIZED).build();
//        }
//    }

//    private String issueToken(String login) {
//        Key key = keyGenerator.generateKey();
//        String jwtToken = Jwts.builder()
//                .setSubject(login)
//                .setIssuer(uriInfo.getAbsolutePath().toString())
//                .setIssuedAt(new Date())
//                .setExpiration(Date.from(LocalDateTime.now().plusMinutes(15L).atZone(ZoneId.systemDefault()).toInstant()))
//                .signWith(SignatureAlgorithm.HS512, key)
//                .compact();
//        return jwtToken;
//    }

//    private Student addNewStudent(Student student) {
////        List<Student> students = initialStudentList();
//        Student newStudent = Student.builder()
//                .firstName(student.getFirsName())
//                .lastName(student.getLastName())
//                .albumNo(student.getAlbumNo())
//                .courses(student.getCourses())
//                .build();
////        students.addStudent(newStudent);
//        return newStudent;
//    }



//    private boolean studentExists(int albumNo) {
////        List<Student> students = initialStudentList();
////        return false;//students.getAll().stream().anyMatch(s -> s.getAlbumNo() == (albumNo));
//        return students.getStudent(albumNo) != null;
//    }
//
//    private Student findStudent(int albumNo) {
//         return students
//                .getAll()
//                .stream()
//                .filter(s -> s.getAlbumNo() == albumNo)
//                .findFirst()
//                .orElse(null);
//    }

//    private List<Student> findStudentsWithCourse(String course) {
//        return students
//                .getAll()
//                .stream()
//                .filter(s -> s.getCourses().contains(course))
//                .collect(toList());
////                .collect(Collectors.toList());
////                .findFirst()
////                .orElse(null);
//    }


    // our "database"
//    private List<Student> initialStudentList() {
//        Student student1 = Student.builder()
//                .firstName("Jan")
//                .lastName("Kowalski")
//                .albumNo(20)
//                .addCourse("SOA")
//                .addCourse("IO")
//                .build();
//        Student student2 = Student.builder()
//                .firstName("Anna")
//                .lastName("Nowak")
//                .albumNo(30)
//                .addCourse("SOA")
//                .addCourse("IO")
//                .build();
//        Student student3 = Student.builder()
//                .firstName("Ewa")
//                .lastName("Wąż")
//                .albumNo(50)
//                .addCourse("UNIX")
//                .addCourse("IO")
//                .build();
//        Student student4 = Student.builder()
//                .firstName("Adam")
//                .lastName("Chwast")
//                .albumNo(60)
//                .build();
//        //return Arrays.asList(student1, student2, student3, student4);
//        //https://javastart.pl/baza-wiedzy/wyjatki/unsupportedoperationexception
//        return new ArrayList<>(Arrays.asList(student1, student2, student3, student4));
//    }
}
