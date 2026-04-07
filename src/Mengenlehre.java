import java.util.*;

public class Mengenlehre {
    static void main() {
//        A = { 1, 3, 5 }
//        B = { 3, 5, 7 }
//        C = { 5, 7, 9 }

        HashSet<Integer> a = new HashSet<>(Arrays.asList(1, 3, 5));
        HashSet<Integer> b = new HashSet<>(Arrays.asList(3, 5, 7));
        HashSet<Integer> c = new HashSet<>(Arrays.asList(5, 7, 9));

        HashSet<Integer> result = getUnionHashSet(a, c);
        System.out.println(result);

        result = getDifferenceHashSet(a, c);
        System.out.println(result);

        result = getIntersectionHashSet(c, a);
        System.out.println(result);

        result = getUnionHashSet(a, getIntersectionHashSet(b, c));
        System.out.println(result);
    }

    public static HashSet<Integer> getUnionHashSet(HashSet<Integer> x, HashSet<Integer> y) {
        HashSet<Integer> unique = new HashSet<>();
        unique.addAll(x);
        unique.addAll(y);

        return unique;
    }

    public static HashSet<Integer> getDifferenceHashSet(HashSet<Integer> x, HashSet<Integer> y) {
        HashSet<Integer> result = new HashSet<>(x);
        result.removeAll(y);
        return result;
    }

    public static HashSet<Integer> getIntersectionHashSet(HashSet<Integer> x, HashSet<Integer> y) {
        HashSet<Integer> result = new HashSet<>(x);
        result.retainAll(y);
        return result;
    }
}