public class TaschenRechnerV1 {
    static void main(String[] args){
        int a = 5;
        int b = 3;
        double division = (double) a / b;

        System.out.println("Erste Variable: " + a);
        System.out.println("Zweite Variable: " + b);
        System.out.println("Ergebnis der Addition: " + (a+b));
        System.out.println("Ergebnis der Subtraktion: " + (a-b));
        System.out.println("Ergebnis der Multiplikation: " + (a*b));
        System.out.println("Ergebnis der Division: " +  division);
        System.out.println("Ergebnis der ModuloRechnung:" + (a%b));
    }
}