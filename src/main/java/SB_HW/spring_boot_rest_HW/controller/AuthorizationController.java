package SB_HW.spring_boot_rest_HW.controller;

import SB_HW.spring_boot_rest_HW.exception.InvalidCredentials;
import SB_HW.spring_boot_rest_HW.exception.UnauthorizedUser;
import SB_HW.spring_boot_rest_HW.repository.User;
import SB_HW.spring_boot_rest_HW.service.Authorities;
import SB_HW.spring_boot_rest_HW.service.AuthorizationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController() {
        this.service = new AuthorizationService();
    }

    @GetMapping("")
    public String getIndexHTML() {
        return "SERVER ON-LINE";
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User user) {

        return service.getAuthorities(user);
    }


}
