import ausstattung.Ausstattungsverwaltung;
import besprechung.Besprechung;
import besprechung.Besprechungsverwaltung;
import nutzer.Nutzer;
import nutzer.Nutzerverwaltung;
import raum.Raum;
import raum.Raumverwaltung;

import java.io.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class CLI {
    private final Scanner scanner;
    private final Raumverwaltung raumverwaltung;
    private final Besprechungsverwaltung besprechungsverwaltung;
    private final Nutzerverwaltung nutzerverwaltung;
    private final Ausstattungsverwaltung ausstattungsverwaltung;

    private boolean istEingeloggt;
    private boolean sollBeenden;
    private Nutzer aktuellerNutzer;

    private CLI() {
        this.scanner = new Scanner(System.in);
        this.raumverwaltung = new Raumverwaltung();
        this.besprechungsverwaltung = new Besprechungsverwaltung();
        this.nutzerverwaltung = new Nutzerverwaltung();
        this.ausstattungsverwaltung = new Ausstattungsverwaltung();
    }

    public static void main(String[] args) {
        CLI cli = new CLI();
        cli.menueSchleifeStarten();
    }

    private void menueSchleifeStarten() {
        while (!sollBeenden) {
            if (!istEingeloggt) {
                loginAnzeigen();
            }
            menueAnzeigen();
        }
    }

    private void loginAnzeigen() {
        System.out.println("Welcome to Besprechungsverwaltung");
        System.out.println("Bitte melden sie sich an");
        System.out.print("Benutzername: ");
        String benutzername = scanner.nextLine();
        System.out.print("Passwort: ");
        String pw = lesePasswort();
        this.aktuellerNutzer = nutzerverwaltung.loginPruefen(benutzername, pw);
        istEingeloggt = true;
        System.out.println("Willkommen " + aktuellerNutzer.getName());
    }

    private String lesePasswort() {
        Console console = System.console();
        return console == null ? scanner.nextLine() : new String(console.readPassword());
    }

    private void menueAnzeigen() {
        String choice = "";
        System.out.println("Was möchten Sie tun?");
        System.out.println("[1] Räume anzeigen");
        System.out.println("[2] Nutzerkonto anlegen");
        System.out.println("[3] Besprechung erstellen");
        System.out.println("[4] Besprechungen anzeigen");
        System.out.println("[5] Abmelden");
        System.out.println("[x] Beenden");

        choice = scanner.nextLine();

        switch (choice) {
            case "1":
                raumlisteAnzeigen();
                break;
            case "2":
                nutzerKontoAnlegen();
                break;
            case "3":
                besprechungAnlegen();
                break;
            case "4":
                besprechungenAnzeigen();
                break;
            case "5":
                ausloggen();
                break;
            case "x":
                beenden();
                break;
            default:
                System.out.println("Unbekannter Menüpunkt");
        }
    }

    private void besprechungenAnzeigen() {
        System.out.println(besprechungsverwaltung.getBesprechungliste());
    }

    private void raumlisteAnzeigen() {
        System.out.println(raumverwaltung.getRaumliste());
    }

    private void besprechungAnlegen() {
        System.out.println("Aktuelle Raumliste: " + raumverwaltung.getRaumliste());
        System.out.print("Wählen Sie einen Raum für Ihre Besprechung: ");
        String raumName = scanner.nextLine();
        Raum raum = raumverwaltung.getRaumByName(raumName);
        System.out.println(nutzerverwaltung.getNutzerliste());
        System.out.print("Laden Sie andere Nutzer ein: ");
        String[] benutzerNamen = scanner.nextLine().split(",");
        Set<Nutzer> eingeladeneNutzer = new HashSet<>();
        eingeladeneNutzer.add(aktuellerNutzer);
        for(String benutzerName : benutzerNamen) {
            eingeladeneNutzer.add(nutzerverwaltung.getNutzerByName(benutzerName));
        }
        Besprechung besprechung = besprechungsverwaltung.besprechungAnlegen(raum, eingeladeneNutzer);
        System.out.println("Besprechung erfolgreich angelegt");
        System.out.println(besprechung);
    }

    private void beenden() {
        sollBeenden = true;
        System.out.println("Auf wiedersehen!");
    }

    private void ausloggen() {
        aktuellerNutzer = null;
        istEingeloggt = false;
    }

    private void nutzerKontoAnlegen() {
        System.out.println("Bitte geben Sie einen Namen für den neuen Benutzer ein");
        String user = scanner.nextLine();
        System.out.println("Bitte geben Sie ein Passwort für den neuen Benutzer ein");
        String pw = lesePasswort();
        nutzerverwaltung.nutzerAnlegen(user, pw);
    }
}
