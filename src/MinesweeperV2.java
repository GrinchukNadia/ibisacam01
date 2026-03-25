import java.util.Random;
import java.util.Scanner;

public class MinesweeperV2 {
    static void main() {
        Random random = new Random(0);
        Scanner scanner = new Scanner(System.in);
        int[][] mineField = new int[10][10];
        int line;
        int column;
        boolean lost = false;

        int revealedSafeCells = 0;
        int totalMines = 0;
        int safeCells;
        int foundMines = 0;

//      filling Array with random numbers
        for (int x = 0; x < mineField.length; x++) {
            for (int y = 0; y < mineField[x].length; y++) {
                int randomNumber = random.nextInt(-3, 1);
                mineField[x][y] = randomNumber;
                if(randomNumber == 0) totalMines++;
            }
        }

        while (!lost) {
            print(mineField);

            //statistic
            safeCells = 100 - totalMines;
            System.out.printf("\nDu hast %d/%d (%.1f %%) des nicht verminten Gebiets auf Minen gecheckt\n",
                    revealedSafeCells,
                    safeCells,
                    (double) revealedSafeCells * 100 / safeCells);
            if (totalMines == foundMines) {
                System.out.println("Du hast gewonnen!!!");
            } else System.out.printf("Es bleiben noch %d Minen versteckt.\n", totalMines - foundMines);
            System.out.println();

            //processing the answer
            String answer;
            do {
                System.out.println("Wo willst du nach Minen suchen?");
                answer = scanner.nextLine().toUpperCase();
            } while (!answer.matches("[A-J][0-9]"));

            column = (int) answer.charAt(0) - 'A';
            line = (int) answer.charAt(1) - '0';

            System.out.printf("User input: %d/%d\n", column, line);


            //processing the selection
            if (mineField[line][column] == 0) {
                mineField[line][column] = 4;
                foundMines++;
                lost = true;
            } else if (mineField[line][column] < 0) {
                int index = -mineField[line][column] - 1;
                revealedSafeCells++;

                for (int i = line - index; i <= line + index; i++) {
                    for (int j = column - index; j <= column + index; j++) {
                        if ((i >= 0 && i <= 9) && (j >= 0 && j <= 9)) {
                            if (mineField[i][j] == 0) {
                                foundMines++;
                                mineField[i][j] = 4;
                            }
                            else if (mineField[i][j] < 0) mineField[i][j] = -(mineField[i][j]);
                        }
                    }
                }
            }
        }
        print(mineField);
        System.out.println("Das... war eine Mine. Du hast leider verloren.");
    }

    static void print(int[][] a) {
        char[] headers = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

        for (int i = 0; i < a.length; i++) {
            System.out.println();
            if (i == 0) {
                for (char head : headers) {
                    System.out.printf("   %c", head);
                }
                System.out.println();
            }

            System.out.print(i + " ");
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 4) {
                    System.out.printf("[%s] ", "*");
                } else if (a[i][j] > 0 && a[i][j] < 4) {
                    System.out.printf("[%s] ", "-");
                } else {
                    System.out.print("[ ] ");
                }
            }
        }
        System.out.println();
    }
}



