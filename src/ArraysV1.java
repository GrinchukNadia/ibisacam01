import java.util.Arrays;
import java.util.Random;

public class ArraysV1 {
    static void main(String[] args) {
        Random random = new Random();
        int[] arrayOfNumbers = {2, 4, 12, 5, 75, 3, 1, 65, 36, 90};
        int[] arrayOfRandomNumbers = new int[100];

        boolean[] arrayOfBoolean = new boolean[10];

        for (int i = 0; i < 100 ; i++) {
            arrayOfRandomNumbers[i] = random.nextInt(101);
        }
        for (int i = 0; i < arrayOfBoolean.length; i= i+2) {
            arrayOfBoolean[i] = true;
        }
        System.out.println(Arrays.toString(arrayOfRandomNumbers));
        System.out.println(Arrays.toString(arrayOfNumbers));
        System.out.println(Arrays.toString(arrayOfBoolean));
    }
}
