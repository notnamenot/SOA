package pl.edu.agh.soa.jpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="student", schema = "dbo")
public class StudentEntity {
    @Id
    @Column(name="album_no", nullable = false)
    private Integer albumNo;
    @Column(name="first_name", nullable = false)
    private String firstName;
    @Column(name="last_name", nullable = false)
    private String lastName;


    @ManyToMany(targetEntity = CourseEntity.class)
    @JoinTable(
            name = "student_course",
            schema = "dbo",
            joinColumns = @JoinColumn(
                    name = "album_no",
                    referencedColumnName = "album_no"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "course",
                    referencedColumnName = "name"
            )
    )
    private List<CourseEntity> courses;

    public StudentEntity() {
        super();
    }

    public StudentEntity(int albumNo, String firstName, String lastName) {
        super();
        this.albumNo = albumNo;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getAlbumNo() {
        return albumNo;
    }

    public void setAlbumNo(Integer albumNo) {
        this.albumNo = albumNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<CourseEntity> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseEntity> courses) {
        this.courses = courses;
    }

    public void addCourse(CourseEntity courseEntity) {
        if (this.courses == null)
            courses = new ArrayList<>();
        this.courses.add(courseEntity);
    }
    public void removeCourse(CourseEntity courseEntity) {
        if (this.courses == null)
            courses = new ArrayList<>();
        this.courses.remove(courseEntity);
    }


//    public List<Course> getCourses() {
//        return courses;
//    }
//
//    public void setCourses(List<Course> courses) {
//        this.courses = courses;
//    }
}
