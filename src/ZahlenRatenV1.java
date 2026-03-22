import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ZahlenRatenV1 {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int level = 1;

        do {
            do {
                System.out.println("Choose the level ( 1-3), or break (0);");
                level = scanner.nextInt();
            } while (level < 0 || level > 3);

            if (level == 1) {
                boolean isRunning = true;
                int randomNumber = random.nextInt(101);
                int attempts = 9;
                do {
                    int guess;
                    do {
                        //System.out.println("dev random number" + randomNumber);
                        System.out.println("Guess the number from 0 to 100");
                        System.out.printf("You have %d attempts \n", attempts);
                        guess = scanner.nextInt();
                    } while (guess < 0 || guess > 100);

                    if (guess == randomNumber) {
                        System.out.println("You won!!!");
                        isRunning = false;
                    } else if (guess > randomNumber) {
                        System.out.println("Number is smaller.");
                        --attempts;
                    } else {
                        System.out.println("Number is bigger");
                        --attempts;
                    }
                    if (attempts <= 0) {
                        System.out.println("You lost :(");
                        isRunning = false;
                    }
                } while (isRunning);
            }
            if (level == 2) {
                boolean isRunning = true;
                int randomNumber = random.nextInt(101);
                int attempts = 9;
                do {
                    int guess;
                    do {
                        //System.out.println("dev random number" + randomNumber);
                        System.out.println("Guess the number from 0 to 100");
                        System.out.printf("You have %d attempts \n", attempts);
                        guess = scanner.nextInt();
                    } while (guess < 0 || guess > 100);

                    int difference = guess - randomNumber;
                    String moreOrLess = difference > 0 ? "above" : "below";

                    if (guess == randomNumber) {
                        System.out.println("You won!!!");
                        isRunning = false;
                    } else if (difference >= 1 && difference <= 3 || difference >= -3 && difference <= -1) {
                        System.out.printf("Almost there, 1-3 %s the target.\n", moreOrLess);
                        --attempts;
                    } else if (difference >= 4 && difference <= 10 || difference >= -10 && difference <= -4) {
                        System.out.printf("Relatively close, 4-10 %s the target.\n", moreOrLess);
                        --attempts;
                    } else if (difference >= 11 && difference <= 20 || difference >= -20 && difference <= -11) {
                        System.out.printf("Not that far off, 11-20 %s the target.\n", moreOrLess);
                        --attempts;
                    } else if (difference >= 20 || difference <= -20) {
                        System.out.printf("Far off, more than 20 %s the target.\n", moreOrLess);
                        --attempts;
                    }
                    if (attempts <= 0) {
                        System.out.println("You lost :(");
                        isRunning = false;
                    }
                } while (isRunning);
            }
            if (level == 3) {
                boolean isRunning = true;
                int randomNumber = random.nextInt(1, 101);
                boolean computerFirst = random.nextBoolean();
                ArrayList<Integer> choices = new ArrayList<>();
                int lowerBound = 0;
                int upperBound = 100;
                do {
                    if (!computerFirst) {
                        // I guess
                        int guess;
                        do {
                            //System.out.println("dev random number" + randomNumber);
                            //System.out.println("upper bound " + upperBound);
                            //System.out.println("lower bound " + lowerBound);
                            System.out.println("Guess the number from 0 to 100");
                            guess = scanner.nextInt();
                        } while (guess < 0 || guess > 100);

                        choices.add(guess);
                        if (guess == randomNumber) {
                            System.out.println("You won!!!");
                            isRunning = false;
                        } else if (guess > randomNumber) {
                            System.out.println("The number is smaller.");
                            if (upperBound > guess) upperBound = guess;
                        } else {
                            System.out.println("The number is bigger");
                            if (lowerBound < guess) lowerBound = guess;
                        }

                        if (isRunning) {
                            //computer guesses
                            int computerGuess;
                            System.out.println("Computer is guessing...");
                            computerGuess = (upperBound - lowerBound) / 2 + lowerBound;
                            System.out.printf("Coumputer guess is: %d\n", computerGuess);
                            choices.add(computerGuess);
                            if (computerGuess == randomNumber) {
                                System.out.println("Computer won!!!");
                                isRunning = false;
                            } else if (computerGuess > randomNumber) {
                                System.out.println("The number is smaller.");
                                if (upperBound > computerGuess) upperBound = computerGuess;
                            } else {
                                System.out.println("The number is bigger");
                                if (lowerBound < computerGuess) lowerBound = computerGuess;
                            }
                        }
                    } else {
                        //computer guesses
                        int computerGuess;
                        System.out.println("Computer is guessing...");
                        computerGuess = (upperBound - lowerBound) / 2 + lowerBound;
                        System.out.printf("Coumputer guess is: %d\n", computerGuess);
                        choices.add(computerGuess);
                        if (computerGuess == randomNumber) {
                            System.out.println("Computer won!!!");
                            isRunning = false;
                        } else if (computerGuess > randomNumber) {
                            System.out.println("The number is smaller.");
                            if (upperBound > computerGuess) upperBound = computerGuess;
                        } else {
                            System.out.println("The number is bigger");
                            if (lowerBound < computerGuess) lowerBound = computerGuess;
                        }

                        if (isRunning) {
                            // I guess
                            int guess;
                            do {
                                //System.out.println("dev random number" + randomNumber);
                                //System.out.println("upper bound " + upperBound);
                                //System.out.println("lower bound " + lowerBound);
                                System.out.println("Guess the number from 0 to 100");
                                guess = scanner.nextInt();
                            } while (guess < 0 || guess > 100);
                            choices.add(guess);
                            if (guess == randomNumber) {
                                System.out.println("You won!!!");
                                isRunning = false;
                            } else if (guess > randomNumber) {
                                System.out.println("The number is smaller.");
                                if (upperBound > guess) upperBound = guess;
                            } else {
                                System.out.println("The number is bigger");
                                if (lowerBound < guess) lowerBound = guess;
                            }
                        }
                    }
                } while (isRunning);
                System.out.println(choices);
            }

        } while (level != 0);
    }
}