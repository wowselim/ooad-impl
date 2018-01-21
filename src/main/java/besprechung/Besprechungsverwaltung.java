package besprechung;

import nutzer.Nutzer;
import raum.Raum;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Besprechungsverwaltung {
    private final List<Besprechung> besprechungen;

    public Besprechungsverwaltung() {
        besprechungen = new ArrayList<>();
    }

    public Besprechung besprechungAnlegen(Raum raum, Set<Nutzer> eingeladeneNutzer) {
        Besprechung besprechung = new Besprechung(raum, eingeladeneNutzer);
        besprechungen.add(besprechung);
        return besprechung;
    }

    public List<Besprechung> getBesprechungliste() {
        return besprechungen;
    }
}
