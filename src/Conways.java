import java.util.ArrayList;

public class Conways {
    static void main() {
        int width = 30;
        int height = 30;

        int[][] field = new int[height][width];

        field[4][4] = 1;
        field[5][5] = 1;
        field[6][3] = 1;
        field[6][4] = 1;
        field[6][5] = 1;

        int a = 0;
        while (a < 80) {
            ArrayList<ArrayList<Integer>> history = an(field);
            drawField(field);
            drawField(field, history);
            a++;
        }
    }

    public static void drawField(int[][] field) {
        for (int i = 0; i < field[0].length; i++) {
            System.out.print(" # ");
        }
        System.out.println();

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                String result;
                if (field[i][j] == 0) result = " . ";
                else result = " ¤ ";
                System.out.print(result);
            }
            System.out.println();
        }
        for (int i = 0; i < field[0].length; i++) {
            System.out.print(" # ");
        }
        System.out.println();
    }

    public static void drawField(int[][] field, ArrayList<ArrayList<Integer>> history) {

        for (int i = 0; i < field[0].length; i++) {
            System.out.print(" # ");
        }
        System.out.println();

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                String result = "";
                for (ArrayList<Integer> h : history) {
                    if (h.get(0) == i && h.get(1) == j) {
                        result = h.get(2) == 0 ? " . " : " ¤ ";
                        field[i][j] = h.get(2);
                    } else if (field[i][j] == 0) result = " . ";
                    else result = " ¤ ";
                }
                System.out.print(result);
            }
            System.out.println();
        }
        for (int i = 0; i < field[0].length; i++) {
            System.out.print(" # ");
        }
        System.out.println();
    }

    public static ArrayList<ArrayList<Integer>> an(int[][] field) {
        ArrayList<ArrayList<Integer>> history = new ArrayList<>();
        for (int i = 1; i < field[i].length - 1; i++) {
            for (int j = 1; j < field.length - 1; j++) {
                int al = 0;
                for (int k1 = -1; k1 <= 1; k1++) {
                    for (int k2 = -1; k2 <= 1; k2++) {
                        if (!(k1 == 0 && k2 == 0)) {
                            if (field[i + k1][j + k2] == 1) al++;
                        }
                    }
                }
                if (field[i][j] == 0 && al == 3) {
                    int finalI = i;
                    int finalJ = j;
                    history.add(new ArrayList<>() {{
                        add(finalI);
                        add(finalJ);
                        add(1);
                    }});
                } else if (field[i][j] == 1 && (al < 2 || al > 3)) {
                    int finalI = i;
                    int finalJ = j;
                    history.add(new ArrayList<>() {{
                        add(finalI);
                        add(finalJ);
                        add(0);
                    }});
                }
            }
        }
        return history;
    }
}
