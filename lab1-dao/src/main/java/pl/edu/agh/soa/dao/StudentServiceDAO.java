package pl.edu.agh.soa.dao;

import pl.edu.agh.soa.jpa.StudentEntity;
import pl.edu.agh.soa.model.Student;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

import static java.util.stream.Collectors.toList;


@Stateless
public class StudentServiceDAO {

    @PersistenceContext(unitName = "StudentUnit")
    EntityManager entityManager;

    public Student findStudent(int albumNo) {
        StudentEntity studentEntity = entityManager.find(StudentEntity.class, albumNo);

        StudentMapper studentMapper = new StudentMapper();

        return studentMapper.entityToStudentMapper(studentEntity);
    }

    public List<Student> findStudents(String course, String firstName) {
        Query query = entityManager.createQuery("SELECT e FROM StudentEntity e");

        List<StudentEntity> studentEntityList = query.getResultList();

        StudentMapper studentMapper = new StudentMapper();

        List<Student> studentList = studentEntityList
                                        .stream()
                                        .map(studentMapper::entityToStudentMapper) //s -> studentMapper.entityToStudentMapper(s)
                                        .filter(s -> course == null || s.getCourses().contains(course))
                                        .filter(s -> firstName == null || s.getFirstName().equals(firstName))
                                        .collect(toList()); // studentMapper::entityToStudentMapper

        return studentList;
    }


}
