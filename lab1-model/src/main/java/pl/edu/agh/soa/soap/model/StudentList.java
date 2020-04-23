package pl.edu.agh.soa.soap.model;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

//@Singleton
@RequestScoped
public class StudentList {
    private List<Student> students;

    @PostConstruct
    public void init() {
        Student student1 = Student.builder()
                .firstName("Jan")
                .lastName("Kowalski")
                .albumNo(20)
                .addCourse("SOA")
                .addCourse("IO")
                .build();
        Student student2 = Student.builder()
                .firstName("Anna")
                .lastName("Nowak")
                .albumNo(30)
                .addCourse("SOA")
                .addCourse("IO")
                .build();
        Student student3 = Student.builder()
                .firstName("Ewa")
                .lastName("Wąż")
                .albumNo(50)
                .addCourse("UNIX")
                .addCourse("IO")
                .build();
        Student student4 = Student.builder()
                .firstName("Adam")
                .lastName("Chwast")
                .albumNo(60)
                .build();
        //return Arrays.asList(student1, student2, student3, student4);
        //https://javastart.pl/baza-wiedzy/wyjatki/unsupportedoperationexception
        this.students = new ArrayList<>(Arrays.asList(student1, student2, student3, student4));
//        students = new ArrayList<>();
    }

    public boolean exists(int albumNo) {
        return getStudent(albumNo) != null;
    }

    public List<Student> getAll() {
        return this.students;
    }

    public void addStudent(Student s) {
        this.students.add(s);
    }

    public boolean deleteStudent(int albumNo) {
        return this.students.removeIf(student -> student.getAlbumNo() == albumNo);
    }

    public List<Student> filter(String course, String firstName) {
        if (null == course && null == firstName )
            return getAll();

        return students
                .stream()
                .filter(s -> course == null || s.getCourses().contains(course))
                .filter(s -> firstName == null || s.getFirsName().equals(firstName))
                .collect(toList());
        //                .collect(Collectors.toList());
    }

    public Student getStudent(int albumNo) {
        return students
                .stream()
                .filter(s -> s.getAlbumNo() == albumNo)
                .findFirst()
                .orElse(null);
    }
}
