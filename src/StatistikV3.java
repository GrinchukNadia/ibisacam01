import java.util.Arrays;
import java.util.Random;

public class StatistikV3 {
    static void main(String[] args) {
//        Random random = new Random();
//        int arrayLength = 10;
//        int[] unsortedArray = new int[arrayLength];
//        for (int i = 0; i < unsortedArray.length ; i++) {
//            unsortedArray[i] = random.nextInt(10);
//        }
        int[] unsortedArray = {0, 10, 3, 8, 9, 1, 3, 9, 6, 0};
        int[] sortedArray = sortArray(Arrays.copyOf(unsortedArray, unsortedArray.length));


        System.out.println("Urliste:");
        printArray(unsortedArray);
        System.out.println("\nAufsteigend sortiert:");
        printArray(sortedArray);
        System.out.printf("\nArithmetisches Mittel: %.1f", mean(sortedArray));
        System.out.printf("\nSpannweite: %d", max(sortedArray) - min(sortedArray));
        System.out.printf("\nMedian: %.1f", mean(sortedArray));
        System.out.printf("\nModalwert: %d mit %d", modal(sortedArray)[0], modal(sortedArray)[1]);
        System.out.printf("\nMittlere absolute Abweichung: %.1f", mad(sortedArray));
        System.out.printf("\nMedian ist: %.1f", median(sortedArray));
    }

    public static int min(int[] values) {
        int min = values[0];
        for (int i = 1; i < values.length; i++) {
            if (min > values[i]) min = values[i];
        }
        return min;
    }


    public static int max(int[] values) {
        int max = values[0];
        for (int i = 0; i < values.length; i++) {
            if (max < values[i]) max = values[i];
        }
        return max;
    }


    public static int sum(int[] values) {
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        return sum;
    }

    public static double mean(int[] values) {
        return (double) sum(values) / values.length;
    }

    public static double median(int[] values) {
        int index;
        double median;
        if (values.length % 2 == 0) {
            index = values.length / 2;
            median = (double) (values[index - 1] + values[index]) / 2;
        } else {
            index = values.length / 2;
            median = values[index];
        }
        return median;
    }

    public static int[] modal(int[] values) {
        int mode = 0;
        int modeCount = 0;
        int tempCount = 1;

        int comparedValue = values[0];
        for (int i = 1; i < values.length; i++) {
            if (comparedValue == values[i]) {
                tempCount++;
            } else tempCount = 1;

            if (tempCount > modeCount) {
                modeCount = tempCount;
                mode = comparedValue;
            }
            comparedValue = values[i];
        }
        return new int[]{mode, (modeCount)};
    }

    public static double mad(int[] values) {
        double meanValue = mean(values);
        double madSum = 0;

        for (int i = 0; i < values.length; i++) {
            double madDifference = (values[i] - meanValue);
            double positivMadDifference = madDifference < 0 ? -(madDifference) : madDifference;
            madSum += positivMadDifference;
        }
        return madSum / values.length;
    }

    public static void printArray(int[] values) {
        for (int i = 0; i < values.length; i++) {
            System.out.printf("[%d]", values[i]);
        }
    }

    public static int[] sortArray(int[] values) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < values.length; i++) {
                if (values[i - 1] > values[i]) {
                    int savedNumber = values[i - 1];
                    values[i - 1] = values[i];
                    values[i] = savedNumber;
                    isSorted = false;
                }
            }
        }
        return values;
    }
}
