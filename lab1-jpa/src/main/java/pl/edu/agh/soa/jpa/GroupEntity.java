package pl.edu.agh.soa.jpa;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="group", schema = "dbo")
public class GroupEntity {

    @Id
    @Column(name="group_id", nullable = false)
    String id;
    @Column(name="capacity", nullable = false)
    int capacity;
    @Column(name="students_count", nullable = false)
    int studentsCount;

    @OneToMany(targetEntity = StudentEntity.class)
    @JoinTable(
            name = "group_student",
            schema = "dbo",
            joinColumns = @JoinColumn(
                    name = "group_id",
                    referencedColumnName = "group_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "album_no",
                    referencedColumnName = "album_no"
            )
    )
    private List<StudentEntity> studentEntityList;

    public GroupEntity(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public GroupEntity(String id, int capacity, List<StudentEntity> studentEntityList) {
        this.id = id;
        this.capacity = capacity;
        this.studentEntityList = studentEntityList;
    }

    public GroupEntity() { }

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

    public List<StudentEntity> getStudentEntityList() {
        return studentEntityList;
    }

    public void setStudentEntityList(List<StudentEntity> studentEntityList) {
        this.studentEntityList = studentEntityList;
        this.studentsCount = studentEntityList.size();
    }
//
//    public void setStudentsCount(int students_count) {
//        this.students_count = students_count;
//    }
}
