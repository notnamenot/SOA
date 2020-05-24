package pl.edu.agh.soa.jpa;

import java.io.Serializable;

public class GroupStudentPK implements Serializable {
    private String groupId;
    private int albumNo;

    public GroupStudentPK(String groupId, int albumNo) {
        this.groupId = groupId;
        this.albumNo = albumNo;
    }
}
