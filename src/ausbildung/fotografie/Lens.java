package ausbildung.fotografie;

public class Lens {
    static public Integer counter = 0;
    Double min;
    Double max;

    public Lens(Double min, Double max) {
        this.min = min;
        this.max = max;
        counter++;
    }

    public void setLens(double min, double max) throws Exception {
        if(this.min > this.max) throw new Exception("Wrong focal Length");
        else {
            this.min = min;
            this.max = max;
        }
    }

    public Integer getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return "Lens min: " + min + ", lens max: " + max + ".";
    }
}
