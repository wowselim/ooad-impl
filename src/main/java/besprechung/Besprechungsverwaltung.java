package besprechung;

import nutzer.Nutzer;
import raum.Raum;

import java.util.List;

public class Besprechungsverwaltung {
    public Besprechung besprechungAnlegen(Raum raum, List<Nutzer> eingeladeneNutzer) {
        return new Besprechung(raum, eingeladeneNutzer);
    }
}
