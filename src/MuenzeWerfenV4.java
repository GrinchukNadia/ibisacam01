import java.util.Random;
import java.util.Scanner;

public class MuenzeWerfenV4 {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int tossCount = 0;
        int tossCoinTimes;
        int heads = 0;
        int tails = 0;
        boolean istZufrieden = false;
        boolean istKopf;

        do {
            do {
                System.out.println("Wie oft soll die Münze geworfen werden (INSGESAMT ungerade, neue Zahl 1-10)?");
                tossCoinTimes = scanner.nextInt();
            }
            while ((tossCount + tossCoinTimes) % 2 == 0 || !(tossCoinTimes >= 1 && tossCoinTimes <= 10));

            tossCount += tossCoinTimes;

            for (int i = 0; i < tossCoinTimes; i++) {
                istKopf = random.nextBoolean();
                if (istKopf) {
                    heads++;
                    System.out.println("Werfe Münze… Kopf!");
                } else {
                    tails++;
                    System.out.println("Werfe Münze… Zahl!");
                }
            }
            System.out.println("Summe Kopf: " + heads);
            System.out.println("Summe Zahl: " + tails);

            System.out.println("Bist du mit dem Ergebnis zufrieden?");
            istZufrieden = scanner.nextBoolean();

        } while (!istZufrieden);

        if (istZufrieden) {
            if (heads > tails) System.out.println("Ich bekomme das Ticket.");
            else System.out.println("Stefan bekommt das Ticket.");
        }
    }
}
