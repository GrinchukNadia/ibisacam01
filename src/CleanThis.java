public class CleanThis {
    public static void main(String[] args) {
        int age = 17;
        boolean withAdult = true;
        boolean VIP = true;

        if (!withAdult && age < 4) System.out.println("Kein Zutritt");

        if (age >= 18) System.out.println("Grünes Band");
        else if (age >= 16 && age < 18) System.out.println("Gelbes Band");
        else if (age >= 4 && age < 16 && withAdult) {
            System.out.println("Rotes Band");
        }

        if (VIP) System.out.println("Goldenes Band dazu!");
        else System.out.println("Kein goldenes Band dazu!");
    }
}
