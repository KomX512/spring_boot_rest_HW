package SB_HW.spring_boot_rest_HW.exception;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice("SB_HW.spring_boot_rest_HW")
public class AllExeptions {

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> handleInvalidCredentials(InvalidCredentials e) {

        return new ResponseEntity<>("Exception: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> handleUnauthorizedUser(UnauthorizedUser e) {

        return new ResponseEntity<>("Exception: " + e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    ResponseEntity<String> constraintViolationExceptionHandle(ConstraintViolationException e) {
        String authoritiesUser = "getAuthorities.user.user";
        String authoritiesPassword = "getAuthorities.user.password";

        if (e.getMessage().contains(authoritiesUser) || e.getMessage().contains(authoritiesPassword)) {
            return new ResponseEntity<>(e.getMessage()
                    .replace(authoritiesUser, "Ошибка в имени пользователя ")
                    .replace(authoritiesPassword, "Ошибка в пароле "),
                    HttpStatus.BAD_REQUEST);

        } else if (e.getMessage().contains(authoritiesPassword)) {
            return new ResponseEntity<>(e.getMessage().replace(authoritiesPassword,
                    "Ошибка в пароле "), HttpStatus.BAD_REQUEST);

        } else {
            return new ResponseEntity<>(e.getMessage().replace(authoritiesUser,
                    "Ошибка в имени пользователя "), HttpStatus.BAD_REQUEST);
        }
    }
}
