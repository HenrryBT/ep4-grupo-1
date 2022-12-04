package pe.isil.moduloseguridad.aplicacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AplicacionRepository extends JpaRepository<Aplicacion, Long> {
    Optional<Aplicacion> findAplicacionByNombre(String nombre);
}
