package week5.labTask;

public class TimSort {

    public static <Data extends Comparable<Data>> void sort(Data[] elements, int threshold) {
        Data[] aux = (Data[]) new Comparable[elements.length];
        int runLength = calculateRunLength(elements.length, threshold);

        for (int i = 0; i < elements.length; i += runLength) {
            insertionSort(elements, i, Math.min(i + runLength, elements.length));
        }

        for (int size = runLength; size < elements.length; size *= 2) {
            for (int low = 0; low < elements.length; low += 2 * size) {
                int mid = Math.min(low + size - 1, elements.length - 1);
                int high = Math.min(low + 2 * size - 1, elements.length - 1);
                merge(elements, aux, low, mid, high);
            }
        }
    }

    public static <Data extends Comparable<Data>> void insertionSort(Data[] elements, int low, int high) {
        for (int i = low + 1; i < high; i++) {
            Data key = elements[i];
            int j = i - 1;

            while (j >= low && elements[j].compareTo(key) > 0) {
                elements[j + 1] = elements[j];
                j--;
            }
            elements[j + 1] = key;
        }
    }

    public static <Data extends Comparable<Data>> void merge(Data[] elements, Data[] aux, int low, int mid, int high) {
        for (int k = low; k <= high; k++) {
            aux[k] = elements[k];
        }

        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                elements[k] = aux[j++];
            } else if (j > high) {
                elements[k] = aux[i++];
            } else if (aux[j].compareTo(aux[i]) < 0) {
                elements[k] = aux[j++];
            } else {
                elements[k] = aux[i++];
            }
        }
    }

    public static int calculateRunLength(int initialLength, int threshold) {
        int r = 0;
        while (initialLength >= threshold) {
            initialLength >>= 1;
            r |= initialLength;
        }
        return initialLength + r;
    }
}

