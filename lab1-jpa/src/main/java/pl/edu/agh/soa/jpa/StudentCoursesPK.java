package pl.edu.agh.soa.jpa;

import javax.persistence.Column;
import java.io.Serializable;

public class StudentCoursesPK implements Serializable {
    private int album_no;
    private String course_id;

    public StudentCoursesPK(int album_no, String course_id) {
        this.album_no = album_no;
        this.course_id = course_id;
    }
}
