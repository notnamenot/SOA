package pl.edu.agh.soa.jpa;

import javax.persistence.Column;
import java.io.Serializable;

public class StudentCoursesPK implements Serializable {
    private int albumNo;
    private String courseId;

    public StudentCoursesPK(int album_no, String course_id) {
        this.albumNo = album_no;
        this.courseId = course_id;
    }
}
