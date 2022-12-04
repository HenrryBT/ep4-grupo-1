package pe.isil.moduloseguridad.aplicacion;

import pe.isil.moduloseguridad.shared.BasicResponse;

import java.util.List;

public interface AplicacionService {
    BasicResponse createApp(Aplicacion aplicacion);

    BasicResponse updateApp(Aplicacion aplicacion, Long id);

    void deleteApp(Long id);

    Aplicacion getAppById(Long id);

    List<Aplicacion> getAllApps();
}
