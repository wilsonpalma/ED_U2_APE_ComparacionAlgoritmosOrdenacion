package ed.u2.sorting;

/**
 * Bubble sort instrumentado.
 * - sort(int[] a, SortingStats stats): actualiza stats (comparisons, swaps, nanoTime).
 * - sort(int[] a) / sort(a, boolean trace): versiones no-instrumentadas/trace.
 */
public final class BubbleSort {

    // Simple facade - in-place
    public void sort(int[] a) {
        sort(a, false);
    }

    public void sort(int[] a, boolean trace) {
        if (a == null || a.length < 2) return;
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            if (trace) System.out.println("Pass " + i);
            for (int j = 0; j < n - 1 - i; j++) {
                if (trace) System.out.printf("Compare a[%d]=%d and a[%d]=%d\n", j, a[j], j+1, a[j+1]);
                if (a[j] > a[j+1]) {
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    swapped = true;
                    if (trace) System.out.printf(" Swap pos %d <-> %d\n", j, j+1);
                }
            }
            if (!swapped) {
                if (trace) System.out.println("No swaps in pass — early exit");
                break;
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
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                stats.comparisons++;
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    stats.swaps++;
                    swapped = true;
                }
            }
            if (!swapped) break; // corte temprano
        }

        long t1 = System.nanoTime();
        stats.nanoTime = t1 - t0;
    }
}
