package nutzer;

import java.util.HashMap;
import java.util.Map;

public class Nutzerverwaltung {
    private Map<String, String> users;

    public Nutzerverwaltung() {
        users = new HashMap<>();
        users.put("administrator", "passwort");
    }

    public void loginPruefen(String user, String pw) {
        if (!pw.equals(users.get(user))) {
            throw new IllegalArgumentException("Unbekannter Nutzer oder falsches Passwort.");
        }
    }

    public void nutzerAnlegen(String user, String pw) {
        users.put(user, pw);
    }
}
