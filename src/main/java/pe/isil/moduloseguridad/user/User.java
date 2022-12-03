package pe.isil.moduloseguridad.user;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "tbl_user",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "email", name = "email_unique")
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 150)
    private String name;
    @Column(nullable = true, length = 150)
    private String lastName;
    @Column(nullable = false, length = 200)
    private String email;
    @Column(nullable = true, length = 500)
    private String urlPhoto;
    private Date createdDate;
    private String createdBy;
    private Date updatedDate;
    private String updatedBy;

    @PostPersist
    public void postPersist() {
        this.createdBy = "SYSTEM";
        this.createdDate = new Date();
    }

    @PostUpdate
    public void postUpdate() {
        this.updatedBy = "SYSTEM";
        this.updatedDate = new Date();
    }
}
