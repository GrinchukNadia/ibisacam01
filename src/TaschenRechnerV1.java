public class TaschenRechnerV1 {
    static void main(String[] args){
        int firstNumber = 5;
        int secondNumber = 3;
        double division = (double) firstNumber / secondNumber;

        System.out.println("Erste Variable: " + firstNumber);
        System.out.println("Zweite Variable: " + secondNumber);
        System.out.println("Ergebnis der Addition: " + (firstNumber + secondNumber));
        System.out.println("Ergebnis der Subtraktion: " + (firstNumber - secondNumber));
        System.out.println("Ergebnis der Multiplikation: " + (firstNumber * secondNumber));
        System.out.println("Ergebnis der Division: " +  division);
        System.out.println("Ergebnis der ModuloRechnung:" + (firstNumber % secondNumber));
    }
}