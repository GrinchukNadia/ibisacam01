import java.util.Random;
import java.util.Scanner;

public class MuenzeWerfenV2 {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int heads = 0;
        int count = 0;
        int tossCoinTimes;
        String tossResult;

        System.out.println("Schreibe, wie viel Mal wir die Münze werfen:");
        tossCoinTimes = scanner.nextInt();

        for (int i = 0; i < tossCoinTimes; i++) {
            if (random.nextBoolean()) {
                tossResult = "Kopf!";
                heads++;
            } else {
                tossResult = "Zahl!";
                count++;
            }
            System.out.println("Werfe Münze… " + tossResult);
        }
        System.out.println("Summe Kopf: " + heads);
        System.out.println("Summe Zahl: " + count);

        if (heads > count) {
            System.out.println("Ich bekomme das Ticket.");
        } else {
            System.out.println("Stefan bekommt das Ticket.");
        }
    }
}
