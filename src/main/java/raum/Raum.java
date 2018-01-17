package raum;

import ausstattung.Ausstattungsgegenstand;

import java.util.List;

public class Raum {
    private String name;
    private List<Ausstattungsgegenstand> ausstattungsgegenstaende;

    @SuppressWarnings("unused")
    public Raum() {
    }

    public Raum(String name, List<Ausstattungsgegenstand> ausstattungsgegenstaende) {
        this.name = name;
        this.ausstattungsgegenstaende = ausstattungsgegenstaende;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ausstattungsgegenstand> getAusstattungsgegenstaende() {
        return ausstattungsgegenstaende;
    }

    public void setAusstattungsgegenstaende(List<Ausstattungsgegenstand> ausstattungsgegenstaende) {
        this.ausstattungsgegenstaende = ausstattungsgegenstaende;
    }
}
