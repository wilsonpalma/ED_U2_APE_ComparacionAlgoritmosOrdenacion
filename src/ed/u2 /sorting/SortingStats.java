package ed.u2.sorting;

/**
 * Contadores y tiempo de una corrida de ordenación.
 */
public final class SortingStats {
    public long comparisons = 0;
    public long swaps = 0;
    public long shifts = 0;     // usado por InsertionSort (desplazamientos)
    public long nanoTime = 0;   // medida en nanosegundos
    public int n = 0;           // tamaño del array

    public void reset() {
        comparisons = swaps = shifts = nanoTime = 0;
        n = 0;
    }

    @Override
    public String toString() {
        return String.format("n=%d, comparisons=%d, swaps=%d, shifts=%d, time(ns)=%d",
                n, comparisons, swaps, shifts, nanoTime);
    }
}
