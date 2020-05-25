package pl.edu.agh.soa.jpa;

import javax.persistence.*;

@Entity
@Table(name = "contact", schema = "dbo")
public class ContactEntity {

    @Id
    @Column(name = "album_no")
    private int albumNo;

    @OneToOne
    @MapsId
    @JoinColumn(name = "album_no")
    private StudentEntity studentEntity;

    @Column(name = "phone")
    private int phone;

    public ContactEntity() {
    }

    public ContactEntity(int albumNo, int phone) {
        this.albumNo = albumNo;
        this.phone = phone;
    }

    public int getAlbumNo() {
        return albumNo;
    }

    public void setAlbumNo(int albumNo) {
        this.albumNo = albumNo;
    }

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
