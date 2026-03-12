public class PseudoCode {
    static void main(String[] args) {
        int c = 0;
        int number = 6;
        boolean isPrime = false;

        for (int i = 2; i < number; i++) {
            if(number % i == 0) {
                c++;
            }
        }
        isPrime = c == 0;
        System.out.println(isPrime);
    }
}
