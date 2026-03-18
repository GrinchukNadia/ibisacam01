import java.util.Random;

public class CyberSecurityV1 {
    static void main() {
        Random random = new Random();
        String[] passwordCharacters = {"A", "B", "C", "a", "b", "c", "0", "1", "2", "!"};
        int passwordLength = 3;

        int totalGuesses = 0;
        int bestCase = (int) Math.pow(passwordCharacters.length, passwordLength);
        int worstCase = 0;

        for (int attempts = 0; attempts < 1000; attempts++) {
            String generatedPassword = "";
            int guesses = 0;
            String crackedPassword = "";
            int[] passwordIndexes = new int[passwordLength];

            for (int i = 0; i < passwordLength; i++) {
                generatedPassword += passwordCharacters[random.nextInt(passwordCharacters.length)];
                passwordIndexes[i] = 0;
            }


            boolean combinationsAvailable = true;
            while (combinationsAvailable && !generatedPassword.equals(crackedPassword)) {
                crackedPassword = "";
                for (int currentIndex : passwordIndexes) {
                    crackedPassword += passwordCharacters[currentIndex];
                }

                guesses++;
                if (generatedPassword.equals(crackedPassword)) {
                    if (guesses < bestCase) bestCase = guesses;
                    if (guesses > worstCase) worstCase = guesses;
                    totalGuesses += guesses;
                }

                passwordIndexes[passwordLength - 1] ++;
                for (int y = passwordLength - 1; y >= 0; y--) {

                    if (passwordIndexes[y] >= passwordCharacters.length) {
                        if (y == 0) combinationsAvailable = false;
                        else {
                            passwordIndexes[y] = 0;
                            passwordIndexes[y - 1]++;
                        }
                    }
                }
            }
            System.out.println("Password: " + generatedPassword);
            System.out.printf("Found it: %s == %s%n", crackedPassword, generatedPassword);
            System.out.printf("Took %d guesses%n", guesses);
        }
        System.out.printf("On average took %d guesses each time. Best case was %d guesses, worst case was %d guesses.%n", (totalGuesses / 1000), bestCase, worstCase);
    }
}
