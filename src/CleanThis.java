public class CleanThis {
    public static void main(String[] args) {
        int age = 1;
        boolean withAdult = true;
        boolean VIP = true;

        if (age < 4) System.out.println("Kein Zutritt");
        else if (age >= 4 && age < 16 && withAdult) System.out.println("Rotes Band");
        else if (age >= 18) System.out.println("Grünes Band");
        else if (age >= 16 && age < 18) System.out.println("Gelbes Band");

        if ((age >= 4 && age < 16 && withAdult &&  VIP) || (age >= 16 && VIP)) {
            System.out.println("Goldenes Band dazu!");
        }
        else System.out.println("Kein goldenes Band dazu!");

    }
}
