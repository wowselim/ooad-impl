package nutzer;

public class Nutzer {
    private final String name;
    private final String passwort;

    Nutzer(String name, String passwort) {
        this.name = name;
        this.passwort = passwort;
    }

    String getName() {
        return name;
    }

    String getPasswort() {
        return passwort;
    }

    @Override
    public String toString() {
        return "Nutzer{" +
                "name='" + name + '\'' +
                ", passwort='" + passwort + '\'' +
                '}';
    }
}
