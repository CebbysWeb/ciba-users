package lv.cebbys.web.users.controller;

import lv.cebbys.web.users.entity.User;
import lv.cebbys.web.users.service.HtmlBuilder;
import lv.cebbys.web.users.service.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserStorage storage;

    @Autowired
    private HtmlBuilder builder;

    @GetMapping("/hello")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("<html><b>Hi</b></html>", HttpStatus.OK);
    }

    //?age=1&length=182&name=Janis&last=Ciba
    @GetMapping("/createUser")
    public ResponseEntity<?> createUser(
            @RequestParam String name,
            @RequestParam(name = "last") String lastName,
            @RequestParam(required = false) Byte age,
            @RequestParam(required = false) Integer length
    ) {
        User user = new User(storage.getAllUsers().size(), age, length, name, lastName);
        storage.addUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/listAllUsers")
    public ResponseEntity<String> listAllUsers() {
        return new ResponseEntity<>(builder.userTable(storage.getAllUsers()), HttpStatus.OK);
    }

    @GetMapping("/getUser")
    public ResponseEntity<String> getUser(@RequestParam Integer id) {
        User user = storage.getUser(id);
        List<User> list = new ArrayList<>();
        if (user != null) {
            list.add(user);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(builder.userTable(list), HttpStatus.OK);
    }
}
