package pe.isil.moduloseguridad.shared;

import lombok.Builder;
import lombok.Data;
import pe.isil.moduloseguridad.auth.AuthUser;

@Data
@Builder
public class BasicResponse {
    private String code;
    private String message;
    private Object data;

    public static BasicResponse buildWhenLoginOk(AuthUser user) {
        return BasicResponse.builder()
                .code(Constants.CODE_SUCCESSFULLY_LOGGED.getCode())
                .message(Constants.CODE_SUCCESSFULLY_LOGGED.getMessage())
                .data(user)
                .build();
    }

    public static BasicResponse buildWhenSucceed() {
        return BasicResponse.builder()
                .code(Constants.CODE_SUCCEED.getCode())
                .message(Constants.CODE_SUCCEED.getMessage())
                .build();
    }

    public static BasicResponse buildWhenError(String error) {
        return BasicResponse.builder()
                .code(Constants.CODE_ERROR.getCode())
                .message((Constants.CODE_ERROR.getMessage() + " ").concat(error))
                .build();
    }

    public static BasicResponse buildWhenIsInactive() {
        return BasicResponse.builder()
                .code(Constants.CODE_USER_INACTIVATED.getCode())
                .message(Constants.CODE_USER_INACTIVATED.getMessage())
                .build();
    }

    public static BasicResponse buildWhenEmailPasswordIncorrect() {
        return BasicResponse.builder()
                .code(Constants.CODE_ERROR_CREDENTIALS.getCode())
                .message(Constants.CODE_ERROR_CREDENTIALS.getMessage())
                .build();
    }

    public static BasicResponse buildWhenEmailNotExist() {
        return BasicResponse.builder()
                .code(Constants.CODE_EMAIL_NOT_EXIST.getCode())
                .message(Constants.CODE_EMAIL_NOT_EXIST.getMessage())
                .build();
    }

    public static BasicResponse buildWhenEmailIsTaken() {
        return BasicResponse.builder()
                .code(Constants.CODE_EMAIL_TAKEN.getCode())
                .message(Constants.CODE_EMAIL_TAKEN.getMessage())
                .build();
    }

    public static BasicResponse buildWhenRegisterSucceed() {
        return BasicResponse.builder()
                .code(Constants.CODE_REGISTER_SUCCESSFULLY.getCode())
                .message(Constants.CODE_REGISTER_SUCCESSFULLY.getMessage())
                .build();
    }

    public static BasicResponse buildWhenPasswordRestored() {
        return BasicResponse.builder()
                .code(Constants.CODE_PASSWORD_RESTORED.getCode())
                .message(Constants.CODE_PASSWORD_RESTORED.getMessage())
                .build();
    }

    public static BasicResponse buildWhenAppCreatedSuccess() {
        return BasicResponse.builder()
                .code(Constants.CODE_APP_CREATED.getCode())
                .message(Constants.CODE_APP_CREATED.getMessage())
                .build();
    }

    public static BasicResponse buildWhenAppNameIsTaken() {
        return BasicResponse.builder()
                .code(Constants.CODE_APP_NOMBRE_TAKEN.getCode())
                .message(Constants.CODE_APP_NOMBRE_TAKEN.getMessage())
                .build();
    }
}
