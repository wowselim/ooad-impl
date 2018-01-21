package nutzer;

public class Nutzer {
    private final String username;
    private final String password;

    Nutzer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Nutzer{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
