import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Lotterie {
    static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("data/lotto10k.txt"));
        int valid = 0;
        int invalid = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        int count6 = 0;
        ArrayList<Integer> invalidArr = new ArrayList<>();
//        int[] ourChoice = createNumbers();
        int[] ourChoice = new int[]{6, 10, 14, 22, 26, 33};
        while (br.ready()) {
            String line = br.readLine();
            String[] testStr = line.split(";");
            int[] test = new int[6];
            for (int i = 0; i < 6; i++) {
                test[i] = Integer.parseInt(testStr[i + 1]);
            }
            if (validate(line)) {
                valid++;
            } else {
                invalid++;
                invalidArr.add(Integer.parseInt(line.substring(0, 6)));
            }

            int counter = countEquals(ourChoice, test);
            switch (counter) {
                case 3:
                    count3++;
                    break;
                case 4:
                    count4++;
                    break;
                case 5:
                    count5++;
                    break;
                case 6:
                    count6++;
                    break;
            }
        }
        br.close();

        System.out.println();
        System.out.printf("Gültige Tipps: %6s\n", valid);
        System.out.printf("Ungültige Tipps: %4s\n\n", invalid);
        System.out.println("Gezogene Zahlen: " + Arrays.toString(ourChoice));
        System.out.println("--------------------------------------------------");
        System.out.printf("3er: %-5s\n", count3);
        System.out.printf("4er: %-5s\n", count4);
        System.out.printf("5er: %-5s\n", count5);
        System.out.printf("6er: %-5s\n", count6);
        System.out.println("--------------------------------------------------");
        System.out.println("Ungültig: " + invalidArr);
    }

    static int[] createNumbers() {
        Random random = new Random();
        int[] numbers = new int[6];
        ArrayList<Integer> uniqueNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            int randomNumber = 0;
            if (!uniqueNumbers.contains(randomNumber)) {
                randomNumber = random.nextInt(1, 46);
                uniqueNumbers.add(randomNumber);
                numbers[i] = randomNumber;
            }
        }
        Arrays.sort(numbers);
        return numbers;
    }

    static int countEquals(int[] a1, int[] a2) {
        int counter = 0;
        int i = 0;
        int k = 0;
        while(i<a1.length && k <a2.length) {
            if(a1[i] == a2[k]){
                counter++;
                i++;
                k++;
            } else if(a1[i] < a2[k]) {
                i++;
            } else k++;
        }
        return counter;
    }

    static boolean validate(String s) {
        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            sum += s.charAt(i);
        }
        return Integer.parseInt(String.valueOf(s.charAt(s.length() - 1))) == sum % 10;
    }

}
