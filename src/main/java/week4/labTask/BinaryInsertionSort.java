package week4.labTask;

public class BinaryInsertionSort {

    public static <Data extends Comparable<Data>> void sort(LinkedList<Data> ll) {
        for (int i = 1; i < ll.count(); i++) {
            int j = i - 1;
            Data target = ll.get(i);
            int position = findInsertionPoint(ll, j, target);
            ll.add(position, target);
            ll.remove(i + 1);
        }
    }

    public static <Data extends Comparable<Data>> int findInsertionPoint(LinkedList<Data> ll, int high, Data key) {
        int middle;
        int low = 0;
        while (low <= high) {
            middle = low + (high - low) / 2;
            if (key.compareTo(ll.get(middle)) < 0) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return low;
    }
}
