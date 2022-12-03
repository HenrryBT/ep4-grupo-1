package pe.isil.moduloseguridad.user;

import pe.isil.moduloseguridad.shared.BasicResponse;

import java.util.List;

public interface UserService {
    BasicResponse createUser(User user);

    BasicResponse updateUser(User user, Long id);

    void deleteUser(Long id);

    User getUserByMail(String mail);

    User getUserById(Long id);

    List<User> getAllUsers();
}
