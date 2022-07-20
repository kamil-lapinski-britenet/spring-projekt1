package pl.britenet.campus.springprojekt1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.britenet.campus.database.object.User;
import pl.britenet.campus.springprojekt1.model.UserCredentials;
import pl.britenet.campus.springprojekt1.model.UserLoginData;
import pl.britenet.campus.springprojekt1.service.AuthenticationService;

@RestController
@RequestMapping("/api/v1/authentication")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("login")
    public UserLoginData login(@RequestBody UserCredentials userCredentials) {
        return this.authenticationService.login(userCredentials);
    }

    @GetMapping("/{userToken}")
    public boolean login(@PathVariable String userToken) {
        return this.authenticationService.isLogged(userToken);
    }

    @PostMapping("register")
    public void registerUser(@RequestBody User user) {
        this.authenticationService.register(user);
    }
}
