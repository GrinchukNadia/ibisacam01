import java.util.*;

public class Mastermind {
    static void main(String[] args) {
        int i = 0;
        int[][] allAnswers = new int[9][6];
        int[] secret = createSecret();

        do {
            int[] userGuess = readUserInput();
            allAnswers[i] = userGuess;
            int[] stats = evaluate(userGuess, secret);
            userGuess[4] = stats[0];
            userGuess[5] = stats[1];
            print(allAnswers);
            if (stats[0] == 4) {
                System.out.println("Gewonnen!!");
                break;
            }
            ++i;
        } while (i <= 8);
        if(i > 8) System.out.println("Du hast verloren.Versuche es noch einmal.");
    }

    static int[] evaluate(int[] guess, int[] secret) {
        int black = 0;
        int white = 0;
        ArrayList<Integer> guessFalse = new ArrayList<>();
        ArrayList<Integer> secretFalse = new ArrayList<>();
        for (int i = 0; i < secret.length; i++) {
            if (guess[i] == secret[i]) {
                black++;
            } else {
                guessFalse.add(guess[i]);
                secretFalse.add(secret[i]);
            }
        }
        for (int g : guessFalse) {
            for (int s : secretFalse) {
                if (g == s) white++;
                secretFalse.remove(Integer.valueOf(s));
                break;
            }
        }
        return new int[]{black, white};
    }

    static int[] createSecret() {
        Random random = new Random();
        int[] secretCombination = new int[4];
        for (int i = 0; i < secretCombination.length; i++) {
            secretCombination[i] = random.nextInt(1, 7);
        }
        //dev
        System.out.println(Arrays.toString(secretCombination));

        return secretCombination;
    }

    static int[] readUserInput() {
        Scanner scanner = new Scanner(System.in);
        int answer;

        do {
            System.out.print("Gib 4 Zahlen von 1 bis einschließlich 6 ein.\n");
            answer = scanner.nextInt();
        } while (String.valueOf(answer).length() != 4 || answer < 1111 || answer > 6666);

        char[] answerCharArr = String.valueOf(answer).toCharArray();
        int[] answerArr = new int[6];
        for (int j = 0; j < answerCharArr.length; j++) {
            answerArr[j] = answerCharArr[j] - 48;
        }
        System.out.printf("-> %d\n", answer);
        return answerArr;
    }

    static void print(int[][] map) {
        System.out.print("+---+---+---+---+------+\n");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < 4; j++) {
                String el = map[i][j] == 0 ? " " : String.valueOf(map[i][j]);
                System.out.printf("| %s ", el);
            }
            System.out.print("| ");
            for (int j = 0; j < map[i][4]; j++) System.out.print("#");
            for (int j = 0; j < map[i][5]; j++) System.out.print("+");

            int empty = 4 - map[i][4] - map[i][5];
            for (int j = 0; j < empty; j++) System.out.print(" ");
            System.out.print(" |\n");
            System.out.print("+---+---+---+---+------+\n");
        }

    }

}