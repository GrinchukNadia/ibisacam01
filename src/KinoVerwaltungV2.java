import java.util.ArrayList;
import java.util.Scanner;
import java.util.Objects;

public class KinoVerwaltungV2 {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        double budget;
        int activity;
        boolean leaveCinema = false;

        do {
            System.out.println("Wie viel Geld hast du?");
            budget = scanner.nextInt();
        } while (budget <= 0);

        do {
            do {
                System.out.printf("Was willst du als nächstes tun? (Du hast noch %.2f€)", budget);
                System.out.println("1. Ticket kaufen");
                System.out.println("2. Film ansehen");
                System.out.println("3. Gewinnspiel");
                System.out.println("4. Kino verlassen");
                activity = scanner.nextInt();

            } while (activity <= 0 || activity > 4);

            if(activity == 1) {
                boolean breakProgram = false;
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

                            isEnoughMoney = budget - (amountTickets * ticketPrice) >= 0 && amountTickets <= availableTickets;
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
                        } while (amountTickets > availableTickets || amountTickets <= 0 || !isEnoughMoney);
                    }
                } while (!breakProgram);
            }
            if(activity == 2) {

            }
            if(activity == 3) {

            }
            if(activity == 4) {

            }
        } while (leaveCinema);





        /*
         *
         * Ich muss alle Preise auf double ändern.
         * Es müssen keine negativen Zahlen sein
         * Das Programm soll nicht weiterlaufen, wenn nicht genug Tickets vorhanden sind.
         * Ich muss darauf achten, dass genug Geld vorhanden ist.
         *
         */
    }
}
