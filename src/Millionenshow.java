import java.util.Random;
import java.util.Scanner;

public class Millionenshow {
    static void main() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String[][] questions = {
                {"Was bedeutet HTML?", "HyperText Markup Language", "HighText Machine Language", "Hyperlink and Text Markup Language", "1"},
                {"Welches Ergebnis liefert folgender Ausdruck: (true&&false||true)", "false", "true", "2"},
                {"Die Netzwerk-Technik verwendet man ...", "beim Fischen", "zum Vernetzen von Computern", "2"},
                {"Ein Null-pointer ...", "gibt es nicht", "ist eine Referenz, die auf kein Objekt zeigt", "Datentyp für Text", "ärgerlich", "2"},
                {"Eine 'if-Schleife' ist ...", "eine Schleif-Maschine für Tischler", "ein Kündigungsgrund", "gibt es nicht", "3"},
                {"Was macht ein Compiler?", "Er analysiert Netzwerke", "Er führt Programme aus", "Er wandelt Quellcode in Maschinencode um", "Er speichert Dateien", "3"}
        };
        double money = 100;

//      random unique questions algorithm
        int[] randomOrder = new int[questions.length];
        boolean isUnique = false;
        boolean uniqueZero = true;
        for (int i = 0; i < questions.length; i++) {
            int randomNumber = random.nextInt(questions.length);

            for (int value : randomOrder) {
                if (randomNumber == 0 && uniqueZero) {
                    uniqueZero = false;
                    isUnique = true;
                    break;
                }
                if (value == randomNumber) {
                    isUnique = false;
                    break;
                }
                isUnique = true;
            }
            if (isUnique) randomOrder[i] = randomNumber;
            else i--;
        }
//      end random unique questions algorithm

        int answer;
        boolean outRange = true;
        int correctAnswer;
        for (int i = 0; i < questions.length; i++) {
            String[] question = questions[randomOrder[i]];

//          Question
            System.out.println(question[0]);
            System.out.println("-----------------------------------------");

//          Answers
            do {
                for (int x = 1; x < question.length - 1; x++) {
                    System.out.println(String.format("%d. %s", x, question[x]));
                }
                correctAnswer = Integer.parseInt(question[question.length - 1]);
                answer = scanner.nextInt();
                outRange = answer < 1 || answer > correctAnswer;
            } while (outRange);

            if (answer == correctAnswer) {
                System.out.println(String.format("Deine Antwort: %d", answer));
                System.out.println("Richtig");
                System.out.println(" ");
                money *= 2;
            } else {
                System.out.println(String.format("Deine Antwort: %d", answer));
                System.out.println("Falsch");
                System.out.println(" ");
                money /= 10;
            }
        }
        System.out.println(String.format("Gewinn: %.0f", money));
    }
}
