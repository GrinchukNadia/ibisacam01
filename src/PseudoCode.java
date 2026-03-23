public class PseudoCode {
    static void main(String[] args) {
        int c = 0;
        int number = 5;
        boolean isPrime = true;

        for (int i = 2; i < number && isPrime; i++) {
            if(number % i == 0) {
                isPrime = false;
            }
        }
        System.out.println(isPrime);
    }
}
