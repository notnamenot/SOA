package pl.edu.agh.soa.jpa;

import javax.persistence.*;

@Entity
@Table(name = "student_courses", schema = "dbo")
@IdClass(StudentCoursesPK.class)
public class StudentCourse {

    @Id
    @Column(name="album_no", nullable = false)
    private int albumNo;

    @Id
    @Column(name="course", nullable = false)
    String courseId;

    public int getAlbum_no() {
        return albumNo;
    }

    public void setAlbum_no(int album_no) {
        this.albumNo = album_no;
    }

    public String getCourse_id() {
        return courseId;
    }

    public void setCourse_id(String course_id) {
        this.courseId = course_id;
    }

}
