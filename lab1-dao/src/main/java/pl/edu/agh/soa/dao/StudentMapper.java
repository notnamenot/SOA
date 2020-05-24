package pl.edu.agh.soa.dao;

import pl.edu.agh.soa.jpa.CourseEntity;
import pl.edu.agh.soa.jpa.StudentEntity;
import pl.edu.agh.soa.model.Student;

import javax.ejb.Stateless;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Stateless
public class StudentMapper {

    public StudentEntity studentToEntityMapper(Student student) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setAlbumNo(student.getAlbumNo());
        studentEntity.setFirstName(student.getFirstName());
        studentEntity.setLastName(student.getLastName());

        List<CourseEntity> courseEntityList = student.getCourses().stream().map(this::toCourseEntity).collect(toList()); // c -> toCourseEntity(c)
        studentEntity.setCourses(courseEntityList);

        return studentEntity;
    }

    public Student entityToStudentMapper(StudentEntity studentEntity) {
        Student student = new Student();
        student.setAlbumNo(studentEntity.getAlbumNo());
        student.setFirstName(studentEntity.getFirstName());
        student.setLastName(studentEntity.getLastName());

        List<String> courseList = studentEntity.getCourses().stream().map(this::toCourse).collect(toList());
        student.setCourses(courseList);

        return student;
    }

    public CourseEntity toCourseEntity(String course) {
        return new CourseEntity(course);
    }

    public String toCourse(CourseEntity courseEntity) {
        return courseEntity.getName();
    }

}
