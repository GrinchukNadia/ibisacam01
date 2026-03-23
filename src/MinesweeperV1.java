import java.util.*;

public class MinesweeperV1 {
    static void main() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int[][] mineField = new int[10][10];
        char[] headers = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        int asciiA = 65;
        int ascii0 = 48;
        int myCount = 0;
        int guessed = 0;
        int line = headers.length;
        int column = headers.length;
        int cleaned = 0;
        boolean lost = false;

//      filling Array with random numbers
        for (int x = 0; x < mineField.length; x++) {
            for (int y = 0; y < mineField[x].length; y++) {
                int randomNumber = random.nextInt(-3, 1);
                if (randomNumber == 0) myCount++;
                mineField[x][y] = randomNumber;
            }
        }

        while (!lost) {
//          drawing field in console
            for (int i = 0; i < mineField.length; i++) {
                System.out.println();
                if (i == 0) {
                    for (char head : headers) {
                        System.out.printf("   %c", head);
                    }
                    System.out.println();
                }
                for (int j = 0; j < mineField[i].length; j++) {
                    if (i == line && j == column) {
                        if (j == 0 && mineField[i][j] == 0) {
                            lost = true;
                            System.out.printf("%d [%s] ", i, "*");
                        } else if (j == 0 && !(mineField[i][j] == 0)) {
                            System.out.printf("%d [%s] ", i, "-");
                            mineField[i][j] = -(mineField[i][j]);
                            cleaned++;
                        } else if (mineField[i][j] == 0) {
                            lost = true;
                            System.out.printf("[%s] ", "*");
                        } else {
                            System.out.print("[-] ");
                            mineField[i][j] = -(mineField[i][j]);
                            cleaned++;
                        }
                    } else if (j == 0) {
                        String field = mineField[i][j] > 0 ? "-" : " ";
                        System.out.printf("%d [%s] ", i, field);
                    } else if (mineField[i][j] > 0) {
                        System.out.print("[-] ");
                    } else System.out.print("[ ] ");
                }
            }

            //statistic
            System.out.println("\n");
            int notMined = 100 - myCount;
            System.out.printf("Du hast %d/%d (%.1f %%) des nicht verminten Gebiets auf Minen gecheckt\n", cleaned, notMined, (double) cleaned*100/notMined);
            System.out.printf("Es bleiben noch %d Minen versteckt.\n", (myCount - guessed));

            //processing the answer
            String answer;
            if (!lost) {
                System.out.println("Wo willst du nach Minen suchen?");
                answer = scanner.nextLine().toUpperCase();
                line = (int) answer.charAt(1) - ascii0;
                column = (int) answer.charAt(0) - asciiA;
                System.out.printf("User input: %d/%d", column, line);
            }
        }
        System.out.println("Das... war eine Mine. Du hast leider verloren.");
    }
}
