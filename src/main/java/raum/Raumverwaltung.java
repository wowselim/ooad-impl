package raum;

import ausstattung.Ausstattungsgegenstand;
import ausstattung.Ausstattungsverwaltung;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Raumverwaltung {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private List<Raum> raumListe;
    private Type type;

    public Raumverwaltung() {
        this.raumListe = new ArrayList<>();
        this.type = new TypeToken<List<Raum>>() {
        }.getType();
        this.raumListe.addAll(leseRaumliste());
    }

    public List<Raum> getRaumliste() {
        return raumListe;
    }

    public void erstelleRaum(String name, List<Ausstattungsgegenstand> ausstattungsgegenstaende) {
        raumListe.add(new Raum(name, ausstattungsgegenstaende));
    }

    private List<Raum> leseRaumliste() {
        try {
            return GSON.fromJson(new String(Files.readAllBytes(Paths.get("rooms.list"))), type);
        } catch (IOException e) {
            System.err.println("Es konnten keine Räume geladen werden.");
        }
        return Collections.emptyList();
    }

    private void speichereRaumliste() {
        try {
            Files.write(Paths.get("rooms.list"), GSON.toJson(raumListe, type).getBytes());
        } catch (IOException e) {
            System.err.println("Die Raumliste konnte nicht gespeichert werden.");
        }
    }

    public static void main(String[] args) {
        Raumverwaltung raumverwaltung = new Raumverwaltung();
        Ausstattungsverwaltung ausstattungsverwaltung = new Ausstattungsverwaltung();
        Ausstattungsgegenstand beamer = ausstattungsverwaltung.
                ausstattungsgegenstandAnlegen("Beamer");
        Ausstattungsgegenstand telefon = ausstattungsverwaltung
                .ausstattungsgegenstandAnlegen("Telefon");

        raumverwaltung.erstelleRaum("D14 104", Arrays.asList(beamer, telefon));
        raumverwaltung.erstelleRaum("D14 103", Collections.singletonList(beamer));

        raumverwaltung.speichereRaumliste();
    }

    public Raum getRaumByName(String raumName) {
        return raumListe.stream()
                .filter(raum -> raum.getName().equals(raumName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unbekannter Raumname."));
    }
}
