import java.util.Random;

public class MuenzeWerfenV1 {
    static void main(){
        Random random = new Random();
        boolean heads = random.nextBoolean();

        if(heads) {
            System.out.println("Die Münze ist auf Kopf gelandet – ich gewinne.");
        } else {
            System.out.println("Die Münze ist auf Zahl gelandet – Stefan gewinnt.");
        }
    }
}
