import java.util.Objects;
import java.util.Scanner;

public class TaschenrechnerV42 {
    static void main(String[] args) {
//        (2 + 3) * (4 + 6)  ==> 2 3 + 4 6 + *      ==> 50
//        (9 + (2+3)*4 - 6   ==> 9 2 3 + 4 * + 6 -  ==> 23
//        (8 + 3 * 2)/(4-2)  ==> 8 3 2 * + 4 2 - /  ==> 7

        MyStack numStack = new MyStack();
        Scanner scanner = new Scanner(System.in);
        System.out.println(" /``````````````````````\\ ");
        System.out.println("| -- Print ! to stop. -- |");
        System.out.println(" \\..................... /");
        String next = "";
        do {
            next = scanner.nextLine();
            if(next.equals("!")) continue;

            if (Objects.equals(next, "+") || Objects.equals(next, "-") || Objects.equals(next, "*") || Objects.equals(next, "/")) {
                double result = count(numStack.pop(), numStack.pop(), next);
                numStack.push(result);
            } else numStack.push(Integer.parseInt(next));
            System.out.println(numStack);
        } while (!(next.equals("!")));
    }

    public static double count(double second, double first, String operator) {
        return switch (operator) {
            case "+" -> first + second;
            case "-" -> first - second;
            case "*" -> first * second;
            case "/" -> first / second;
            default -> 0;
        };
    }
}
