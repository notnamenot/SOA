package pl.edu.agh.soa.model;

import java.util.List;

public class Group {
    String id;
    int capacity;
    int studentsCount;

    private List<Student> studentList;

    public Group(String id, int capacity, int students_count) {
        this.id = id;
        this.capacity = capacity;
        this.studentsCount = students_count;
    }

    public Group() { }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getStudentsCount() {
        return studentsCount;
    }

//    public void setStudents_count(int students_count) {
//        this.students_count = students_count;
//    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
        this.studentsCount = studentList.size();
    }

    @Override
    public String toString() {
        //return super.toString();
        return "\nid=" + id + " capacity=" + capacity + " studentsCount=" + studentsCount;
    }
}
