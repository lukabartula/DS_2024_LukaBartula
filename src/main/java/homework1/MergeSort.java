package homework1;

public class MergeSort {

    public static void sort(Entry[] entries) {
        // creating an auxiliary array used for merging
        Entry[] aux = new Entry[entries.length];
        sort(entries, aux, 0, entries.length - 1);
    }

    //recursive method to sort the entries
    private static void sort(Entry[] entries, Entry[] aux, int low, int high) {
        // best case for recursion, if subarray has one or 0 elements, it is already sorted
        if (high <= low) {
            return;
        }

        int mid = low + (high - low) / 2;
        //recursively sorting the left half of the subarray
        sort(entries, aux, low, mid);
        //recursively sorts the right half ot the subarray
        sort(entries, aux, mid + 1, high);
        //merging sorted halves
        merge(entries, aux, low, mid, high);
    }

    private static void merge(Entry[] entries, Entry[] aux, int low, int mid, int high) {
        //copying elements from current subarray from entries to aux
        for (int k = low; k <= high; k++) {
            aux[k] = entries[k];
        }

        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                entries[k] = aux[j++];
            } else if (j > high) {
                entries[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                entries[k] = aux[j++];
            } else {
                entries[k] = aux[i++];
            }
        }
    }

    public static boolean less(Entry v, Entry w) {
        return v.compareTo(w) < 0;
    }
}