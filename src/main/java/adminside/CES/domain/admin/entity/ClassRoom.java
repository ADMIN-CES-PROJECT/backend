package adminside.CES.domain.admin.entity;

import lombok.Getter;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Getter
@Table(name = "classrooms")
public class ClassRoom{

    @EmbeddedId
    private ClassRoomId classRoomId;

}
