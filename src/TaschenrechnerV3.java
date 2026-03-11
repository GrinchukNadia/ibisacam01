import java.util.Scanner;

public class TaschenrechnerV3 {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isCounting = true;

        while (isCounting) {
            System.out.println("Gib den Operator (+, -, *, /, %) ein: ");
            char operator = scanner.next().charAt(0);

            if (operator == '+' ||
                operator == '-' ||
                operator == '/' ||
                operator == '*' ||
                operator == '%'
            ) {
                System.out.println("Gib die erste Zahl ein: ");
                int number1 = scanner.nextInt();
                System.out.println("Gib die zweite Zahl ein: ");
                int number2 = scanner.nextInt();

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
                        System.out.println(number1 + " % " + number2 + " = " + (number1 % number2));
                        break;
                    default:
                        System.out.println("Gib den Operator (+, -, *, /, %) ein: ");
                }
            }
            if (operator == 'X') isCounting = false;
        }
    }
}
