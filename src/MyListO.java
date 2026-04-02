public class MyListO {

    private double[] data = new double[1];
    private int size = 0;


    public static void main() {
        MyListO test = new MyListO();
        test.add(2.2);
        test.add(3.3);
        test.add(4.3);
        MyListO test2 = new MyListO();
        test2.add(7.1);
        test2.add(1.1);
        System.out.println(test);
        System.out.println(test2);
        test2.remove(0);
        System.out.println(test2);
    }

    public double[] add(double v) {
        if (size == data.length) resize();
        data[size] = v;
        size++;
        return data;
    }

    public void add(int pos, double v) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Ungültiger Index: " + pos);
        }
        if (data.length - size < 1) resize();
        double[] newList = new double[data.length];
        for (int i = size; i < pos; i++) {
            data[i] = data[i - 1];
        }
        data[pos] = v;
        data = newList;
        size++;
    }


    public double get(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("Ungültiger Index: " + idx);
        }
        return data[idx];
    }

    public double remove(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("Ungültiger Index: " + idx);
        }
        double removed = data[idx];
        if (data.length - size() < 1) resize();
        for (int i = idx; i < size + 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return removed;
    }

    int size() {
        return size;
    }

    void clear() {
        data = new double[size];
        size = 0;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            result.append(data[i]).append(" ");
        }
        return result.toString().trim();
    }

    private  void resize() {
        double[] newData = new double[size * 2];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}

