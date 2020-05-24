package pl.edu.agh.soa.jpa;

import javax.persistence.*;

@Entity
@Table(name = "student_courses", schema = "dbo")
@IdClass(StudentCoursesPK.class)
public class StudentCourses {

    @Id
    @Column(name="album_no", nullable = false)
    private int album_no;

    @Id
    @Column(name="course_id", nullable = false)
    private int course_id;

    public int getAlbum_no() {
        return album_no;
    }

    public void setAlbum_no(int album_no) {
        this.album_no = album_no;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

}
