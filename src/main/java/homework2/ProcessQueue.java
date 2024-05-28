package homework2;

/*
The following task involves creating a ProcessQueue class which functions as a
priority queue for the Process objects.
 */
public class ProcessQueue {
    public Process[] pq = new Process[2];
    public int length = 0;

    // Adding new process into the priority queue
    public void addProcess(Process process) {
        //Here we resize the array if needed
        if (pq.length == length + 1) {
            resize(2 * pq.length);
        }
        //Now we are adding the new process and adjusting the heap
        pq[++length] = process;
        swim(length);
    }

    // Return and remove the next Process that should be run
    public Process runNextProcess() {
        if (length == 0) {
            return null;
        }
        // Retrieve the process with the highest priority which is at the root of the heap
        Process min = pq[1];
        // Swap the root with the last element and reduce the size of the heap
        swap(1, length--);
        sink(1);
        pq[length + 1] = null; // Avoid loitering (let the garbage collector do its job)
        return min;
    }

    /* Return the next Process that should be run (but do not delete it) */
    public Process peekNextProcess() {
        if (length == 0) {
            return null;
        }
        return pq[1];
        //So with that, it returns the process with the highest priority.
    }

    /* Implement any other helper methods, if you need them. */
    /*The following methods that are implemented below are some helper
    methods I figured could work well and be useful for a minimum binary heap, considering
    everything we covered during labs.
    */

    /*Creates a new array with the specified capacity and copies the existing elements to the new array.
    The reason I used this helper method is so when the array is full, it doubles its
    capacity to accommodate more processes.*/
    public void resize(int capacity) {
        Process[] copy = new Process[capacity];
        for (int i = 1; i <= length; i++) {
            copy[i] = pq[i];
        }
        pq = copy;
    }

    /* Here we will check if the priority queue is empty, of course this is crucial so
    we can determine whether there are any processes left to run
     */
    public boolean isEmpty() {
        return length == 0;
    }

    // Now we use swim up element k to restore the heap order.
    /*When a new process is added, it might violate the heap property,
    so it needs to "swim" up to its correct position in the heap.
     */
    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            swap(k, k / 2);
            k = k / 2;
        }
    }
    /*And here the opposite process takes place, we restore the heap order by sinking the element
     down, element at index k
     */
    private void sink(int k) {
        while (2 * k <= length) {
            int j = 2 * k;
            if (j < length && greater(j, j + 1)) {
                j++;
            }
            if (!greater(k, j)) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    //Compares two elements in the priority queue, to see if the element at index A is greater than the element at index B.
    //To maintain the heap property, we need to know if a parent process has a lower priority than its children
    private boolean greater(int a, int b) {
        return pq[a].compareTo(pq[b]) > 0;
    }

    //Swap two elements in the array
    private void swap(int a, int b) {
        Process temp = pq[a];
        pq[a] = pq[b];
        pq[b] = temp;
    }
}

