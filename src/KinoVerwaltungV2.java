import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class KinoVerwaltungV2 {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        double budget;
        int activity;
        boolean leaveCinema = false;
        ArrayList<String> chosenMovies = new ArrayList<>();

        do {
            System.out.println("Wie viel Geld hast du?");
            budget = scanner.nextInt();
        } while (budget <= 0);

        do {
            do {
                System.out.printf("Was willst du als nächstes tun? (Du hast noch %.2f€)\n", budget);
                System.out.println("1. Ticket kaufen");
                System.out.println("2. Film ansehen");
                System.out.println("3. Gewinnspiel");
                System.out.println("4. Kino verlassen");
                activity = scanner.nextInt();

            } while (activity <= 0 || activity > 4);

            if (activity == 1) {
                boolean stopActivity = false;
                int choice;
                double ticketPrice = 0.00;
                String[][] movieData = {
                        {"1.", "Batman", "20:15", "1", "14.00", "1"},
                        {"2.", "Matrix", "22:00", "3", "12.50", "3"},
                        {"3.", "Matrix 2", "17:00", "2", "9.99", "0"},
                        {"3.", "Matrix 2", "17:00", "2", "9.99", "0"},
                };
                String[] headers = {"Filmnr", "Filmname", "Uhrzeit", "Saal", "Preis", "Restplätze"};
                String[] formats = {"%-10s ", "%-20s ", "%-10s ", "%-6s ", " %-10s ", "%s"};

                do {
                    for (int i = 0; i < formats.length; i++) {
                        System.out.printf(formats[i], headers[i]);
                    }
                    System.out.println();
                    System.out.println("-------------------------------------------------------------------------");
                    for (int i = 0; i < movieData.length; i++) {
                        for (int j = 0; j < movieData[i].length - 1; j++) {
                            System.out.printf(formats[j], movieData[i][j]);
                        }
                        String status = Integer.parseInt(movieData[i][5]) == 0 ?
                                "ausgebucht" :
                                "verfügbar";
                        System.out.printf("%s", status);
                        System.out.println();
                    }
                    System.out.println("-------------------------------------------------------------------------");
                    do {
                        System.out.println("Welchen (nicht ausgebuchten) Film möchtest du sehen? (0 zum abbrechen)");
                        choice = scanner.nextInt();
                        if (choice == 0) stopActivity = true;

                    } while (choice != 0 && ((choice < 1 ||
                            choice > movieData.length) ||
                            budget < ticketPrice ||
                            movieData[choice - 1][5].equals("0")));

                    if (choice != 0) {
                        ticketPrice = Double.parseDouble(movieData[choice - 1][4]);
                        int availableTickets = Integer.parseInt(movieData[choice - 1][5]);
                        int amountTickets;
                        boolean isEnoughMoney;
                        String ticketText = (availableTickets > 1) ? "Tickets" : "Ticket";

                        do {
                            System.out.printf("Es sind noch %d %s um jeweils %.0f€ dafür verfügbar. Wie viele möchtest du kaufen?\n",
                                    availableTickets, ticketText, ticketPrice);
                            amountTickets = scanner.nextInt();

                            isEnoughMoney = budget - (amountTickets * ticketPrice) >= 0 && amountTickets <= availableTickets && amountTickets > 0;
                            if (isEnoughMoney) {
                                for (int i = 0; i < amountTickets; i++) {
                                    chosenMovies.add(movieData[(choice - 1)][1]);
                                }
                                double ticketsPrice = amountTickets * ticketPrice;
                                budget -= ticketsPrice;
                                System.out.printf("Du kaufst %d Tickets um %.2f€ und hast jetzt noch %.2f€ \n",
                                        amountTickets, ticketsPrice, budget);
                                movieData[choice - 1][5] = String.valueOf(Integer.parseInt(movieData[choice - 1][5]) - amountTickets);
                            }
                        } while (amountTickets > availableTickets || amountTickets <= 0 || !isEnoughMoney);
                    }
                } while (!stopActivity);
            }
            if (activity == 2) {
                boolean stopActivity = false;
                int choice;
                do {
                    do {
                        System.out.println("Welchen Film (für den du noch ein Ticket hast) möchtest du sehen? (0 für abbrechen)");
                        if (!chosenMovies.isEmpty()) {
                            for (int i = 0; i < chosenMovies.size(); i++) {
                                System.out.printf("%d. %s\n", i + 1, chosenMovies.get(i));
                            }
                        }
                        choice = scanner.nextInt();

                    } while (choice < 0 || choice > chosenMovies.size());
                    if (choice == 0) {
                        stopActivity = true;
                    } else {
                        System.out.printf("Du schaust dir den Film %s an. Viel Spaß!\n", chosenMovies.get(choice - 1));
                        chosenMovies.remove(choice - 1);
                    }
                } while (!stopActivity);
            }
            if (activity == 3) {
                int randomNumber;
                int summ = 0;
                boolean stopActivity = false;
                double ticketPrice = 5;
                double winPrice = 25;
                int choice;

                do {
                    System.out.printf("Ein Versuch kostet %.0f€, und der Gewinn beträgt %.0f€.\n", ticketPrice, winPrice);
                    System.out.printf("Du hast %.0f€.\n", budget);
                    if (budget < 5) {
                        System.out.println("Nicht genug Geld.");
                        break;
                    }
                    do {
                        System.out.print("Drücke 1, um zu spielen, und 0, um zu abbrechen).\n");
                        choice = scanner.nextInt();
                    } while ((choice < 0 || choice > 1) && budget > 5);

                    if (choice == 0) {
                        stopActivity = true;
                    } else {
                        randomNumber = random.nextInt(10, 1001);
                        System.out.println("Du machst beim Gewinnspiel mit!");
                        System.out.printf("Deine Glückszahl ist: %d \n", randomNumber);
                        budget -= 5;
                        boolean isNumber = true;
                        while (isNumber) {
                            summ += randomNumber % 10;
                            randomNumber = randomNumber / 10;
                            isNumber = randomNumber != 0;
                        }
                        boolean isWin = summ > 16;
                        String biggerOrSmaller = isWin ? "grosser" : "kleiner";
                        System.out.printf("Die Ziffernsumme deiner Glückszahl ist %d und %s als 16.\n", summ, biggerOrSmaller);
                        System.out.printf("%s", isWin ? "Du hast gewonnen!\n" : "Leider nicht gewonnen.\n");
                        summ = 0;
                        if (isWin) budget += 20;
                    }
                } while (!stopActivity);
            }
        } while (!(activity == 4));
    }
}
