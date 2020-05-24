package pl.edu.agh.soa.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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


            CourseEntity course = entityManager.find(CourseEntity.class,"SOA");
            StudentEntity studentEntity = entityManager.find(StudentEntity.class,666671);
            studentEntity.addCourse(course);

//            entityManager.get
//            entityManager.persist(student);
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
