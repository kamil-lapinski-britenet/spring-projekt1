package pl.britenet.campus.springprojekt1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.britenet.campus.database.object.User;
import pl.britenet.campus.service.UserService;
import pl.britenet.campus.springprojekt1.model.UserCredentials;
import pl.britenet.campus.springprojekt1.model.UserLoginData;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@Service
public class AuthenticationService {

    private final Map<String, Integer> activeTokens;
    private final UserService userService;

    @Autowired
    public AuthenticationService(UserService userService) {
        this.activeTokens = new HashMap<>();
        this.userService = userService;
    }



   // private Map<String, String> passwordHash = new HashMap<>();



    public UserLoginData login(UserCredentials userCredentials) {
        String passwordToHash = userCredentials.getPassword();
        String generatedPassword = null;

        try
        {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Add password bytes to digest
            md.update(passwordToHash.getBytes());

            // Get the hash's bytes
            byte[] bytes = md.digest();

            // This bytes[] has bytes in decimal format. Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            // Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println(generatedPassword);

        // passwordHash.put(generatedPassword, user.getPassword());


        Optional<User> oUser = this.userService.getUserMailPass(userCredentials.getUserMail(), /*userCredentials.getPassword()*/generatedPassword);


        if (oUser.isPresent()) {
            int userId = oUser.get().getUserId();




            String userToken = UUID.randomUUID().toString();
            this.activeTokens.put(userToken, userId);
            return new UserLoginData(userId, userToken);
        }
        else {
            throw new IllegalStateException("Invalid credentials.");
        }
    }

    public boolean isLogged(String userToken) {
        return this.activeTokens.containsKey(userToken);
    }


    public void register(User user) {

        String passwordToHash = user.getPassword();
        String generatedPassword = null;

        try
        {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Add password bytes to digest
            md.update(passwordToHash.getBytes());

            // Get the hash's bytes
            byte[] bytes = md.digest();

            // This bytes[] has bytes in decimal format. Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            // Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println(generatedPassword);

       // passwordHash.put(generatedPassword, user.getPassword());

        user.setPassword(generatedPassword);
        this.userService.insertUser(user);

            String userToken = UUID.randomUUID().toString();
            this.activeTokens.put(userToken, user.getUserId());
           UserLoginData userLoginData = new UserLoginData(user.getUserId(), userToken);
        System.out.println(userLoginData);


        }

    public int getUserId(String token) {
        return this.activeTokens.get(token);
    }


}