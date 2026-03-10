import java.util.Scanner;

public class EinMalEinsV2 {
    static void main() {
        int  multiplier;
        int range = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welche Reihe soll ausgegeben werden?");
        multiplier = sc.nextInt();

        System.out.println(range + " x " + multiplier + " = " + (range*multiplier));
        System.out.println(++range + " x " + multiplier + " = " + (range*multiplier));
        System.out.println(++range + " x " + multiplier + " = " + (range*multiplier));
        System.out.println(++range + " x " + multiplier + " = " + (range*multiplier));
        System.out.println(++range + " x " + multiplier + " = " + (range*multiplier));
        System.out.println(++range + " x " + multiplier + " = " + (range*multiplier));
        System.out.println(++range + " x " + multiplier + " = " + (range*multiplier));
        System.out.println(++range + " x " + multiplier + " = " + (range*multiplier));
        System.out.println(++range + " x " + multiplier + " = " + (range*multiplier));
        System.out.println(++range + " x " + multiplier + " = " + (range*multiplier));

    }
}
