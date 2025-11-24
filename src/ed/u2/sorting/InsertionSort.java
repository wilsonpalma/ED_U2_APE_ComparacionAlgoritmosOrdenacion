package ed.u2.sorting;

/**
 * Insertion sort instrumentado.
 * Cuenta:
 * - comparisons: cada vez que se evalúa a[j] > key en el bucle.
 * - shifts: cada movimiento a[j+1] = a[j] que desplaza elementos hacia la derecha.
 * Insertion es estable.
 */
public final class InsertionSort {

    public void sort(int[] a) {
        sort(a, false);
    }

    public void sort(int[] a, boolean trace) {
        if (a == null || a.length < 2) return;
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int key = a[i];
            int j = i - 1;
            if (trace) System.out.printf("Insert index %d, key=%d\n", i, key);
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j]; // shift
                j--;
                if (trace) System.out.printf(" Shift pos %d -> %d\n", j+1, j+2);
            }
            a[j + 1] = key;
            if (trace) System.out.println("After insert:");
        }
    }

    // Instrumented
    public void sort(int[] a, SortingStats stats) {
        if (stats == null) throw new IllegalArgumentException("stats == null");
        stats.reset();
        if (a == null) return;
        int n = a.length;
        stats.n = n;
        if (n < 2) return;

        long t0 = System.nanoTime();

        for (int i = 1; i < n; i++) {
            int key = a[i];
            int j = i - 1;
            // iterate and count comparisons and shifts.
            while (j >= 0) {
                stats.comparisons++;
                if (a[j] > key) {
                    a[j + 1] = a[j];
                    stats.shifts++;
                    j--;
                } else {
                    break;
                }
            }
            a[j + 1] = key;
        }

        long t1 = System.nanoTime();
        stats.nanoTime = t1 - t0;
    }
}
