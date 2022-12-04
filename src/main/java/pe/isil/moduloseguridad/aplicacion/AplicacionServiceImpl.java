package pe.isil.moduloseguridad.aplicacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.moduloseguridad.shared.BasicResponse;

import java.util.List;
import java.util.Optional;

@Service
public class AplicacionServiceImpl implements AplicacionService{

    @Autowired
    private AplicacionRepository aplicacionRepository;

    @Override
    public BasicResponse createApp(Aplicacion aplicacion) {
        try {
            Optional<Aplicacion> aplicacionTemp = aplicacionRepository.findByName(aplicacion.getNombre());

            if (aplicacionTemp.isPresent()) {
                return BasicResponse.buildWhenNameIsTaken();
            } else {
                aplicacionRepository.save(aplicacion);
                return BasicResponse.whenSucceed();
            }
        } catch (Exception e) {
            return BasicResponse.buildWhenError(e.getMessage());
        }
    }

    @Override
    public BasicResponse updateApp(Aplicacion aplicacion, Long id) {
        try {
            Aplicacion aplicacionToUpdate = aplicacionRepository.findById(id).get();

            aplicacionToUpdate.setNombre(aplicacion.getNombre());
            aplicacionToUpdate.setBaseDatos(aplicacion.getBaseDatos());
            aplicacionToUpdate.setLenguage(aplicacion.getLenguage());
            aplicacionRepository.save(aplicacionToUpdate);

            return BasicResponse.whenSucceed();
        } catch (Exception e) {
            return BasicResponse.buildWhenError("El nombre ya esta en uso");
        }
    }

    @Override
    public void deleteApp(Long id) {
        Aplicacion aplicacionToDelete = aplicacionRepository.findById(id).get();
        aplicacionRepository.delete(aplicacionToDelete);
    }

    @Override
    public Aplicacion getAppById(Long id) {
        return aplicacionRepository.findById(id).get();
    }

    @Override
    public List<Aplicacion> getAllApps() {
        return aplicacionRepository.findAll();
    }

    @Override
    public Aplicacion getUserByName(String nombre) {
        return aplicacionRepository.findByName(nombre).get();
    }

}
