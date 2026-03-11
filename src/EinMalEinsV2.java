import java.util.Scanner;

public class EinMalEinsV2 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int multiplier;

        System.out.println("Welche Reihe soll ausgegeben werden?");
        multiplier = sc.nextInt();

        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " x " + multiplier + " = " + (i * multiplier));
        }
    }
}
