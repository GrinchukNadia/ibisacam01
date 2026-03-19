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
        ArrayList<Integer> chosenMovies = new ArrayList<>();
        String[][] movieData = {
                {"1.", "Batman", "20:15", "1", "1"},
                {"2.", "Matrix", "22:00", "3", "3"},
                {"3.", "Matrix 2", "17:00", "2", "0"},
                {"3.", "Matrix 2", "17:00", "2", "0"},
        };
        String[] headers = {"Filmnr", "Filmname", "Uhrzeit", "Saal", "Restplätze"};

        do {
            System.out.println("Wie viel Geld hast du?");
            budget = scanner.nextInt();
        } while (budget <= 0);

//не работает количество купленных билетов, можно купить больш или меньше
        do {
            System.out.println(String.format("%-10s %-20s %-10s %-6s %s ", headers));
            System.out.println("------------------------------------------------------------");
            for (int i = 0; i < movieData.length; i++) {
                System.out.println(String.format("%-10s %-20s %-10s %-6s %s",
                        movieData[i][0],
                        movieData[i][1],
                        movieData[i][2],
                        movieData[i][3],
                        Integer.parseInt(movieData[i][4]) == 0 ? "ausgebucht" : "verfügbar"));
            }
            System.out.println("------------------------------------------------------------");
            do {
                System.out.println("Welchen (nicht ausgebuchten) Film möchtest du sehen? (0 zum abbrechen)");
                choice = scanner.nextInt();
                if (choice == 0) breakProgram = true;

            } while (choice != 0 && ((choice < 1 ||
                    choice > movieData.length) ||
                    budget < ticketPrice ||
                    movieData[choice - 1][4].equals("0")));

            if (choice != 0) {
                int availableTickets = Integer.parseInt(movieData[choice - 1][4]);
                int amountTickets = 0;
                boolean isEnoughMoney = false;
                String ticketText = (ticketsAmount > 1) ? "Tickets" : "Ticket";

                do {
                    System.out.println(String.format("Es sind noch %d %s um jeweils %.0f€ dafür verfügbar. Wie viele möchtest du kaufen?",
                            availableTickets, ticketText, ticketPrice));
                    amountTickets = scanner.nextInt();

                    isEnoughMoney = budget - (amountTickets * ticketPrice) >= 0;
                    if (isEnoughMoney) {
                        for (int i = 0; i < amountTickets; i++) {
                            chosenMovies.add(choice - 1);
                        }
                        double ticketsPrice = amountTickets * ticketPrice;
                        budget -= ticketsPrice;
                        System.out.println(String.format("Du kaufst %d Tickets um %.2f€ und hast jetzt noch %.2f€",
                                amountTickets, ticketsPrice, budget));
                        movieData[choice - 1][4] = String.valueOf(Integer.parseInt(movieData[choice - 1][4]) - amountTickets);
                    }
                } while (amountTickets > availableTickets || amountTickets <= 0 || !isEnoughMoney );
            }
        } while (!breakProgram);
    }
}
