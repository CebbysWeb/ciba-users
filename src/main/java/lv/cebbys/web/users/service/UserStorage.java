package lv.cebbys.web.users.service;

import lv.cebbys.web.users.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserStorage {
    private List<User> users = new ArrayList<>();

    public boolean addUser(User u) {
        for (User user : users) {
            if (user.getName().equals(u.getName())) {
                return false;
            }
            if (user.getId() == u.getId()) {
                return false;
            }
        }
        users.add(u);
        return true;
    }

    public User getUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User getUser(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getAllUsers() {
        return users;
    }
}
