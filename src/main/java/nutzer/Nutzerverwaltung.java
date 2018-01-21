package nutzer;

import java.util.HashMap;
import java.util.Map;

public class Nutzerverwaltung {
    private Map<String, Nutzer> users;

    public Nutzerverwaltung() {
        users = new HashMap<>();
        users.put("administrator", new Nutzer("administrator", "passwort"));
    }

    public void loginPruefen(String name, String passwort) {
        Nutzer nutzer = users.get(name);
        if (nutzer == null || !passwort.equals(nutzer.getPasswort())) {
            throw new IllegalArgumentException("Unbekannter Nutzer oder falsches Passwort.");
        }
    }

    public void nutzerAnlegen(String name, String passwort) {
        users.put(name, new Nutzer(name, passwort));
    }
}
