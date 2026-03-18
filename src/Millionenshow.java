import java.util.Arrays;
import java.util.Random;

public class Millionenshow {
    static void main() {
        Random random = new Random();
        String[][] questions = {
                {"Was bedeutet HTML?", "HyperText Markup Language", "HighText Machine Language", "Hyperlink and Text Markup Language", "1"},
                {"Welches Ergebnis liefert folgender Ausdruck: (true&&false||true)", "false", "true", "2"},
                {"Die Netzwerk-Technik verwendet man ...", "beim Fischen", "zum Vernetzen von Computern", "2"},
                {"Ein Null-pointer ...", "gibt es nicht", "ist eine Referenz, die auf kein Objekt zeigt", "Datentyp für Text", "ärgerlich", "2"},
                {"Eine 'if-Schleife' ist ...", "eine Schleif-Maschine für Tischler", "ein Kündigungsgrund", "gibt es nicht", "3"},
                {"Was macht ein Compiler?", "Er analysiert Netzwerke", "Er führt Programme aus", "Er wandelt Quellcode in Maschinencode um", "Er speichert Dateien", "3"}
        };
        int win = 100;
        int[] randomOrder = new int[questions.length];

        boolean isUnique = false;
        for (int i = 0; i < questions.length; i++) {
            int randomNumber = random.nextInt(questions.length );

            for (int value : randomOrder) {
                if(value == randomNumber) {
                    isUnique = false;
                    break;
                }
                isUnique = true;
            }
            if(isUnique) randomOrder[i] = randomNumber ;
            else i--;
        }

//        for (int i = 0; i < questions.length; i++) {
//            System.out.println(questions[randomOrder[i] - 1][0]);
//        }
    }
}
