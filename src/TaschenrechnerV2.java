import java.util.Scanner;

public class TaschenrechnerV2 {
    static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Gib die erste Zahl ein: ");
        int number1 = sc.nextInt();
        System.out.println("Gib die zweite Zahl ein: ");
        int number2 = sc.nextInt();
        System.out.println("Gib den Operator (+, -, *, /, %) ein:");
        char operator = sc.next().charAt(0);

        switch (operator) {
            case '+':
                System.out.println(number1 + " + " + number2 + " = " + (number1 + number2));
                break;
            case '-':
                System.out.println(number1 + " - " + number2 + " = " + (number1 - number2));
                break;
            case '*':
                System.out.println(number1 + " * " + number2 + " = " + (number1 * number2));
                break;
            case '/':
                System.out.println(number1 + " / " + number2 + " = " + (double) number1 / number2);
                break;
            case '%':
                System.out.println(number1 + " % " + number2 + " = " + (number1%number2));
                break;
            default:
                System.out.println("Falscher Operator.");
        }
    }
}
