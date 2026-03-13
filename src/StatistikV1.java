import java.util.Arrays;

public class StatistikV1 {
    static void main(String[] args) {
        String statistikString = "Unter #Handy finden sich 6 große Anbieter, 2 davon sind aber die besten!";
        char[] charsArray = statistikString.toCharArray();
        int capitalLetters = 0;
        int lowercaseLetters = 0;
        int numbers = 0;
        int specialCharacters = 0;

        for (int i = 0; i < charsArray.length; i++) {
            char currentChar = charsArray[i];
            if(currentChar >= 65 && currentChar <= 90) capitalLetters++;
            else if(currentChar >= 'a' && currentChar <= 'z') lowercaseLetters++;
            else if(currentChar >= '0' && currentChar <= '9') numbers++;
            else specialCharacters++;
        }
        System.out.println("Content: " + statistikString);
        System.out.println("Großbuchstaben: " + capitalLetters);
        System.out.println("Kleinbuchstaben: " + lowercaseLetters);
        System.out.println("Zahlen: " + numbers);
        System.out.println("Sonstige Zeichen: " + specialCharacters);
    }
}
