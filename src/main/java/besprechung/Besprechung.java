package besprechung;

import nutzer.Nutzer;
import raum.Raum;

import java.util.List;

public class Besprechung {
    private final Raum raum;
    private final List<Nutzer> eingeladeneNutzer;

    Besprechung(Raum raum, List<Nutzer> eingeladeneNutzer) {
        this.raum = raum;
        this.eingeladeneNutzer = eingeladeneNutzer;
    }

    public Raum getRaum() {
        return raum;
    }

    public List<Nutzer> getEingeladeneNutzer() {
        return eingeladeneNutzer;
    }

    @Override
    public String toString() {
        return "Besprechung{" +
                "raum=" + raum +
                ", eingeladeneNutzer=" + eingeladeneNutzer +
                '}';
    }
}
