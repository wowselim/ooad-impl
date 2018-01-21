package nutzer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Nutzerverwaltung {
    private Map<String, Nutzer> nutzerliste;

    public Nutzerverwaltung() {
        nutzerliste = new HashMap<>();
        nutzerliste.put("administrator", new Nutzer("administrator", "passwort"));
    }

    public Nutzer loginPruefen(String name, String passwort) {
        Nutzer nutzer = nutzerliste.get(name);
        if (nutzer == null || !passwort.equals(nutzer.getPasswort())) {
            throw new IllegalArgumentException("Unbekannter Nutzer oder falsches Passwort.");
        }
        return nutzer;
    }

    public void nutzerAnlegen(String name, String passwort) {
        nutzerliste.put(name, new Nutzer(name, passwort));
    }

    public List<Nutzer> getNutzerliste() {
        return new ArrayList<>(nutzerliste.values());
    }

    public Nutzer getNutzerByName(String benutzerName) {
        return nutzerliste.values().stream()
                .filter(nutzer -> nutzer.getName().equals(benutzerName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unbekannter Benutzer."));
    }
}
