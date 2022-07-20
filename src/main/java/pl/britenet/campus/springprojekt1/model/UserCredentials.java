package pl.britenet.campus.springprojekt1.model;

public class UserCredentials {

    private final String mail;
    private final String password;

    public UserCredentials(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public String getUserMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }
}
