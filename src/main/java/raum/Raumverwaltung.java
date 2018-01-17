package raum;

import java.util.Collections;
import java.util.List;

public class Raumverwaltung {
    private List<Raum> raumListe;

    public Raumverwaltung() {
        System.err.println("Unimplemented constructor Raumverwaltung");
        this.raumListe = Collections.emptyList();
    }

    public List<Raum> getRaumliste() {
        System.err.println("Unimplemented operation #getRaumliste");
        return raumListe;
    }
}
