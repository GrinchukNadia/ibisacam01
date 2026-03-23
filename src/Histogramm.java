import java.util.Arrays;
import java.util.Random;

public class Histogramm {
    static void main(String[] args) {
        Random random = new Random();
        int[] randomNumbersArray = new int[100];
        String[] statistic = new String[10];
        Arrays.fill(statistic, "");

        for (int i = 0; i < 100; i++) {
            randomNumbersArray[i] = random.nextInt(10);
        }

        for (int j : randomNumbersArray) {
            for (int x = 0; x < statistic.length; x++) {
                if (j == x) statistic[x] += "*";
            }
        }

        for (int i = 0; i < statistic.length; i++) {
            System.out.println( i + " " + statistic[i]);
        }
    }
}
