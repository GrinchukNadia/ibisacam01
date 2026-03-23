import java.util.ArrayList;
import java.util.Scanner;

public class KinoVerwaltungV1 {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean breakProgram = false;
        double budget;
        double ticketPrice = 15;
        int choice;
        ArrayList<Integer> chosenMovies = new ArrayList<>();
        String[][] movieData = {
                {"1.", "Batman", "20:15", "1", "1"},
                {"2.", "Matrix", "22:00", "3", "3"},
                {"3.", "Matrix 2", "17:00", "2", "0"},
        };
        String[] headers = {"Filmnr", "Filmname", "Uhrzeit", "Saal", "Restplätze"};

        do {
            System.out.println("Wie viel Geld hast du?");
            budget = scanner.nextInt();
        } while (budget <= 0);

        do {
            System.out.printf("%-10s %-20s %-10s %-6s %s %n", headers);
            System.out.println("------------------------------------------------------------");
            for (String[] movieDatum : movieData) {
                System.out.printf("%-10s %-20s %-10s %-6s %s \n",
                        movieDatum[0],
                        movieDatum[1],
                        movieDatum[2],
                        movieDatum[3],
                        Integer.parseInt(movieDatum[4]) == 0 ? "ausgebucht" : "verfügbar");
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
                int amountTickets;
                boolean isEnoughMoney;
                String ticketText = (availableTickets > 1) ? "Tickets" : "Ticket";

                do {
                    System.out.printf("Es sind noch %d %s um jeweils %.0f€ dafür verfügbar. Wie viele möchtest du kaufen?\n",
                            availableTickets, ticketText, ticketPrice);
                    amountTickets = scanner.nextInt();

                    isEnoughMoney = budget - (amountTickets * ticketPrice) >= 0 && amountTickets <= availableTickets && amountTickets > 0 ;
                    if (isEnoughMoney) {
                        for (int i = 0; i < amountTickets; i++) {
                            chosenMovies.add(choice - 1);
                        }
                        double ticketsPrice = amountTickets * ticketPrice;
                        budget -= ticketsPrice;
                        System.out.printf("Du kaufst %d Tickets um %.2f€ und hast jetzt noch %.2f€ \n",
                                amountTickets, ticketsPrice, budget);
                        movieData[choice - 1][4] = String.valueOf(Integer.parseInt(movieData[choice - 1][4]) - amountTickets);
                    }
                } while (amountTickets > availableTickets || amountTickets <= 0 || !isEnoughMoney );
            }
        } while (!breakProgram);
    }
}
