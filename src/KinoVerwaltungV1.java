import java.sql.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class KinoVerwaltungV1 {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int budget = 0;
        int ticketCost = 15;
        int choice;
        int ticketsAmount = 2;
        String ticketText = (ticketsAmount > 1) ? "Tickets" : "Ticket";
        ArrayList<Integer> chosenMovies = new ArrayList<Integer>();
        String[][] movieData = {
                {"1.", "Batman", "20:15", "1", "verfügbar"},
                {"2.", "Matrix", "22:00", "3", "verfügbar"},
                {"3.", "Matrix 2", "17:00", "2", "ausgebucht"},
        };
        String[] headers = {"Filmnr", "Filmname", "Uhrzeit", "Saal", "Restplätze"};

        System.out.println("Wie viel Geld hast du?");
        budget = scanner.nextInt();

        do {
            System.out.println(String.format("%-10s %-20s %-10s %-6s %s ", headers));
            System.out.println("--------------------------------------------------------------");
            for (int i = 0; i < movieData.length; i++) {
                System.out.println(String.format("%-10s %-20s %-10s %-6s %s", movieData[i]));
            }
            System.out.println("--------------------------------------------------------------");
            do {
                System.out.println("Welchen (nicht ausgebuchten) Film möchtest du sehen? (0 zum abbrechen)");
                choice = scanner.nextInt();

            } while ((choice < 0 ||
                    choice > movieData.length) ||
                    Objects.equals(movieData[choice - 1][4], "ausgebucht") );

        } while(choice != 0);


//        System.out.println(String.format("Es sind noch %d %s um jeweils 15€ dafür verfügbar. Wie viele möchtest du kaufen?", 2, ticketText));
//
    }
}
