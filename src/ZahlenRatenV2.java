import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ZahlenRatenV2 {
    static void main() {
        Random random = new Random();
        int secretNumber = random.nextInt(101);
        Scanner scanner = new Scanner(System.in);
        boolean computerFirst = random.nextBoolean();
        boolean notGuessed = true;

        System.out.printf("Number to guess is: %d.\n", secretNumber);

        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i <= 100; i++) {
            numbers.add(i);
        }

        do {
            int guess;
            if (computerFirst) {
                // computer is guessing
                guess = numbers.get(random.nextInt(numbers.size()));
                System.out.printf("\ncomputer guessing: %d\n", guess);

            } else {
                // I'm guessing
                System.out.println("\nI'm guessing");
                guess = scanner.nextInt();
                System.out.printf("\nI'm guessing: %d\n", guess);
            }

            int difference = guess - secretNumber;
            difference = difference < 0 ? -(difference) : difference;

            if (guess == secretNumber) {
                System.out.println("You won!!!");
                notGuessed = false;
            } else if (difference <= 3) {
                System.out.print("\nFeedback: 1...3.\n");
                removeRange(numbers, 0, guess - 4);
                removeRange(numbers, guess + 4, 100);
                removeRange(numbers, guess, guess);
            } else if (difference <= 10) {
                System.out.print("\nFeedback: 4...10.\n");
                removeRange(numbers, 0, guess - 11);
                removeRange(numbers, guess + 11, 100);
                removeRange(numbers, guess - 3, guess + 3);
            } else if (difference <= 20) {
                System.out.print("\nFeedback: 11...20.\n");
                removeRange(numbers, 0, guess - 21);
                removeRange(numbers, guess + 21, 100);
                removeRange(numbers, guess - 10, guess + 10);

            } else {
                System.out.print("\nFeedback: > 20.\n");
                removeRange(numbers, guess - 20, guess + 20);
            }

            computerFirst = !computerFirst;
            print(numbers);

        } while (notGuessed);
    }


    static void removeRange(ArrayList<Integer> al, int lower, int upper) {
        for (int i = 0; i < al.size(); i++) {
            if (al.get(i) >= lower && al.get(i) <= upper) {
                al.remove(i);
                i--;
            }
        }
    }

    static void print(ArrayList<Integer> al) {
        for (int i = 0; i < 100; i++) {
            System.out.print(al.contains(i) ? "*" : ".");
        }
    }
}