package pl.edu.agh.soa.model;

//PROTO
//lab1> .\protoc-3.6.1-win32\bin\protoc.exe -I=.\lab1-model\src\main\java\pl\edu\agh\soa\model --java_out=.\lab1-model\src\main\java student.proto
//https://developers.google.com/protocol-buffers/docs/javatutorial

//import com.vladmihalcea.hibernate.type.array.ListArrayType;

//import javax.persistence.Basic;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;

@XmlRootElement(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
//@Entity(name="Student")
//@TypeDef(
//        name = "list-array",
//        typeClass = ListArrayType.class
//)
public class Student implements Serializable {

    private String firstName;
    private String lastName;
//    @Id
//    @GeneratedValue
    private int albumNo;
//    @XmlElementWrapper(name="courses")
//    @XmlElement(name="course")
    private List<String> courses;
//    private byte[] avatar;

    public Student() {}

    public static Student emptyStudent(){
        return builder().firstName("None").lastName("None").albumNo(0).build();
    }

    public String getFirstName() { return firstName; }
    public int getAlbumNo() { return albumNo; }
    public String getLastName() { return lastName; }
    public List<String> getCourses() { return courses; }
//    public byte[] getAvatar() { return avatar; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setAlbumNr(int albumNo) { this.albumNo = albumNo; }
    public void setCourses(List<String> courses) { this.courses = courses; }
//    public void setAvatar(byte[] avatar) { this.avatar = avatar; }

    public void updateFromStudent(Student student) {
        this.setFirstName(student.getFirstName());
        this.setLastName(student.getLastName());
        this.setCourses(student.getCourses());
        //you can't change albumNo!
    }

    public static final class Builder {
        private String firstName;
        private String lastName;
        private int albumNo;
        private List<String> courses;
        private byte[] avatar;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder albumNo(int albumNo) {
            this.albumNo = albumNo;
            return this;
        }

        public Builder courses(List<String> courses) {
            this.courses = courses;
            return this;
        }

        public Builder addCourse(String course){
            if (this.courses == null)
                this.courses = new ArrayList<>();
            this.courses.add(course);
            return this;
        }

        public Student build() {
            if (firstName.isEmpty() || lastName.isEmpty()){
                throw new IllegalStateException("First and last name can't be empty!");
            }
            if (albumNo == 0){
                throw new IllegalStateException("AlbumNo can't be empty!");
            }

            Student student = new Student();
            student.firstName = this.firstName;
            student.lastName = this.lastName;
            student.albumNo = this.albumNo;
            if (null == this.courses)
                student.courses = new ArrayList<>();
            else
                student.courses = this.courses;

            return student;
        }
    }

    public static Builder builder() {
        return new Builder();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\nfirstName: ").append(this.firstName)
            .append("\nlastName: ").append(this.lastName)
            .append("\nalbumNo: ").append(this.albumNo)
            .append("\ncourses: ").append(this.courses).append("\n");

        return sb.toString();
    }

    public void addCourse(String course){
        if (this.courses == null)
            this.courses = new ArrayList<>();
        this.courses.add(course);
    }

    public void deleteCourse(String course) {
        if (this.courses == null)
            return;
        this.courses.remove(course);
    }
}
