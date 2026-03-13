public class Kassabon {
    static void main(String[] args){
        int n1 = 2;
        double n2 = 1.50;
        double sumN = (n1*n2);
        System.out.println(String.format("%-10s  %7d x %.2f \n %30.2f","Blumen", n1, n2, sumN));
        int o1 = 4;
        double o2 = 9.20;
        double sumO = (o1*o2);
        System.out.println(String.format("%-10s %7d x %.2f \n %30.2f", "Erde", o1, o2, sumO));
        int p1 = 4;
        double p2= 9.20;
        double sumP = (p1*p2);
        System.out.println(String.format("%-10s %7d x %.2f \n %30.2f","Palmen", p1, p2, sumP));
        int r1 = 9;
        double r2= 9.90;
        double sumR = (r1*r2);
        System.out.println(String.format("%-10s %7d x %.2f \n %30.2f","Kaktus",r1, r2, sumR));
        System.out.println(String.format("-------------------------------"));
        System.out.println(String.format("Gesamt:"));
        System.out.println(String.format("Bezahlt:"));
        System.out.println(String.format("Zurück:"));
    }
}
