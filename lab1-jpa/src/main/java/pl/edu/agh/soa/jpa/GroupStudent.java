package pl.edu.agh.soa.jpa;

import javax.persistence.*;

@Entity
@Table(name = "group_student")
@IdClass(GroupStudentPK.class)
public class GroupStudent {
    @Id
    @Column(name="group_id", nullable = false)
    String groupId;
    @Id
    @Column(name="album_no", nullable = false)
    int albumNo;

    public GroupStudent() {
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public int getAlbumNo() {
        return albumNo;
    }

    public void setAlbumNo(int albumNo) {
        this.albumNo = albumNo;
    }
}
