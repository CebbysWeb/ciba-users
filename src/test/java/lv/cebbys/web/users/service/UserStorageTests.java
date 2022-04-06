package lv.cebbys.web.users.service;

import lv.cebbys.web.users.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserStorageTests {

    private UserStorage storage = new UserStorage();

    @Test
    void addUserTests() {
        User a = new User(0, (byte) 23, 128, "A", "A");
        storage.addUser(a);
        storage.addUser(a);
        Assertions.assertEquals(1, storage.getAllUsers().size());

        storage = new UserStorage();
        User b = new User(0, (byte) 23, 128, "B", "B");
        User c = new User(1, (byte) 23, 128, "B", "C");
        storage.addUser(b);
        storage.addUser(c);
        Assertions.assertEquals(1, storage.getAllUsers().size());
    }
}
