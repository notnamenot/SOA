package pl.edu.agh.soa.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.security.acl.Group;
import java.util.ArrayList;
import java.util.List;

//@RequestScoped
public class StudentsManager {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("StudentUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


//        StudentEntity student = new StudentEntity();
//        student.setAlbumNo(666671);
//        student.setFirstName("Adam");
//        student.setLastName("Testowy");
//
//        CourseEntity courseEntity = new CourseEntity("SOA");
//        CourseEntity courseEntity2 = new CourseEntity("WTM");
//        List<CourseEntity> courseEntityList = new ArrayList<>();
//        courseEntityList.add(courseEntity);
//        courseEntityList.add(courseEntity2);
//
//        student.setCourses(courseEntityList);
//
//
//        System.out.println("proba");
//
//        entityManager.persist(courseEntity);
//        entityManager.persist(courseEntity2);
//        entityManager.persist(student);


        try {

//
            entityManager.getTransaction().begin();
//            CourseEntity courseEntity = new CourseEntity("UNIX");
//            entityManager.persist(courseEntity);

//            CourseEntity courseEntity = new CourseEntity("SOA");
//            CourseEntity courseEntity2 = new CourseEntity("UNIX");
//            entityManager.persist(courseEntity);
//            entityManager.persist(courseEntity2);
//
//            entityManager.getTransaction().commit();
//            entityManager.getTransaction().begin();


//            CourseEntity course = new CourseEntity("IO");
//            entityManager.persist(course);
//
//            StudentEntity studentEntity = entityManager.find(StudentEntity.class,666671);
//            studentEntity.addCourse(course);


//            StudentEntity studentEntity = new StudentEntity(666557,"Ela","Fiołek");
//            entityManager.persist(studentEntity);
//            StudentEntity studentEntity1 = entityManager.find(StudentEntity.class,666671);
//            List<StudentEntity> studentEntityList = new ArrayList<>();
//            studentEntityList.add(studentEntity);
//            studentEntityList.add(studentEntity1);
//
//            GroupEntity groupEntity = new GroupEntity("1a",15);
//            groupEntity.setStudentEntityList(studentEntityList);
//            entityManager.persist(groupEntity);

            //

            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<GroupEntity> query = cb.createQuery(GroupEntity.class);
            Root<GroupEntity> groups = query.from(GroupEntity.class);
//            groups.join(GroupEntity_.studentEntityList); //.join("studentEntityList");
            Join<GroupEntity,StudentEntity> students = groups.join(GroupEntity_.studentEntityList);
            ParameterExpression<Integer> p = cb.parameter(Integer.class);
            query.select(groups).where(cb.equal(groups.get("albumNo"),p));

            TypedQuery<GroupEntity> q = entityManager.createQuery(query);
            q.setParameter(p, 666671);
            List<GroupEntity> results = q.getResultList();
            System.out.println("res size:" + results.size());
            for (GroupEntity groupEntity : results) { System.out.println(groupEntity.getId()); }

            //

//            CriteriaBuilder cb2 = entityManager.getCriteriaBuilder();
//            CriteriaQuery<StudentEntity> query = cb2.createQuery(StudentEntity.class); //rarget entity
//
////            Metamodel m = entityManager.getMetamodel();
////            EntityType<StudentEntity> StudentEntity_ = m.entity(StudentEntity.class);
////            EntityType<StudentCourse> StudentCourse_ = m.entity(StudentCourse.class);
//
//            Root<StudentEntity> students = query.from(StudentEntity.class);
////            Join<CourseEntity,StudentEntity> joinStudentCourse = rootStudent.join("courses");
//            //            Join<StudentEntity,StudentCourse> student_course = student.join(StudentEntity_.courses());
//            students.join(StudentEntity_.courses);
////            ParameterExpression<Integer> p = cb.parameter(Integer.class);
//            query.select(students).where(cb2.equal(students.get("albumNo"),666671));

//            TypedQuery<StudentEntity> typedQuery = entityManager.createQuery(query);
//            List<StudentEntity> studentEntityList = typedQuery.getResultList();
//            for (StudentEntity studentEntity : studentEntityList) { System.out.println(studentEntity.getFirstName()); }

            entityManager.getTransaction().commit();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        finally {
            entityManager.close();
            entityManagerFactory.close();
        }

    }
}
