public class KleinerAlgorithmusV1 {
    static void main(String[] args) {
        int a = 1;
        int b = 1;
        int c = a + b;
        int counter = 6;

        for (int i = 0; i < counter; i++) {
            System.out.println(a + " + " + b + " = " + c);
            a = b;
            b = c;
            c = a + b;
        }
    }
}
