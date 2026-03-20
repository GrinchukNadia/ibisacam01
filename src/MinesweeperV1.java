import java.util.*;

public class MinesweeperV1 {
    static void main() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String[][] map = new String[10][10];
        char[] headers = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        int myCount = 0;
        int guessed = 0;
        int line = map.length;
        int column = ' ';
        boolean cleaned;
        boolean lost = false;

//      filling Array with random numbers
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                int randomNumber = random.nextInt(-3, 1);
                if (randomNumber == 0) myCount++;
                map[x][y] = String.valueOf(randomNumber);
            }
        }

        while (!lost) {
//          drawing field in console
            for (int i = 0; i < map.length; i++) {
                System.out.println("");
                if (i == 0) {
                    for (char head : headers) {
                        System.out.printf("   %c", head);
                    }
                    System.out.println("");
                }
                for (int j = 0; j < map[i].length; j++) {
                    if (i == line && j == column) {
                        if (j == 0 && (Objects.equals(map[i][j], "0"))) {
                            lost = true;
                            System.out.printf("%d [%s] ", i, "*");
                        } else if (j == 0 && !(Objects.equals(map[i][j], "0"))) {
                            System.out.printf("%d [%s] ", i, "-");
                            map[i][j] = "-";
                        } else if ((Objects.equals(map[i][j], "0"))) {
                            lost = true;
                            System.out.printf("[%s] ", "*");
                        } else {
                            System.out.printf("[-] ");
                            map[i][j] = "-";
                        }
                    } else if (j == 0) {
                        String field = Objects.equals(map[i][j], "-") ? "-" : " ";
                        System.out.printf("%d [%s] ", i, field);
                    } else if (Objects.equals(map[i][j], "-")) {
                        System.out.print("[-] ");
                    } else System.out.print("[ ] ");
                }
            }

            System.out.println("\n");
            System.out.printf("Du hast 0/%d (0.0 %%) des nicht verminten Gebiets auf Minen gecheckt\n", myCount);
            System.out.printf("Es bleiben noch %d Minen versteckt.\n", (myCount - guessed));

            String answer = "";
            if (!lost) {
                System.out.println("Wo willst du nach Minen suchen?");
                answer = scanner.nextLine().toUpperCase();
                char columnChar = answer.charAt(0);
                line = Integer.parseInt(String.valueOf(answer.charAt(1)));
                for (int c = 0; c < headers.length; c++) {
                    if (columnChar == headers[c]) column = c;
                }
            }
        }
        System.out.println("Das... war eine Mine. Du hast leider verloren.");
    }
}
