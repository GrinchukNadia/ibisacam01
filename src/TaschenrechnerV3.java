import java.util.Scanner;

public class TaschenrechnerV3 {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char operator;
        int a;
        int b;

        do {
            System.out.println("Gib den Operator (+, -, *, /, %) ein: ");
            operator = scanner.next().charAt(0);


            System.out.println("Gib die erste Zahl ein: ");
            a = scanner.nextInt();

            System.out.println("Gib die zweite Zahl ein: ");
            b = scanner.nextInt();

            if (operator == 'X') break;


        } while (operator == '+' &&
                 operator == '-' &&
                 operator == '/' &&
                 operator == '*' &&
                 operator == '%');



        switch (operator) {
            case '+':
                System.out.println(a + " + " + b + " = " + (a + b));
                break;
            case '-':
                System.out.println(a + " - " + b + " = " + (a - b));
                break;
            case '*':
                System.out.println(a + " * " + b + " = " + (a * b));
                break;
            case '/':
                System.out.println(a + " / " + b + " = " + (double) a / b);
                break;
            case '%':
                System.out.println(a + " % " + b + " = " + (a % b));
                break;
            default:
                System.out.println("Falscher Operator.");
        }
    }
}
