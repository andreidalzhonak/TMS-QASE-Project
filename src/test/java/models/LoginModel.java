package models;

public class LoginModel extends Credentials {
    public void setEmail(String email) {
        this.EMAIL = email;
    }

    public void setPassword(String password) {
        this.PASSWORD = password;
    }

    public void setToken(String token) {
        this.TOKEN = token;
    }
}
