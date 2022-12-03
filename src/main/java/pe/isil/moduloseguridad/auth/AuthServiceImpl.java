package pe.isil.moduloseguridad.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.moduloseguridad.shared.BasicResponse;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AuthUserRepository repository;

    @Override
    public BasicResponse login(String email, String password) {
        try {
            Optional<AuthUser> userToFind = repository.findAuthUserByEmailAndPassword(email, password);

            if (userToFind.isEmpty()) return BasicResponse.buildWhenEmailPasswordIncorrect();
            if (!userToFind.get().getIsActive()) return BasicResponse.buildWhenIsInactive();

            return BasicResponse.buildWhenLoginOk(userToFind.get());
        } catch (Exception e) {
            return BasicResponse.buildWhenError(e.getMessage());
        }
    }

    @Override
    public BasicResponse register(AuthUser authUser) {
        try {
            Optional<AuthUser> userToFind = repository.findAuthUserByEmail(authUser.getEmail());

            if (userToFind.isPresent()) return BasicResponse.buildWhenEmailIsTaken();

            repository.save(authUser);
            return BasicResponse.buildWhenRegisterSucceed();
        } catch (Exception e) {
            return BasicResponse.buildWhenError(e.getMessage());
        }
    }

    @Override
    public BasicResponse recoverPassword(AuthUser user, String email, String password) {
        try {
            Optional<AuthUser> userToUpdate = repository.findAuthUserByEmail(email);

            if (userToUpdate.isEmpty()) return BasicResponse.buildWhenEmailPasswordIncorrect();
            if (!userToUpdate.get().getIsActive()) return BasicResponse.buildWhenIsInactive();

            userToUpdate.get().setPassword(password);
            repository.save(userToUpdate.get());

            return BasicResponse.buildWhenPasswordRestored();
        } catch (Exception e) {
            return BasicResponse.buildWhenError(e.getMessage());
        }
    }
}
