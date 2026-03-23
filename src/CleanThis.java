public class CleanThis {
    public static void main(String[] args) {
        int age = 1;
        boolean withAdult = true;
        boolean VIP = true;
        boolean access = true;

        if (age < 4) {
            access = false;
            System.out.println("Kein Zutritt");
        } else if (age < 16 && withAdult) System.out.println("Rotes Band");
        else if (age >= 16 && age < 18) System.out.println("Gelbes Band");
        else if (age >= 18) System.out.println("Grünes Band");
        else access = false;
        if (access && VIP) {
            System.out.println("Goldenes Band dazu!");
        } else System.out.println("Kein goldenes Band dazu!");
    }
}
