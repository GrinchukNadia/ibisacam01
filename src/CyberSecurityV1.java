import java.util.ArrayList;
import java.util.Random;

public class CyberSecurityV1 {
    public static void main(String[] args) {
        String[] passwordCharacters = {"A", "B", "C", "a", "b", "c", "0", "1", "2", "!"};
        int passwordLength = 4;
        Random random = new Random();

        int generalAmountGuesses = 0;
        int bestCase = 9999;
        int worthCase = 0;

        for (int x = 0; x < 1000; x++) {
            String generatedPassword = "";
            int guesses = 0;
            String crackedPassword = "";
            ArrayList<Integer> passwordIndexes = new ArrayList<>();

            for (int i = 0; i < passwordLength; i++) {
                generatedPassword += passwordCharacters[random.nextInt(10)];
                passwordIndexes.add(0);
            }

//            int first = 0;
//            int second = 0;
//            int third = 0;
//            int fourth = 0;
            boolean combinationsAvailable = true;

            for (int e = 0; e < passwordIndexes.size(); e++) {
                int currentIndex = passwordIndexes.get(e);
                crackedPassword += passwordCharacters[currentIndex];
            }

            while (combinationsAvailable && !generatedPassword.equals(crackedPassword)) {
                    crackedPassword = "";
                for (int e = 0; e < passwordIndexes.size(); e++) {
                    int currentIndex = passwordIndexes.get(e);
                    crackedPassword += passwordCharacters[currentIndex];
                }
//                crackedPassword = String.format("%s%s%s%s",
//                        passwordCharacters[first],
//                        passwordCharacters[second],
//                        passwordCharacters[third],
//                        passwordCharacters[fourth]
//                );

                guesses++;
                if (generatedPassword.equals(crackedPassword)) {
                    if (guesses < bestCase) bestCase = guesses;
                    if (guesses > worthCase) worthCase = guesses;
                    generalAmountGuesses += guesses;
                }

                for (int y = passwordLength - 1; y >= 0; y--) {
                    passwordIndexes.set(passwordLength - 1,  (passwordIndexes.get(passwordLength -1)  +1));

                    if(passwordIndexes.get(y) > passwordCharacters.length - 1 && y != 2) {
                        passwordIndexes.set(y, 0);
                        passwordIndexes.set(y - 1, passwordIndexes.get(y - 1) +1);
                    }
                    if(passwordIndexes.getFirst() == passwordCharacters.length) combinationsAvailable = false;
                }

//                fourth++;
//                if (fourth > passwordCharacters.length - 1) {
//                    fourth = 0;
//                    third++;
//                }
//                if (third > passwordCharacters.length - 1) {
//                    third = 0;
//                    second++;
//                }
//                if (second > passwordCharacters.length - 1) {
//                    second = 0;
//                    first++;
//                }
//                if (first == passwordCharacters.length) combinationsAvailable = false;
            }

            System.out.println("Password: " + generatedPassword);
            System.out.println(String.format("Found it: %s == %s", crackedPassword, generatedPassword));
            System.out.println(String.format("Took %d guesses", guesses));
        }
        System.out.println(String.format("On average took %d guesses each time. Best case was %d guesses, worst case was %d guesses.", (generalAmountGuesses / 1000), bestCase, worthCase));
    }
}
