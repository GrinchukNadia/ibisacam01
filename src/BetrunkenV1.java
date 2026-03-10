import java.util.Scanner;

public class BetrunkenV1 {
    static void main() {
        int bier;
        int shots;

        Scanner sc = new Scanner(System.in);
        System.out.println("Wie viel Bier hast du getrunken?");
        bier = sc.nextInt();
        System.out.println("Wie viel Shots hast du getrunken?");
        shots = sc.nextInt();

        if(bier == 0 && shots == 0){
            System.out.println("Gar nicht betrunken");
        } else if(bier + shots <= 2) {
            System.out.println("Leicht betrunken");
        } else if(bier + shots <= 6 || bier >= 6 && shots == 0){
            System.out.println("Betrunken");
        } else {
            System.out.println("Hoffnungslos betrunken");
        }
    }
}
