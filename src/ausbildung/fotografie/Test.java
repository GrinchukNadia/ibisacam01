package ausbildung.fotografie;

public class Test {
    static void main() throws Exception {
        Lens lens1 = new Lens(2.4, 4.6);
        Lens lens2 = new Lens(4.4, 6.0);
        Camera camera1 = new Camera("Nokia", 223, 22, true, lens1);
        Camera camera2 = new Camera("Canon", 123, 14, false, lens1);
        Camera camera3 = new Camera("Sony", 323, 20, true, lens2);

        System.out.println(camera1);
        System.out.println(lens1);
        lens2.setLens(1.4, 4.0);
        System.out.println(camera3);
        System.out.println(lens1.getCounter());
        System.out.println(camera2.getCounter());
    }
}
