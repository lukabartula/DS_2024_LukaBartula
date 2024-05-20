package homework1;

public class BinarySearch {
    public static int[] search(Entry[] entries, String searchableName) {
        int left = 0;
        int right = entries.length - 1;
        int firstOccurrence = -1;
        int lastOccurrence = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (entries[mid].name.compareTo(searchableName) == 0) {
                // When a match is found, check for both first and last occurrences
                firstOccurrence = mid;
                lastOccurrence = mid;

                // Extend left to find the first occurrence
                int tempLeft = mid;
                while (tempLeft > left && entries[tempLeft - 1].name.compareTo(searchableName) == 0) {
                    firstOccurrence = --tempLeft;
                }

                // Extend right to find the last occurrence
                int tempRight = mid;
                while (tempRight < right && entries[tempRight + 1].name.compareTo(searchableName) == 0) {
                    lastOccurrence = ++tempRight;
                }

                break;
            } else if (entries[mid].name.compareTo(searchableName) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (firstOccurrence == -1) {
            return new int[]{};
        }

        return new int[]{firstOccurrence, lastOccurrence};
    }
}