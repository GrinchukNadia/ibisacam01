package ausbildung.fotografie;

public class Camera {


    static public Integer counter = 0;

    String brand;
    Integer megaPixels;
    Integer displaySize;
    Boolean colored;
    Lens lens;

    public Camera(String brand, Integer megaPixels, Integer displaySize, Boolean colored, Lens lens) {
        this.brand = brand;
        this.megaPixels = megaPixels;
        this.displaySize = displaySize;
        this.colored = colored;
        this.lens = lens;
        counter++;
    }

    static void main() {

    }

    public Integer getCounter() {
        return counter;
    }

    public Lens getLens() {
        return this.lens;
    }

    @Override
    public String toString() {
        return "Camera " + this.brand + " with lence " + this.lens;
    }

    public String getBrand() {
        return brand;
    }

    public Integer getMegaPixels() {
        return megaPixels;
    }

    public Integer getDisplaySize() {
        return displaySize;
    }

    public Boolean getColored() {
        return colored;
    }
}
