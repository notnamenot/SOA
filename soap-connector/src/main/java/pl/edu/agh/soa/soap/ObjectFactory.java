
package pl.edu.agh.soa.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pl.edu.agh.soa.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddCourseToStudent_QNAME = new QName("https://soap.soa.pl/lab1/ws", "addCourseToStudent");
    private final static QName _AddCourseToStudentResponse_QNAME = new QName("https://soap.soa.pl/lab1/ws", "addCourseToStudentResponse");
    private final static QName _AddStudent_QNAME = new QName("https://soap.soa.pl/lab1/ws", "addStudent");
    private final static QName _AddStudentResponse_QNAME = new QName("https://soap.soa.pl/lab1/ws", "addStudentResponse");
    private final static QName _DeleteStudentCourse_QNAME = new QName("https://soap.soa.pl/lab1/ws", "deleteStudentCourse");
    private final static QName _DeleteStudentCourseResponse_QNAME = new QName("https://soap.soa.pl/lab1/ws", "deleteStudentCourseResponse");
    private final static QName _GetAllStudents_QNAME = new QName("https://soap.soa.pl/lab1/ws", "getAllStudents");
    private final static QName _GetAllStudentsResponse_QNAME = new QName("https://soap.soa.pl/lab1/ws", "getAllStudentsResponse");
    private final static QName _GetAvatar_QNAME = new QName("https://soap.soa.pl/lab1/ws", "getAvatar");
    private final static QName _GetAvatarResponse_QNAME = new QName("https://soap.soa.pl/lab1/ws", "getAvatarResponse");
    private final static QName _GetStudentByAlbumNo_QNAME = new QName("https://soap.soa.pl/lab1/ws", "getStudentByAlbumNo");
    private final static QName _GetStudentByAlbumNoResponse_QNAME = new QName("https://soap.soa.pl/lab1/ws", "getStudentByAlbumNoResponse");
    private final static QName _GetStudentCourses_QNAME = new QName("https://soap.soa.pl/lab1/ws", "getStudentCourses");
    private final static QName _GetStudentCoursesResponse_QNAME = new QName("https://soap.soa.pl/lab1/ws", "getStudentCoursesResponse");
    private final static QName _GetStudentsAttendingCourse_QNAME = new QName("https://soap.soa.pl/lab1/ws", "getStudentsAttendingCourse");
    private final static QName _GetStudentsAttendingCourseResponse_QNAME = new QName("https://soap.soa.pl/lab1/ws", "getStudentsAttendingCourseResponse");
    private final static QName _SayHello_QNAME = new QName("https://soap.soa.pl/lab1/ws", "sayHello");
    private final static QName _SayHelloResponse_QNAME = new QName("https://soap.soa.pl/lab1/ws", "sayHelloResponse");
    private final static QName _Student_QNAME = new QName("https://soap.soa.pl/lab1/ws", "student");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.edu.agh.soa.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link AddCourseToStudent }
     * 
     */
    public AddCourseToStudent createAddCourseToStudent() {
        return new AddCourseToStudent();
    }

    /**
     * Create an instance of {@link AddCourseToStudentResponse }
     * 
     */
    public AddCourseToStudentResponse createAddCourseToStudentResponse() {
        return new AddCourseToStudentResponse();
    }

    /**
     * Create an instance of {@link AddStudent }
     * 
     */
    public AddStudent createAddStudent() {
        return new AddStudent();
    }

    /**
     * Create an instance of {@link AddStudentResponse }
     * 
     */
    public AddStudentResponse createAddStudentResponse() {
        return new AddStudentResponse();
    }

    /**
     * Create an instance of {@link DeleteStudentCourse }
     * 
     */
    public DeleteStudentCourse createDeleteStudentCourse() {
        return new DeleteStudentCourse();
    }

    /**
     * Create an instance of {@link DeleteStudentCourseResponse }
     * 
     */
    public DeleteStudentCourseResponse createDeleteStudentCourseResponse() {
        return new DeleteStudentCourseResponse();
    }

    /**
     * Create an instance of {@link GetAllStudents }
     * 
     */
    public GetAllStudents createGetAllStudents() {
        return new GetAllStudents();
    }

    /**
     * Create an instance of {@link GetAllStudentsResponse }
     * 
     */
    public GetAllStudentsResponse createGetAllStudentsResponse() {
        return new GetAllStudentsResponse();
    }

    /**
     * Create an instance of {@link GetAvatar }
     * 
     */
    public GetAvatar createGetAvatar() {
        return new GetAvatar();
    }

    /**
     * Create an instance of {@link GetAvatarResponse }
     * 
     */
    public GetAvatarResponse createGetAvatarResponse() {
        return new GetAvatarResponse();
    }

    /**
     * Create an instance of {@link GetStudentByAlbumNo }
     * 
     */
    public GetStudentByAlbumNo createGetStudentByAlbumNo() {
        return new GetStudentByAlbumNo();
    }

    /**
     * Create an instance of {@link GetStudentByAlbumNoResponse }
     * 
     */
    public GetStudentByAlbumNoResponse createGetStudentByAlbumNoResponse() {
        return new GetStudentByAlbumNoResponse();
    }

    /**
     * Create an instance of {@link GetStudentCourses }
     * 
     */
    public GetStudentCourses createGetStudentCourses() {
        return new GetStudentCourses();
    }

    /**
     * Create an instance of {@link GetStudentCoursesResponse }
     * 
     */
    public GetStudentCoursesResponse createGetStudentCoursesResponse() {
        return new GetStudentCoursesResponse();
    }

    /**
     * Create an instance of {@link GetStudentsAttendingCourse }
     * 
     */
    public GetStudentsAttendingCourse createGetStudentsAttendingCourse() {
        return new GetStudentsAttendingCourse();
    }

    /**
     * Create an instance of {@link GetStudentsAttendingCourseResponse }
     * 
     */
    public GetStudentsAttendingCourseResponse createGetStudentsAttendingCourseResponse() {
        return new GetStudentsAttendingCourseResponse();
    }

    /**
     * Create an instance of {@link SayHello }
     * 
     */
    public SayHello createSayHello() {
        return new SayHello();
    }

    /**
     * Create an instance of {@link SayHelloResponse }
     * 
     */
    public SayHelloResponse createSayHelloResponse() {
        return new SayHelloResponse();
    }

    /**
     * Create an instance of {@link Student.Courses }
     * 
     */
    public Student.Courses createStudentCourses() {
        return new Student.Courses();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCourseToStudent }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddCourseToStudent }{@code >}
     */
    @XmlElementDecl(namespace = "https://soap.soa.pl/lab1/ws", name = "addCourseToStudent")
    public JAXBElement<AddCourseToStudent> createAddCourseToStudent(AddCourseToStudent value) {
        return new JAXBElement<AddCourseToStudent>(_AddCourseToStudent_QNAME, AddCourseToStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCourseToStudentResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddCourseToStudentResponse }{@code >}
     */
    @XmlElementDecl(namespace = "https://soap.soa.pl/lab1/ws", name = "addCourseToStudentResponse")
    public JAXBElement<AddCourseToStudentResponse> createAddCourseToStudentResponse(AddCourseToStudentResponse value) {
        return new JAXBElement<AddCourseToStudentResponse>(_AddCourseToStudentResponse_QNAME, AddCourseToStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudent }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddStudent }{@code >}
     */
    @XmlElementDecl(namespace = "https://soap.soa.pl/lab1/ws", name = "addStudent")
    public JAXBElement<AddStudent> createAddStudent(AddStudent value) {
        return new JAXBElement<AddStudent>(_AddStudent_QNAME, AddStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudentResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddStudentResponse }{@code >}
     */
    @XmlElementDecl(namespace = "https://soap.soa.pl/lab1/ws", name = "addStudentResponse")
    public JAXBElement<AddStudentResponse> createAddStudentResponse(AddStudentResponse value) {
        return new JAXBElement<AddStudentResponse>(_AddStudentResponse_QNAME, AddStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteStudentCourse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteStudentCourse }{@code >}
     */
    @XmlElementDecl(namespace = "https://soap.soa.pl/lab1/ws", name = "deleteStudentCourse")
    public JAXBElement<DeleteStudentCourse> createDeleteStudentCourse(DeleteStudentCourse value) {
        return new JAXBElement<DeleteStudentCourse>(_DeleteStudentCourse_QNAME, DeleteStudentCourse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteStudentCourseResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteStudentCourseResponse }{@code >}
     */
    @XmlElementDecl(namespace = "https://soap.soa.pl/lab1/ws", name = "deleteStudentCourseResponse")
    public JAXBElement<DeleteStudentCourseResponse> createDeleteStudentCourseResponse(DeleteStudentCourseResponse value) {
        return new JAXBElement<DeleteStudentCourseResponse>(_DeleteStudentCourseResponse_QNAME, DeleteStudentCourseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllStudents }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllStudents }{@code >}
     */
    @XmlElementDecl(namespace = "https://soap.soa.pl/lab1/ws", name = "getAllStudents")
    public JAXBElement<GetAllStudents> createGetAllStudents(GetAllStudents value) {
        return new JAXBElement<GetAllStudents>(_GetAllStudents_QNAME, GetAllStudents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllStudentsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllStudentsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "https://soap.soa.pl/lab1/ws", name = "getAllStudentsResponse")
    public JAXBElement<GetAllStudentsResponse> createGetAllStudentsResponse(GetAllStudentsResponse value) {
        return new JAXBElement<GetAllStudentsResponse>(_GetAllStudentsResponse_QNAME, GetAllStudentsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAvatar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAvatar }{@code >}
     */
    @XmlElementDecl(namespace = "https://soap.soa.pl/lab1/ws", name = "getAvatar")
    public JAXBElement<GetAvatar> createGetAvatar(GetAvatar value) {
        return new JAXBElement<GetAvatar>(_GetAvatar_QNAME, GetAvatar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAvatarResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAvatarResponse }{@code >}
     */
    @XmlElementDecl(namespace = "https://soap.soa.pl/lab1/ws", name = "getAvatarResponse")
    public JAXBElement<GetAvatarResponse> createGetAvatarResponse(GetAvatarResponse value) {
        return new JAXBElement<GetAvatarResponse>(_GetAvatarResponse_QNAME, GetAvatarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentByAlbumNo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentByAlbumNo }{@code >}
     */
    @XmlElementDecl(namespace = "https://soap.soa.pl/lab1/ws", name = "getStudentByAlbumNo")
    public JAXBElement<GetStudentByAlbumNo> createGetStudentByAlbumNo(GetStudentByAlbumNo value) {
        return new JAXBElement<GetStudentByAlbumNo>(_GetStudentByAlbumNo_QNAME, GetStudentByAlbumNo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentByAlbumNoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentByAlbumNoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "https://soap.soa.pl/lab1/ws", name = "getStudentByAlbumNoResponse")
    public JAXBElement<GetStudentByAlbumNoResponse> createGetStudentByAlbumNoResponse(GetStudentByAlbumNoResponse value) {
        return new JAXBElement<GetStudentByAlbumNoResponse>(_GetStudentByAlbumNoResponse_QNAME, GetStudentByAlbumNoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentCourses }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentCourses }{@code >}
     */
    @XmlElementDecl(namespace = "https://soap.soa.pl/lab1/ws", name = "getStudentCourses")
    public JAXBElement<GetStudentCourses> createGetStudentCourses(GetStudentCourses value) {
        return new JAXBElement<GetStudentCourses>(_GetStudentCourses_QNAME, GetStudentCourses.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentCoursesResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentCoursesResponse }{@code >}
     */
    @XmlElementDecl(namespace = "https://soap.soa.pl/lab1/ws", name = "getStudentCoursesResponse")
    public JAXBElement<GetStudentCoursesResponse> createGetStudentCoursesResponse(GetStudentCoursesResponse value) {
        return new JAXBElement<GetStudentCoursesResponse>(_GetStudentCoursesResponse_QNAME, GetStudentCoursesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsAttendingCourse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentsAttendingCourse }{@code >}
     */
    @XmlElementDecl(namespace = "https://soap.soa.pl/lab1/ws", name = "getStudentsAttendingCourse")
    public JAXBElement<GetStudentsAttendingCourse> createGetStudentsAttendingCourse(GetStudentsAttendingCourse value) {
        return new JAXBElement<GetStudentsAttendingCourse>(_GetStudentsAttendingCourse_QNAME, GetStudentsAttendingCourse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsAttendingCourseResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentsAttendingCourseResponse }{@code >}
     */
    @XmlElementDecl(namespace = "https://soap.soa.pl/lab1/ws", name = "getStudentsAttendingCourseResponse")
    public JAXBElement<GetStudentsAttendingCourseResponse> createGetStudentsAttendingCourseResponse(GetStudentsAttendingCourseResponse value) {
        return new JAXBElement<GetStudentsAttendingCourseResponse>(_GetStudentsAttendingCourseResponse_QNAME, GetStudentsAttendingCourseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHello }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SayHello }{@code >}
     */
    @XmlElementDecl(namespace = "https://soap.soa.pl/lab1/ws", name = "sayHello")
    public JAXBElement<SayHello> createSayHello(SayHello value) {
        return new JAXBElement<SayHello>(_SayHello_QNAME, SayHello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHelloResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SayHelloResponse }{@code >}
     */
    @XmlElementDecl(namespace = "https://soap.soa.pl/lab1/ws", name = "sayHelloResponse")
    public JAXBElement<SayHelloResponse> createSayHelloResponse(SayHelloResponse value) {
        return new JAXBElement<SayHelloResponse>(_SayHelloResponse_QNAME, SayHelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Student }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Student }{@code >}
     */
    @XmlElementDecl(namespace = "https://soap.soa.pl/lab1/ws", name = "student")
    public JAXBElement<Student> createStudent(Student value) {
        return new JAXBElement<Student>(_Student_QNAME, Student.class, null, value);
    }

}
