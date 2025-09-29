package SB_HW.spring_boot_rest_HW.repository;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class UserRepositoryTest {

    @Test
    void getUserListTest() {

        List result = UserRepository.getUsersList();

        System.out.println(result);
    }

    @Test
    void getUserAuthoritiesTest() {
        UserRepository userRepository = new UserRepository();
        List result = userRepository.getUserAuthorities("Anna", "QuaZZar");
    }

    @Test
    void findUserTest() {
        List result = UserRepository.getUsersList();
        User user1 = UserRepository.findUserByName(result, "Ivan");
        System.out.println(user1);
        User user2 = UserRepository.findUserByName(result, "TEST");
        System.out.println(user2);
    }
}
