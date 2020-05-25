package pl.edu.agh.soa.dao;

import pl.edu.agh.soa.jpa.CourseEntity;
import pl.edu.agh.soa.jpa.GroupEntity;
import pl.edu.agh.soa.jpa.StudentEntity;
import pl.edu.agh.soa.model.Group;
import pl.edu.agh.soa.model.Student;

import javax.ejb.Stateless;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.jboss.ws.api.Log.LOGGER;


@Stateless
public class Mapper {

    public StudentEntity studentToStudentEntity(Student student) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setAlbumNo(student.getAlbumNo());
        studentEntity.setFirstName(student.getFirstName());
        studentEntity.setLastName(student.getLastName());

        List<CourseEntity> courseEntityList = student.getCourses().stream().map(this::toCourseEntity).collect(toList()); // c -> toCourseEntity(c)
        LOGGER.info("\n\n\nCoursesLIst:\n\n\n\n" + student.getCourses());

        studentEntity.setCourses(courseEntityList);

        LOGGER.info("\n\n\ncourseEntityList:\n\n\n\n" + courseEntityList.get(0).getName());
        return studentEntity;
    }

    public Student studentEntityToStudent(StudentEntity studentEntity) {
        Student student = new Student();
        student.setAlbumNo(studentEntity.getAlbumNo());
        student.setFirstName(studentEntity.getFirstName());
        student.setLastName(studentEntity.getLastName());

        List<String> courseList = studentEntity.getCourses().stream().map(this::toCourse).collect(toList());
        student.setCourses(courseList);

        return student;
    }

    public List<Student> studentEntityListToStudentList(List<StudentEntity> studentEntityList) {
        return studentEntityList.stream().map(this::studentEntityToStudent).collect(toList());
    }

    public CourseEntity toCourseEntity(String course) {
        return new CourseEntity(course);
    }

    public String toCourse(CourseEntity courseEntity) {
        return courseEntity.getName();
    }

    public Group entityToGroup(GroupEntity groupEntity) {
        Group group = new Group(groupEntity.getId(),groupEntity.getCapacity(),groupEntity.getStudentsCount());
        List<Student> studentList = groupEntity.getStudentEntityList().stream().map(this::studentEntityToStudent).collect(toList());
        group.setStudentList(studentList);

        return group;
    }

}
