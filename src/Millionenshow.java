import java.util.ArrayList;
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
        ArrayList<Integer> randomOrder = new ArrayList<>();
        while(randomOrder.size() < questions.length ) {
            int randomNumber = random.nextInt(questions.length);
            if(!randomOrder.contains(randomNumber)) randomOrder.add(randomNumber);
        }

        int answer;
        boolean outRange;
        int correctAnswer;
        for (int i = 0; i < questions.length; i++) {
            String[] question = questions[randomOrder.get(i)];

//          Question
            System.out.println(question[0]);
            System.out.println("-----------------------------------------");

//          Answers
            do {
                for (int x = 1; x < question.length - 1; x++) {
                    System.out.printf("%d. %s\n", x, question[x]);
                }
                correctAnswer = Integer.parseInt(question[question.length - 1]);
                answer = scanner.nextInt();
                outRange = answer < 1 || answer > (question.length - 2);
            } while (outRange);

            if (answer == correctAnswer) {
                System.out.printf("Deine Antwort: %d\n", answer);
                System.out.println("Richtig");
                System.out.println(" ");
                money *= 2;
            } else {
                System.out.printf("Deine Antwort: %d\n", answer);
                System.out.println("Falsch");
                System.out.println(" ");
                money /= 10;
            }
        }
        System.out.printf("Gewinn: %.0f", money);
    }
}
