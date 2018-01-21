package besprechung;

import nutzer.Nutzer;
import raum.Raum;

import java.util.List;
import java.util.Set;

public class Besprechung {
    private final Raum raum;
    private final Set<Nutzer> eingeladeneNutzer;

    Besprechung(Raum raum, Set<Nutzer> eingeladeneNutzer) {
        this.raum = raum;
        this.eingeladeneNutzer = eingeladeneNutzer;
    }

    public Raum getRaum() {
        return raum;
    }

    public Set<Nutzer> getEingeladeneNutzer() {
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
