public class Schleife {
    static void main(String[] args) {
        System.out.println("Ausgabe alle Zahlen von -10 bis 90. For i.");
        for (int i = -10; i <= 90; i++) {
            System.out.println(i);
        }

        System.out.println("Ausgabe alle Zahlen von -10 bis 90. do while");
        int b = -10;
        do {
            System.out.println(b);
            b++;
        } while (b <= 90);

        System.out.println("for i Ausgabe jeden 3ten Zahl von 7 bis 111. for i.");
        for (int i = 7; i <= 111; i += 3) {
            System.out.println(i);
        }

        System.out.println("for i Ausgabe jeden 3ten Zahl von 7 bis 111. while.");
        int c = 7;
        while (c <= 111) {
            System.out.println(c);
            c += 3;
        }
    }
}
