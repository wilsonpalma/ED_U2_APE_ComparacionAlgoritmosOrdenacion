package ed.u2.sorting;

import java.util.Arrays;

public final class SortingUtils {
    private SortingUtils() {}

    public static int[] copyArray(int[] a) {
        return a == null ? null : a.clone();
    }

    public static void printArray(int[] a) {
        if (a == null) { System.out.println("null"); return; }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            if (i > 0) sb.append(" ");
            sb.append(a[i]);
        }
        System.out.println(sb.toString());
    }

    // median from long array (assumes arr not null)
    public static long median(long[] arr) {
        if (arr == null || arr.length == 0) return 0;
        long[] copy = arr.clone();
        Arrays.sort(copy);
        int mid = copy.length / 2;
        if (copy.length % 2 == 1) return copy[mid];
        return (copy[mid - 1] + copy[mid]) / 2;
    }
}
