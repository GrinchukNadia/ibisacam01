import java.util.ArrayList;
import java.util.Random;

public class Bingo {
    static <bolean> void main() {

        int[][] test = {
                {3, 1, 6, 13, 3},
                {27, 26, 19, 16, 21},
                {31, 36, 0, 32, 42},
                {56, 51, 48, 49, 59},
                {62, 64, 63, 65, 67},
        };

        printCard(generateCard());
        System.out.println("\n\n");
        printCard2(generateCard());
        boolean isValid = verifyCard(test);
        System.out.printf("This card is %s", isValid ? "valid" : "not valid");
    }

    static int[][] generateCard() {
        Random random = new Random();
        int step = 15;
        int[][] bingoField = new int[5][5];
        ArrayList<Integer> uniqueCheck = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                    int lower = step * i + 1;
                    int upper = step * (i + 1);
                    int randomNumber = random.nextInt(lower, upper);
                    while (uniqueCheck.contains(randomNumber)) {
                        randomNumber = random.nextInt(lower, upper);
                    }
                    bingoField[i][j] = randomNumber;
                    uniqueCheck.add(bingoField[i][j]);
            }
            bingoField[2][2] = 0;
        }
        return bingoField;
    }

    static void printCard(int[][] card) {
        for (int j = 0; j < card.length; j++) {
            for (int i = 0; i < card.length; i++) {
                if (i % 5 == 0 && card[i][j] != 0) System.out.println();
                if (i == 2 && j == 2) System.out.printf("%2s ", "*");
                else System.out.printf("%2d ", card[i][j]);
            }
        }
    }

    static void printCard2(int[][] card) {
        System.out.println("+----+----+----+----+----+");
        System.out.print("|  B |  I |  N |  G |  O |");

        for (int j = 0; j < card.length; j++) {
            for (int i = 0; i < card.length; i++) {
                if (i % 5 == 0 && card[i][j] != 0) System.out.print("\n+----+----+----+----+----+\n|");
                if (i == 2 && j == 2) System.out.printf(" %2s |", "*");
                else System.out.printf(" %2d |", card[i][j]);
            }
        }
        System.out.println("\n+----+----+----+----+----+");
    }

    static boolean verifyCard(int[][] card) {
        boolean verifyed = true;

        for (int[] ints : card) {
            if (card.length != 5) {
                verifyed = false;
                break;
            }
            int nextCompare = 0;
            for (int j = 0; j < ints.length; j++) {
                nextCompare++;
                if (ints.length != 5 || card[2][2] != 0) {
                    verifyed = false;
                    break;
                }
                while (nextCompare < ints.length) {
                    if (ints[j] == ints[nextCompare]) {
                        verifyed = false;
                        break;
                    }
                    nextCompare++;
                }
            }
        }
        return verifyed;
    }
}
