package pe.isil.moduloseguridad.aplicacion;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "tbl_app",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "nombre", name = "nombre_unique")
        })
public class Aplicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String baseDatos;

    private String lenguaje;
    private Date fechaCreacion;
    private String usuarioCreacion;

    @PostPersist
    public void postPersist() {
        this.usuarioCreacion = "SYSTEM";
        this.fechaCreacion = new Date();
    }
}
