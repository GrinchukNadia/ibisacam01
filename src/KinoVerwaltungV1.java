import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class KinoVerwaltungV1 {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean breakProgram = false;
        double budget = 0;
        double ticketPrice = 15;
        int choice = -1;
        int ticketsAmount = 2;
        String ticketText = (ticketsAmount > 1) ? "Tickets" : "Ticket";
        ArrayList<Integer> chosenMovies = new ArrayList<Integer>();
        String[][] movieData = {
                {"1.", "Batman", "20:15", "1", "10"},
                {"2.", "Matrix", "22:00", "3", "87"},
                {"3.", "Matrix 2", "17:00", "2", "0"},
        };
        String[] headers = {"Filmnr", "Filmname", "Uhrzeit", "Saal", "Restplätze"};

        System.out.println("Wie viel Geld hast du?");
        budget = scanner.nextInt();

        do {
            System.out.println(String.format("%-10s %-20s %-10s %-6s %s ", headers));
            System.out.println("------------------------------------------------------------");
            for (int i = 0; i < movieData.length; i++) {
                System.out.println(String.format("%-10s %-20s %-10s %-6s %s", movieData[i]));
            }
            System.out.println("------------------------------------------------------------");
            do {
                System.out.println("Welchen (nicht ausgebuchten) Film möchtest du sehen? (0 zum abbrechen)");
                choice = scanner.nextInt();
                if (choice == 0) breakProgram = true;

            } while (choice != 0 && ((choice < 1 ||
                    choice > movieData.length) ||
                    budget < 15 ||
                    Objects.equals(movieData[choice - 1][4], "ausgebucht")));

            if (choice != 0) {
                int availableTickets = Integer.parseInt(movieData[choice - 1][3]);
                int amountTickets = 0;
                do {
                    System.out.println(String.format("Es sind noch %d %s um jeweils %.0f€ dafür verfügbar. Wie viele möchtest du kaufen?", availableTickets, ticketText, ticketPrice));
                    amountTickets = scanner.nextInt();

                    for (int i = 0; i <= amountTickets; i++) {
                        chosenMovies.add(choice - 1);
                    }
                    double ticketsPrice = amountTickets * ticketPrice;
                    budget -= ticketsPrice;
                    System.out.println(String.format("Du kaufst %d Tickets um %.2f€ und hast jetzt noch %.2f€", amountTickets, ticketsPrice, budget));
                    movieData[choice - 1][3] = String.valueOf(Integer.parseInt(movieData[choice - 1][3]) - amountTickets);
                    if (Integer.parseInt(movieData[choice - 1][3]) == 0) movieData[choice - 1][4] = "ausgebucht";
                } while (amountTickets > availableTickets || amountTickets < 0);

            }

        } while ((!breakProgram));
    }
}
