import java.util.ArrayList;

public class Conways {
    static void main() throws InterruptedException {
        int width = 30;
        int height = 30;

        int[][] field = new int[height][width];
        //blinker
//        field[4][4] = 1;
//        field[5][5] = 1;
//        field[6][3] = 1;
//        field[6][4] = 1;
//        field[6][5] = 1;

        //glider
//        field[4][4] = 1;
//        field[5][5] = 1;
//        field[6][6] = 1;
//        field[5][7] = 1;
//        field[4][8] = 1;

        //2-glider mess
        field[4][6] = 1;
        field[5][4] = 1;
        field[5][6] = 1;
        field[6][5] = 1;
        field[6][6] = 1;
        field[7][15] = 1;
        field[8][13] = 1;
        field[8][14] = 1;
        field[9][14] = 1;
        field[9][15] = 1;


        int n;
        do {
            drawField(field);
            n = updateArr(field);
            Thread.sleep(500);
        } while (n > 0);
    }

    public static void drawField(int[][] field) {
        for (int i = 0; i < field[0].length-2; i++) {
            System.out.print(" # ");
        }
        System.out.println();

        for (int i = 1; i < field.length-1; i++) {
            for (int j = 1; j < field[i].length-1; j++) {
                String result;
                if (field[i][j] == 0) result = " . ";
                else result = " ¤ ";
                System.out.print(result);
            }
            System.out.println();
        }
        for (int i = 0; i < field[0].length-2; i++) {
            System.out.print(" # ");
        }
        System.out.println();
    }

    public static int updateArr(int[][] field) {
        ArrayList<ArrayList<Integer>> history = an(field);

        for (int i = 0; i < history.size(); i++) {
            ArrayList<Integer> h = history.get(i);
            field[h.get(0)][h.get(1)] = h.get(2);
        }
        return history.size();
    }

    public static ArrayList<ArrayList<Integer>> an(int[][] field) {
        ArrayList<ArrayList<Integer>> history = new ArrayList<>();

        for (int i = 1; i < field[i].length - 1; i++) {
            for (int j = 1; j < field.length - 1; j++) {
                int al = 0;
                al = countN(field, i, j, al);
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

    private static int countN(int[][] field, int i, int j, int al) {
        for (int k1 = -1; k1 <= 1; k1++) {
            for (int k2 = -1; k2 <= 1; k2++) {
                if(i + k1 < 0 || i + k1 > field[i].length || j + k2 < 0 || j+ k2 > field.length) continue;
                if (!(k1 == 0 && k2 == 0)) {
                    if (field[i + k1][j + k2] == 1) al++;
                }
            }
        }
        return al;
    }
}

//Есть еще вариант когда создаются два объекта и они сравниваются друг с другом и программа
// отрисовывает второй массив. Он присваивается к первому и таким образом происходит зацикливание.
//Поэтому надо проверять только те кто должен появится, второе пустое поле будет со всеми нулями.