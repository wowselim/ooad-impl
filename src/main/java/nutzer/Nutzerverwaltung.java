package nutzer;

import java.util.HashMap;
import java.util.Map;

public class Nutzerverwaltung {
    private Map<String, Nutzer> users;

    public Nutzerverwaltung() {
        users = new HashMap<>();
        users.put("administrator", new Nutzer("administrator", "passwort"));
    }

    public void loginPruefen(String user, String pw) {
        Nutzer nutzer = users.get(user);
        if (nutzer == null || !pw.equals(nutzer.getPassword())) {
            throw new IllegalArgumentException("Unbekannter Nutzer oder falsches Passwort.");
        }
    }

    public void nutzerAnlegen(String user, String pw) {
        users.put(user, new Nutzer(user, pw));
    }
}
