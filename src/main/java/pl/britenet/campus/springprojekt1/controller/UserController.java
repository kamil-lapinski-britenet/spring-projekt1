package pl.britenet.campus.springprojekt1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.britenet.campus.database.object.User;
import pl.britenet.campus.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public Optional<User> getUser(@PathVariable int userId) {
       return this.userService.getUser(userId);
    }

    @GetMapping
    public List<User> getUsers() {
        return this.userService.getUsers();
    }

    @PostMapping
    public void insertUser(@RequestBody User user) {
        this.userService.insertUser(user);
    }

    @PutMapping
    public void updateUser(@RequestBody User user) {
        this.userService.updateUser(user);
    }

    @DeleteMapping
    public void deleteUser(@PathVariable int userId) {
        this.userService.deleteUser(userId);
    }

}
