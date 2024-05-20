package week6.labTask;

public class DualPivotQuickSort {

    /* Quick sort algorithm (public invocation) */
    public static <Data extends Comparable<Data>> void sort(Data[] elements) {
        // your code here
    }

    /* Knuth shuffle (performance guarantee) */
    private static <Data extends Comparable<Data>> void shuffle(Data[] elements) {
        // your code here
    }

    /* Recursive quick sort logic */
    private static <Data extends Comparable<Data>> void sort(Data[] elements, int low, int high) {
        // your code here
    }

    /* Partition an array using the dual-pivot approach and return the pivot indices */
    public static <Data extends Comparable<Data>> int[] partition(Data[] elements, int low, int high) {
        // your code here (next line is a placeholder)
        return null;
    }

    private static <Data extends Comparable<Data>> void swap(Data[] elements, int i, int j) {
        Data tmp = elements[i];
        elements[i] = elements[j];
        elements[j] = tmp;
    }
}
