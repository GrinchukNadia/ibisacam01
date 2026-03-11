import java.util.Random;
import java.util.Scanner;

public class MuenzeWerfenV3 {
    static void main() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int heads = 0;
        int tails = 0;
        int tossCoinTimes;
        String result;

        System.out.println("Schreibe, wie viel Mal wir die Münze werfen:");

        do {
            System.out.println("Wie oft soll die Münze geworfen werden (ungerade Zahl 1-10)?");
            tossCoinTimes = scanner.nextInt();
        } while (tossCoinTimes < 1 || tossCoinTimes > 11);


        for (int i = 0; i < tossCoinTimes; i++) {
            if (random.nextBoolean()) {
                result = "Kopf!";
                heads++;
            } else {
                result = "Zahl!";
                tails++;
            }
            System.out.println("Werfe Münze… " + result);
        }
        System.out.println("Summe Kopf: " + heads);
        System.out.println("Summe Zahl: " + tails);

        if (heads > tails) {
            System.out.println("Ich bekomme das Ticket.");
        } else {
            System.out.println("Stefan bekommt das Ticket.");
        }
    }
}
