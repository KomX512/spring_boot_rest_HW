package SB_HW.spring_boot_rest_HW.repository;

import SB_HW.spring_boot_rest_HW.service.Authorities;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {

    @NotBlank
    @NotNull()
    @Size(min = 2, max = 15)
    private String name;

    @NotBlank
    @NotNull()
    @Size(min = 2, max = 20)
    private String password;
    List<Authorities> authorities = new ArrayList<>();

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void addAuhorities(Authorities authAdd) {
        if (!authorities.contains(authAdd)) {
            authorities.add(authAdd);
        }
    }

    public void fillAuhorities(boolean read, boolean write, boolean delete) {
        if (read) {
            this.addAuhorities(Authorities.READ);
        }
        if (write) {
            this.addAuhorities(Authorities.WRITE);
        }
        if (delete) {
            this.addAuhorities(Authorities.DELETE);
        }
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public List<Authorities> getAuthorities() {
        return authorities;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        User ob = (User) obj;
        return name.equals(ob.name);
    }
}
