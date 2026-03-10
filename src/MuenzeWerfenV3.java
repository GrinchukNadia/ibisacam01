import java.util.Random;
import java.util.Scanner;

public class MuenzeWerfenV3 {
    static void main() {
        int kopf = 0;
        int zahl = 0;
        int malWerfen;
        String result;
        Random random = new Random();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Schreibe, wie viel Mal wir die Münze werfen:");

        do {
            System.out.println("Wie oft soll die Münze geworfen werden (ungerade Zahl 1-10)?");
            malWerfen = scanner.nextInt();
        } while (malWerfen < 1 || malWerfen > 11);


        for (int i = 0; i < malWerfen; i++) {
            if (random.nextBoolean()) {
                result = "Kopf!";
                kopf++;
            } else {
                result = "Zahl!";
                zahl++;
            }
            System.out.println("Werfe Münze… " + result);
        }
        System.out.println("Summe Kopf: " + kopf);
        System.out.println("Summe Zahl: " + zahl);

        if (kopf > zahl) {
            System.out.println("Ich bekomme das Ticket.");
        } else {
            System.out.println("Stefan bekommt das Ticket.");
        }
    }
}
