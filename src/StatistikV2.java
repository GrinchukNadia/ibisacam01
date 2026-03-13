import java.util.Arrays;

public class StatistikV2 {
    static void main(String[] args) {
        int[] unsortedArray = {99, 7, 3, 22, 2, 4, 7, 5, 1};
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < unsortedArray.length; i++) {
                if (unsortedArray[i - 1] > unsortedArray[i]) {
                    int savedNumber = unsortedArray[i - 1];
                    unsortedArray[i - 1] = unsortedArray[i];
                    unsortedArray[i] = savedNumber;
                    isSorted = false;
                }
            }
        } ;
        System.out.println(Arrays.toString(unsortedArray));
    }
}
