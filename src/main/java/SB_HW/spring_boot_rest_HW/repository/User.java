package SB_HW.spring_boot_rest_HW.repository;

import SB_HW.spring_boot_rest_HW.service.Authorities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private String name;
    private String password;
    List<Authorities> authorities = new ArrayList<>();

    public User(String name, String password, boolean read, boolean write, boolean delete) {
        this.name = name;
        this.password = password;
        if (read) {
            authorities.add(Authorities.READ);
        }
        if (write) {
            authorities.add(Authorities.WRITE);
        }
        if (delete) {
            authorities.add(Authorities.DELETE);
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
