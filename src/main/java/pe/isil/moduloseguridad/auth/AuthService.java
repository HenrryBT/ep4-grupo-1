package pe.isil.moduloseguridad.auth;

import pe.isil.moduloseguridad.shared.BasicResponse;

public interface AuthService {
    BasicResponse login(String email, String password);

    BasicResponse register(AuthUser authUser);

    BasicResponse recoverPassword(AuthUser user, String email, String password);
}
