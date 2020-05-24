package pl.edu.agh.soa.jpa;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "course", schema="dbo")
public class CourseEntity {

//    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)//, generator = "auto_gen")
////    @SequenceGenerator(name = "auto_gen",sequenceName = "A")
//    @Column(name="course_id", nullable = false)
//    private int courseId;

    @Id
    @Column(name="name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "courses")
    private List<StudentEntity> students;

    public CourseEntity() {
        super();
    }

    public CourseEntity(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//
//    public int getCourseId() {
//        return courseId;
//    }
//
//    public void setCourseId(int course_id) {
//        this.courseId = course_id;
//    }
}
