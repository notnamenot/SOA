
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

    private final static QName _AddCourseToStudent_QNAME = new QName("http://soap.soa.agh.edu.pl/", "addCourseToStudent");
    private final static QName _AddCourseToStudentResponse_QNAME = new QName("http://soap.soa.agh.edu.pl/", "addCourseToStudentResponse");
    private final static QName _AddStudentWithFirstNameLastNameAlbumNo_QNAME = new QName("http://soap.soa.agh.edu.pl/", "addStudentWithFirstNameLastNameAlbumNo");
    private final static QName _AddStudentWithFirstNameLastNameAlbumNoResponse_QNAME = new QName("http://soap.soa.agh.edu.pl/", "addStudentWithFirstNameLastNameAlbumNoResponse");
    private final static QName _DeleteStudentCourse_QNAME = new QName("http://soap.soa.agh.edu.pl/", "deleteStudentCourse");
    private final static QName _DeleteStudentCourseResponse_QNAME = new QName("http://soap.soa.agh.edu.pl/", "deleteStudentCourseResponse");
    private final static QName _GetAllStudents_QNAME = new QName("http://soap.soa.agh.edu.pl/", "getAllStudents");
    private final static QName _GetAllStudentsResponse_QNAME = new QName("http://soap.soa.agh.edu.pl/", "getAllStudentsResponse");
    private final static QName _GetAvatar_QNAME = new QName("http://soap.soa.agh.edu.pl/", "getAvatar");
    private final static QName _GetAvatarResponse_QNAME = new QName("http://soap.soa.agh.edu.pl/", "getAvatarResponse");
    private final static QName _GetStudentByAlbumNo_QNAME = new QName("http://soap.soa.agh.edu.pl/", "getStudentByAlbumNo");
    private final static QName _GetStudentByAlbumNoResponse_QNAME = new QName("http://soap.soa.agh.edu.pl/", "getStudentByAlbumNoResponse");
    private final static QName _GetStudentCourses_QNAME = new QName("http://soap.soa.agh.edu.pl/", "getStudentCourses");
    private final static QName _GetStudentCoursesResponse_QNAME = new QName("http://soap.soa.agh.edu.pl/", "getStudentCoursesResponse");
    private final static QName _GetStudentsAttendingCourse_QNAME = new QName("http://soap.soa.agh.edu.pl/", "getStudentsAttendingCourse");
    private final static QName _GetStudentsAttendingCourseResponse_QNAME = new QName("http://soap.soa.agh.edu.pl/", "getStudentsAttendingCourseResponse");
    private final static QName _SayHello_QNAME = new QName("http://soap.soa.agh.edu.pl/", "sayHello");
    private final static QName _SayHelloResponse_QNAME = new QName("http://soap.soa.agh.edu.pl/", "sayHelloResponse");
    private final static QName _Student_QNAME = new QName("http://soap.soa.agh.edu.pl/", "student");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.edu.agh.soa.soap
     * 
     */
    public ObjectFactory() {
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
     * Create an instance of {@link AddStudentWithFirstNameLastNameAlbumNo }
     * 
     */
    public AddStudentWithFirstNameLastNameAlbumNo createAddStudentWithFirstNameLastNameAlbumNo() {
        return new AddStudentWithFirstNameLastNameAlbumNo();
    }

    /**
     * Create an instance of {@link AddStudentWithFirstNameLastNameAlbumNoResponse }
     * 
     */
    public AddStudentWithFirstNameLastNameAlbumNoResponse createAddStudentWithFirstNameLastNameAlbumNoResponse() {
        return new AddStudentWithFirstNameLastNameAlbumNoResponse();
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
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCourseToStudent }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddCourseToStudent }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.soa.agh.edu.pl/", name = "addCourseToStudent")
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
    @XmlElementDecl(namespace = "http://soap.soa.agh.edu.pl/", name = "addCourseToStudentResponse")
    public JAXBElement<AddCourseToStudentResponse> createAddCourseToStudentResponse(AddCourseToStudentResponse value) {
        return new JAXBElement<AddCourseToStudentResponse>(_AddCourseToStudentResponse_QNAME, AddCourseToStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudentWithFirstNameLastNameAlbumNo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddStudentWithFirstNameLastNameAlbumNo }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.soa.agh.edu.pl/", name = "addStudentWithFirstNameLastNameAlbumNo")
    public JAXBElement<AddStudentWithFirstNameLastNameAlbumNo> createAddStudentWithFirstNameLastNameAlbumNo(AddStudentWithFirstNameLastNameAlbumNo value) {
        return new JAXBElement<AddStudentWithFirstNameLastNameAlbumNo>(_AddStudentWithFirstNameLastNameAlbumNo_QNAME, AddStudentWithFirstNameLastNameAlbumNo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudentWithFirstNameLastNameAlbumNoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddStudentWithFirstNameLastNameAlbumNoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.soa.agh.edu.pl/", name = "addStudentWithFirstNameLastNameAlbumNoResponse")
    public JAXBElement<AddStudentWithFirstNameLastNameAlbumNoResponse> createAddStudentWithFirstNameLastNameAlbumNoResponse(AddStudentWithFirstNameLastNameAlbumNoResponse value) {
        return new JAXBElement<AddStudentWithFirstNameLastNameAlbumNoResponse>(_AddStudentWithFirstNameLastNameAlbumNoResponse_QNAME, AddStudentWithFirstNameLastNameAlbumNoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteStudentCourse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteStudentCourse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.soa.agh.edu.pl/", name = "deleteStudentCourse")
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
    @XmlElementDecl(namespace = "http://soap.soa.agh.edu.pl/", name = "deleteStudentCourseResponse")
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
    @XmlElementDecl(namespace = "http://soap.soa.agh.edu.pl/", name = "getAllStudents")
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
    @XmlElementDecl(namespace = "http://soap.soa.agh.edu.pl/", name = "getAllStudentsResponse")
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
    @XmlElementDecl(namespace = "http://soap.soa.agh.edu.pl/", name = "getAvatar")
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
    @XmlElementDecl(namespace = "http://soap.soa.agh.edu.pl/", name = "getAvatarResponse")
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
    @XmlElementDecl(namespace = "http://soap.soa.agh.edu.pl/", name = "getStudentByAlbumNo")
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
    @XmlElementDecl(namespace = "http://soap.soa.agh.edu.pl/", name = "getStudentByAlbumNoResponse")
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
    @XmlElementDecl(namespace = "http://soap.soa.agh.edu.pl/", name = "getStudentCourses")
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
    @XmlElementDecl(namespace = "http://soap.soa.agh.edu.pl/", name = "getStudentCoursesResponse")
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
    @XmlElementDecl(namespace = "http://soap.soa.agh.edu.pl/", name = "getStudentsAttendingCourse")
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
    @XmlElementDecl(namespace = "http://soap.soa.agh.edu.pl/", name = "getStudentsAttendingCourseResponse")
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
    @XmlElementDecl(namespace = "http://soap.soa.agh.edu.pl/", name = "sayHello")
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
    @XmlElementDecl(namespace = "http://soap.soa.agh.edu.pl/", name = "sayHelloResponse")
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
    @XmlElementDecl(namespace = "http://soap.soa.agh.edu.pl/", name = "student")
    public JAXBElement<Student> createStudent(Student value) {
        return new JAXBElement<Student>(_Student_QNAME, Student.class, null, value);
    }

}
