package ed.u2.sorting;

/**
 * Selection sort instrumentado.
 * Nota: por naturaleza Selection no es estable.
 */
public final class SelectionSort {

    public void sort(int[] a) {
        sort(a, false);
    }

    public void sort(int[] a, boolean trace) {
        if (a == null || a.length < 2) return;
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            if (trace) System.out.println("Pass " + i);
            for (int j = i + 1; j < n; j++) {
                if (trace) System.out.printf("Compare a[%d]=%d and a[%d]=%d\n", j, a[j], minIdx, a[minIdx]);
                if (a[j] < a[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                int tmp = a[i];
                a[i] = a[minIdx];
                a[minIdx] = tmp;
                if (trace) System.out.printf("Swap pos %d <-> %d\n", i, minIdx);
            }
        }
    }

    // Instrumented version
    public void sort(int[] a, SortingStats stats) {
        if (stats == null) throw new IllegalArgumentException("stats == null");
        stats.reset();
        if (a == null) return;
        int n = a.length;
        stats.n = n;
        if (n < 2) return;

        long t0 = System.nanoTime();

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                stats.comparisons++;
                if (a[j] < a[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                int tmp = a[i];
                a[i] = a[minIdx];
                a[minIdx] = tmp;
                stats.swaps++;
            }
        }

        long t1 = System.nanoTime();
        stats.nanoTime = t1 - t0;
    }
}
