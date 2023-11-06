package Models;

public class Login {
    private String username;
    private String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String username, String password) {
        if(this.username.equals(username) && this.password.equals(password)){
            return true;
        }
        return false;
    }

    public Object getUsername() {
        return username;
    }

    public Object getPassword() {
        return password;
    }
}
