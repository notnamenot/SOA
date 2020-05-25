package pl.edu.agh.soa.dao;

import pl.edu.agh.soa.jpa.ContactEntity;
import pl.edu.agh.soa.jpa.CourseEntity;
import pl.edu.agh.soa.jpa.GroupEntity;
import pl.edu.agh.soa.jpa.StudentEntity;
import pl.edu.agh.soa.model.Contact;
import pl.edu.agh.soa.model.Group;
import pl.edu.agh.soa.model.Student;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static org.jboss.ws.api.Log.LOGGER;

@Stateless
public class StudentServiceDAO {

    @PersistenceContext(unitName = "StudentUnit")
    EntityManager entityManager;

    private static final Mapper mapper = new Mapper();

    public Student findStudent(int albumNo) {
//        StudentEntity studentEntity = entityManager.find(StudentEntity.class, albumNo);

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<StudentEntity> criteriaQuery = cb.createQuery(StudentEntity.class);
        Root<StudentEntity> fromStudents = criteriaQuery.from(StudentEntity.class);
        criteriaQuery.select(fromStudents).where(cb.equal(fromStudents.get("albumNo"),albumNo));

        StudentEntity studentEntity = entityManager.createQuery(criteriaQuery).getSingleResult();

        return mapper.studentEntityToStudent(studentEntity);
    }

    public List<Student> findStudents(String course, String firstName) {
//        Query query = entityManager.createQuery("SELECT e FROM StudentEntity e");
//
//        List<StudentEntity> studentEntityList = query.getResultList();
//
////        StudentMapper studentMapper = new StudentMapper();
//
//        List<Student> studentList = studentEntityList
//                                        .stream()
//                                        .map(studentMapper::entityToStudentMapper) //s -> studentMapper.entityToStudentMapper(s)
//                                        .filter(s -> course == null || s.getCourses().contains(course))
//                                        .filter(s -> firstName == null || s.getFirstName().equals(firstName))
//                                        .collect(toList());

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<StudentEntity> criteriaQuery = cb.createQuery(StudentEntity.class);
        Root<StudentEntity> fromStudents = criteriaQuery.from(StudentEntity.class);

//        ParameterExpression<String> paramCourse = cb.parameter(String.class);
//        ParameterExpression<String> paramFirstName = cb.parameter(String.class);
        List<Predicate> conditions = new ArrayList();
        if (course != null) {
            Join<StudentEntity, CourseEntity> courses = fromStudents.join("courses");
            conditions.add(cb.equal(courses.get("name"), course));
        }
        if (firstName != null) {
            conditions.add(cb.equal(fromStudents.get("firstName"), firstName));
        }

        TypedQuery<StudentEntity> typedQuery = entityManager.createQuery(criteriaQuery
                .select(fromStudents)
                .where(conditions.toArray(new Predicate[] {}))
        );

//        typedQuery.setParameter(paramCourse, course);
//        typedQuery.setParameter(paramFirstName, firstName);

        List<StudentEntity> studentEntityList = typedQuery.getResultList();

        return mapper.studentEntityListToStudentList(studentEntityList);
    }

    @Transactional(rollbackOn = Exception.class)
    public void addStudent(Student student) {
        StudentEntity studentEntity = mapper.studentToStudentEntity(student);
        entityManager.persist(studentEntity);
    }

    @Transactional(rollbackOn = Exception.class)
    public void editStudent(Student student) {
        StudentEntity studentEntity = mapper.studentToStudentEntity(student);
        entityManager.merge(studentEntity);

//        StudentEntity studentEntity = mapper.studentToStudentEntity(student);
//
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaUpdate update = cb.createCriteriaUpdate(StudentEntity.class);
//        Root<StudentEntity> s = update.from(StudentEntity.class);
//
//        update.set("firstName", studentEntity.getFirstName());
//        update.set("lastName", studentEntity.getLastName());
//        update.set("courses", studentEntity.getCourses());
//
//        update.where(cb.equal(s.get("albumNo"),student.getAlbumNo()));
//
//        Query query = entityManager.createQuery(update);
//        query.executeUpdate();
    }

    @Transactional(rollbackOn = Exception.class)
    public void deleteStudent(int albumNo) {
        StudentEntity studentEntity = entityManager.find(StudentEntity.class, albumNo);
        entityManager.remove(studentEntity);
    }

    public Group findGroup(int albumNo) {

        LOGGER.info("\n\n\ngroup, alnumNo:\n\n\n\n" + albumNo);
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<GroupEntity> query = cb.createQuery(GroupEntity.class);
        Root<GroupEntity> fromGroups = query.from(GroupEntity.class);
        Join<GroupEntity,StudentEntity> students = fromGroups.join("studentEntityList"); //s.join(GroupEntity_.studentEntityList);

        LOGGER.info("\n\n1\n\n" + albumNo);
        ParameterExpression<Integer> paramAlbumNo = cb.parameter(Integer.class);
        List<Predicate> conditions = new ArrayList();
        conditions.add(cb.equal(students.get("albumNo"), paramAlbumNo));
        LOGGER.info("\n\n2\n\n" + albumNo);

        TypedQuery<GroupEntity> typedQuery = entityManager.createQuery(query
                .select(fromGroups)
                .where(conditions.toArray(new Predicate[] {}))
        );
        LOGGER.info("\n\n3\n\n" + albumNo);

        typedQuery.setParameter(paramAlbumNo, albumNo);

//        List<GroupEntity> groupEntityList = typedQuery.getResultList();
        GroupEntity groupEntity = typedQuery.getSingleResult();


        return mapper.groupEntityToGroup(groupEntity);
    }

    public void addContact(Contact contact) {
        ContactEntity contactEntity = mapper.contactToContactEntity(contact);

        StudentEntity studentEntity = entityManager.find(StudentEntity.class,contact.getAlbumNo());
        contactEntity.setStudentEntity(studentEntity);
        entityManager.persist(contactEntity);
    }

    public Contact findContact(int albumNo) {
        LOGGER.info("\n\nfindContact:\n\n" + albumNo);

        ContactEntity contactEntity = entityManager.find(ContactEntity.class, albumNo);
        return mapper.contactEntityToContact(contactEntity);
    }
}
