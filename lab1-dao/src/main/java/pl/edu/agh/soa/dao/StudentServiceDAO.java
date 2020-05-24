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
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
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

        List<Student> studentList = studentEntityList // TODO filtrowanie w sqlu
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
//        GroupEntity groupEntity = entityManager.find(GroupEntity.class, albumNo);
//
//        Query query = entityManager.createQuery("SELECT group_id FROM group_student WHERE album_no = " + albumNo);
//
//        String studentEntityList = query.getFirstResult();
//        return studentMapper.entityToStudentMapper(studentEntity);

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<GroupStudent> q = cb.createQuery(GroupStudent.class);
        Root<GroupStudent> gs = q.from(GroupStudent.class);
        ParameterExpression<Integer> p = cb.parameter(Integer.class);
        q.select(gs).where(cb.equal(gs.get("albumNo"),p));

        LOGGER.info("\n\nbefore create query\n\n");
        TypedQuery<GroupStudent> query = entityManager.createQuery(q);
        LOGGER.info("\n\nafter create query\n\n");
        query.setParameter(p, albumNo);
        List<GroupStudent> results = query.getResultList();
        LOGGER.info("\n\nbefore group finding, groupSize:\n\n" + results.size());

        String groupId = results.get(0).getGroupId();
        LOGGER.info("\n\nbefore group finding, groupId:\n\n" + groupId);

        GroupEntity groupEntity = entityManager.find(GroupEntity.class, groupId);
        LOGGER.info("\n\nafter group finding\n\n");

        return studentMapper.entityToGroup(groupEntity);
    }

}
