package ausstattung;

public class Ausstattungsgegenstand {
    private String name;

    @SuppressWarnings("unused")
    public Ausstattungsgegenstand() {
    }

    public Ausstattungsgegenstand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
