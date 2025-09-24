package SB_HW.spring_boot_rest_HW.controller;

import SB_HW.spring_boot_rest_HW.service.Authorities;
import SB_HW.spring_boot_rest_HW.service.AuthorizationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    @GetMapping("")
    public String getIndexHTML() {
        return "SERVER ON-LINE";
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }
}
