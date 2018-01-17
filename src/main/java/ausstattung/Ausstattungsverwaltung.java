package ausstattung;

public class Ausstattungsverwaltung {
    public Ausstattungsgegenstand ausstattungsgegenstandAnlegen(String name) {
        return new Ausstattungsgegenstand(name);
    }
}
