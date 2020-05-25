package pl.edu.agh.soa.dao;

import pl.edu.agh.soa.jpa.GroupEntity;
import pl.edu.agh.soa.jpa.GroupStudent;
import pl.edu.agh.soa.jpa.StudentEntity;
import pl.edu.agh.soa.model.Group;
import pl.edu.agh.soa.model.Student;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

import static org.jboss.ws.api.Log.LOGGER;

@Stateless
public class StudentServiceDAO {

    @PersistenceContext(unitName = "StudentUnit")
    EntityManager entityManager;

    private static Mapper studentMapper = new Mapper();

    public Student findStudent(int albumNo) {
        StudentEntity studentEntity = entityManager.find(StudentEntity.class, albumNo);

//        StudentMapper studentMapper = new StudentMapper();

        return studentMapper.entityToStudentMapper(studentEntity);
    }

    public List<Student> findStudents(String course, String firstName) {
        Query query = entityManager.createQuery("SELECT e FROM StudentEntity e");

        List<StudentEntity> studentEntityList = query.getResultList();

//        StudentMapper studentMapper = new StudentMapper();

        List<Student> studentList = studentEntityList
                                        .stream()
                                        .map(studentMapper::entityToStudentMapper) //s -> studentMapper.entityToStudentMapper(s)
                                        .filter(s -> course == null || s.getCourses().contains(course))
                                        .filter(s -> firstName == null || s.getFirstName().equals(firstName))
                                        .collect(toList());

        return studentList;
    }

    @Transactional(rollbackOn = Exception.class)
    public void addStudent(Student student) {
        StudentEntity studentEntity = studentMapper.studentToEntityMapper(student);
        entityManager.persist(studentEntity);
    }

    @Transactional(rollbackOn = Exception.class)
    public void editStudent(Student student) {
        StudentEntity studentEntity = studentMapper.studentToEntityMapper(student);
        entityManager.merge(studentEntity);
    }

    @Transactional(rollbackOn = Exception.class)
    public void deleteStudent(int albumNo) {
        StudentEntity studentEntity = entityManager.find(StudentEntity.class, albumNo);
        entityManager.remove(studentEntity);
    }

    public Group findGroup(int albumNo) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<GroupEntity> query = cb.createQuery(GroupEntity.class);
        Root<GroupEntity> fromGroups = query.from(GroupEntity.class);
        Join<GroupEntity,StudentEntity> students = fromGroups.join("studentEntityList"); //s.join(GroupEntity_.studentEntityList);

        ParameterExpression<Integer> paramAlbumNo = cb.parameter(Integer.class);
        List<Predicate> conditions = new ArrayList();
        conditions.add(cb.equal(students.get("albumNo"), paramAlbumNo));

        TypedQuery<GroupEntity> typedQuery = entityManager.createQuery(query
                .select(fromGroups)
                .where(conditions.toArray(new Predicate[] {}))
        );

        typedQuery.setParameter(paramAlbumNo, albumNo);

//        List<GroupEntity> groupEntityList = typedQuery.getResultList();
        GroupEntity groupEntity = typedQuery.getSingleResult();


//        return studentMapper.entityToGroup(groupEntityList.get(0));
        return studentMapper.entityToGroup(groupEntity);
    }

}
