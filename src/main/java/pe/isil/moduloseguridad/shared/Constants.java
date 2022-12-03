package pe.isil.moduloseguridad.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Constants {
    CODE_SUCCESSFULLY_LOGGED("200", "Login Exitóso"),
    CODE_SUCCEED("200", "Operación correcta"),
    CODE_ERROR("500", "Ocurrió un error"),
    CODE_USER_INACTIVATED("401", "Usuario inactivo"),
    CODE_ERROR_CREDENTIALS("403", "Usuario o contraseñas incorrectos"),
    CODE_EMAIL_TAKEN("510", "Usuario ya está registrado"),
    CODE_REGISTER_SUCCESSFULLY("200", "Usuario registrado correctamente"),
    CODE_PASSWORD_RESTORED("200", "Tu contraseña ha sido actualizada");

    @Getter
    private String code;
    @Getter
    private String message;
}
