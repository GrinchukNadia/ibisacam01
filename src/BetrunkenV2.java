import java.util.Scanner;

public class BetrunkenV2 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int bier;
        int shots;
        int age;
        boolean license;

        System.out.println("Wie alt bist du?");
        age = sc.nextInt();
        System.out.println("Hast du deinen Führerschein dabei?");
        license = sc.nextBoolean();
        System.out.println("Wie viel Bier hast du getrunken?");
        bier = sc.nextInt();
        System.out.println("Wie viel Shots hast du getrunken?");
        shots = sc.nextInt();

        if(license && age < 19  && bier + shots == 0 ||
           license && age >= 19 && bier + shots <= 2) {
            System.out.println("Du darfst Auto fahren");
        } else {
            System.out.println("Du darfst nicht Autofahren");
        }
    }
}
