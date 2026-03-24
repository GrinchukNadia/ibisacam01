import java.util.Random;
import java.util.Scanner;

public class MinesweeperV2 {
    static void main() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int[][] mineField = new int[10][10];
        final int asciiA = 65;
        final int asciiJ = 74;
        final int ascii0 = 48;
        final int ascii9 = 57;
        int line = 0;
        int column = 0;
        boolean lost = false;

//      filling Array with random numbers
        for (int x = 0; x < mineField.length; x++) {
            for (int y = 0; y < mineField[x].length; y++) {
                int randomNumber = random.nextInt(-3, 1);
                mineField[x][y] = randomNumber;
            }
        }

        while (!lost) {
            print(mineField);

            //processing the answer
            String answer;
            boolean lengthValid;
            boolean firstValid;
            boolean secondValid;

            do {
                lengthValid = false;
                firstValid = false;
                secondValid = false;
                System.out.println("Wo willst du nach Minen suchen?");
                answer = scanner.nextLine().toUpperCase();

                // validation
                if (answer.length() == 2) {
                    lengthValid = true;
                    if ((int) answer.charAt(0) >= asciiA && (int) answer.charAt(0) <= asciiJ) {
                        column = (int) answer.charAt(0) - asciiA;
                        firstValid = true;
                    }

                    if ((int) answer.charAt(1) >= ascii0 && (int) answer.charAt(1) <= ascii9) {
                        line = (int) answer.charAt(1) - ascii0;
                        secondValid = true;
                    }
                }

            } while (!(lengthValid && firstValid && secondValid));

            System.out.printf("User input: %d/%d\n", column, line);

            //processing the selection
            if (mineField[line][column] == 0) {
                mineField[line][column] = 4;
                lost = true;
            } else if (mineField[line][column] == -1) {
                mineField[line][column] = -(mineField[line][column]);
            } else if(mineField[line][column] == -2 || mineField[line][column] == -3){
                int index;
                if(mineField[line][column] == -2) index = 1;
                else index = 2;

                for (int i = line - index; i <= line + index; i++) {
                    for (int j = column - index; j <= column + index; j++) {
                        if ((i >= 0 && i <= 9) && (j >= 0 && j <= 9)) {
                            if (mineField[i][j] == 0) mineField[i][j] = 4;
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
        int revealedSafeCells = 0;
        int totalMines = 0;
        int safeCells = 0;
        int foundMines = 0;

        for (int i = 0; i < a.length; i++) {
            System.out.println();
            if (i == 0) {
                for (char head : headers) {
                    System.out.printf("   %c", head);
                }
                System.out.println();
            }

            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 4 && j == 0) {
                    System.out.printf("%d [%s] ", i, "*");
                    foundMines++;
                } else if (a[i][j] > 0 && a[i][j] < 4 && j == 0) {
                    System.out.printf("%d [%s] ", i, "-");
                    revealedSafeCells++;
                } else if (a[i][j] == 4) {
                    System.out.printf("[%s] ", "*");
                    foundMines++;
                } else if (a[i][j] > 0 && a[i][j] < 4) {
                    System.out.printf("[%s] ", "-");
                    revealedSafeCells++;
                } else if (a[i][j] <= 0 && j == 0) {
                    System.out.printf("%d [ ] ", i);
                } else {
                    System.out.print("[ ] ");
                }

                if (a[i][j] != 0 && a[i][j] != 4) safeCells++;
                else totalMines++;
            }
        }

        //statistic
        System.out.printf("\nDu hast %d/%d (%.1f %%) des nicht verminten Gebiets auf Minen gecheckt\n",
                revealedSafeCells,
                safeCells,
                (double) revealedSafeCells * 100 / safeCells);
        if (totalMines == foundMines) {
            System.out.println("Du hast gewonnen!!!");
        }
        else System.out.printf("Es bleiben noch %d Minen versteckt.\n", totalMines - foundMines);
        System.out.println();
    }
}

// игра не заканчивается после того как выигрывал, надо ли это менять?
// надо ли проверять было ли уже введено поле или открыто ли оно уже?
// статистику я хотела изначально сделать не в принт но тогда не получается выводить после проигрыша


