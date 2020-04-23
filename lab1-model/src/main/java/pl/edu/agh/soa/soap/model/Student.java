package pl.edu.agh.soa.soap.model;
//import pl.edu.agh.soa.soap.model.Student;


import javax.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {

    private String firstName;
    private String lastName;
    private int albumNo;
    @XmlElementWrapper(name="courses")
    @XmlElement(name="course")
    private List<String> courses;
    private byte[] avatar;

    public Student() {}

    public static Student emptyStudent(){
        return builder().firstName("None").lastName("None").albumNo(0).build();
    }

    public String getFirsName() { return firstName; }
    public int getAlbumNo() { return albumNo; }
    public String getLastName() { return lastName; }
    public List<String> getCourses() { return courses; }
    public byte[] getAvatar() { return avatar; }

    public void setFirsName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setAlbumNr(int albumNo) { this.albumNo = albumNo; }
    public void setCourses(List<String> courses) { this.courses = courses; }
    public void setAvatar(byte[] avatar) { this.avatar = avatar; }

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

        public Builder addCourse(String course){ //sprawdzac czy jest zainicjowana
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
            student.courses = this.courses;

            return student;
        }

    }

    public static Builder builder() {
        return new Builder();
    }


    @Override
    public String toString() {
        return "firstName: " + this.firstName +
                "\nlastName: " + this.lastName  +
                "\nalbumNo: " + this.albumNo +
                "\ncourses:" + this.courses;
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
