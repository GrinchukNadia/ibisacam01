import java.util.Random;
import java.util.Scanner;

public class Satzgenerator {
    static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] names = {"Frida", "Klaus", "Alfons", "Lisa", "Bert"};
        String[] verbs = {"singt", "denkt", "kichert", "rechnet", "weint", "lacht"};

        System.out.println("Wieviele Sätze?");
        int sentenceCount = scanner.nextInt();

        for (int i = 0; i < sentenceCount; i++) {
            System.out.println(names[random.nextInt(names.length)] + " " + verbs[random.nextInt(verbs.length)]);
        }
    }
}
