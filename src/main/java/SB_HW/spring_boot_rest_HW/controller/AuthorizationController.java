package SB_HW.spring_boot_rest_HW.controller;

import SB_HW.spring_boot_rest_HW.exception.InvalidCredentials;
import SB_HW.spring_boot_rest_HW.exception.UnauthorizedUser;
import SB_HW.spring_boot_rest_HW.service.Authorities;
import SB_HW.spring_boot_rest_HW.service.AuthorizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        var result = service.getAuthorities(user, password);
        System.out.println(result);
        return  result;
    }

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> handleInvalidCredentials (InvalidCredentials e) {

        return new ResponseEntity<>( "Exception: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> handleUnauthorizedUser (UnauthorizedUser e) {

        return new ResponseEntity<>("Exception: " + e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

}
