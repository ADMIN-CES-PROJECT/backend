package adminside.CES.domain.admin.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ClassRoomId implements Serializable {
    @Column(name = "building_number")
    private String buildingNumber;

    @Column(name = "room_number")
    private String roomNumber;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
