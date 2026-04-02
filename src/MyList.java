import java.util.Arrays;

public class MyList {

    private static double[] data = new double[1];
    private static int size = 0;

    static void main() {
        MyList.add(2.2);
        String result = MyList.print();

        System.out.println(result);
        MyList.add(0.2);
        System.out.println(MyList.print());

        System.out.println(MyList.size());

        MyList.add(5.8);
        System.out.println(MyList.print());

        MyList.add(0, 7.7);
        System.out.println(MyList.print());

        MyList.add(3, 1.1);
        System.out.println(MyList.print());

        MyList.remove(0);
        System.out.println(MyList.print());

        System.out.println(MyList.get(0));

        double removedNr = MyList.remove(2);
        System.out.println(removedNr);

        MyList.clear();
        System.out.println(MyList.print());

        MyList.get(2);
    }

    public static double[] add(double v) {
        if (size == data.length) resize();
        data[size] = v;
        size++;
        return data;
    }

    public static void add(int pos, double v) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Ungültiger Index: " + pos);
        }
        if (data.length - size < 1) resize();
        double[] newList = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            if (i == pos) {
                newList[i] = v;
                continue;
            }
            if (i > pos) newList[i] = data[i - 1];
            else newList[i] = data[i];
        }
        data = newList;
        size++;
    }


    public static double get(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("Ungültiger Index: " + idx);
        }
        return data[idx];
    }

    public static double remove(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("Ungültiger Index: " + idx);
        }
        double removed = data[idx];
        if (data.length - size() < 1) resize();
        double[] newList = new double[data.length];
        for (int i = 1; i < data.length; i++) {
            if (i - 1 >= idx) newList[i - 1] = data[i];
            else newList[i - 1] = data[i - 1];
        }
        data = newList;
        size--;
        return removed;
    }

    public static int size() {
        return size;
    }

    public static void clear() {
        data = new double[size];
        size = 0;
    }

    public static String print() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            result.append(data[i]).append(" ");
        }
        return result.toString().trim();
    }

    private static void resize() {
        double[] newData = new double[size * 2];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}

