package SB_HW.spring_boot_rest_HW.repository;

import SB_HW.spring_boot_rest_HW.service.Authorities;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {

    public List<Authorities> getUserAuthorities(String user, String password) {
        List userList = getUsersList();
        if (userList.size() == 0) {
            return null;
        }

        User chekUser = findUserByName(userList, user);
        if (chekUser == null){
            return null;
        }

        if (password.equals(chekUser.getPassword())){
            return chekUser.getAuthorities();
        }
        return null;//TODO;
    }

    public static List getUsersList() {

        List<User> usersList = new ArrayList<>();
        try {
            String filePath = "src/main/java/SB_HW/spring_boot_rest_HW/repository/users.json";
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject allUsers = new JSONObject(content);

            JSONArray usersArray = allUsers.getJSONArray("users");

            for (int i = 0; i < usersArray.length(); i++) {
                JSONObject current = usersArray.getJSONObject(i);

                User newUser = new User(current.getString("name"),
                        current.getString("password"),
                        current.getBoolean("read"),
                        current.getBoolean("write"),
                        current.getBoolean("delete"));

                usersList.add(newUser);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return usersList;
    }

    public static User findUserByName(List<User> userList, String user) {

        for (int i = 0; i < userList.size(); i++) {
            User current = userList.get(i);
            if (user.equals(current.getName())) {
                return current;
            }
        }

        return null;
    }

}