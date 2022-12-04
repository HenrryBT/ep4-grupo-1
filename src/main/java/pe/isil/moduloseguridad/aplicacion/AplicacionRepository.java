package pe.isil.moduloseguridad.aplicacion;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AplicacionRepository extends JpaRepository<Aplicacion, Long> {
    Optional<Aplicacion> findByName(String nombre);
    
}
