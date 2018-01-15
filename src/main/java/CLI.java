import ausstattung.Ausstattungsverwaltung;
import besprechung.Besprechungsverwaltung;
import nutzer.Nutzerverwaltung;
import raum.Raumverwaltung;

public class CLI {
    private final Raumverwaltung raumverwaltung;
    private final Besprechungsverwaltung besprechungsverwaltung;
    private final Nutzerverwaltung nutzerverwaltung;
    private final Ausstattungsverwaltung ausstattungsverwaltung;

    private CLI() {
        this.raumverwaltung = new Raumverwaltung();
        this.besprechungsverwaltung = new Besprechungsverwaltung();
        this.nutzerverwaltung = new Nutzerverwaltung();
        this.ausstattungsverwaltung = new Ausstattungsverwaltung();
    }

    public static void main(String[] args) {
        CLI cli = new CLI();
    }
}
