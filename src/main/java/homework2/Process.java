package homework2;

public class Process implements Comparable<Process> {
    // These are private member variables, for the process attributes
    private String processName;
    private int priority;
    private int burstTime;
    private int arrivalTime;

    // Down below is the Constructor to initialize a Process object
    public Process(String processName, int priority, int burstTime, int arrivalTime) {
        this.processName = processName;
        this.priority = priority;
        this.burstTime = burstTime;
        this.arrivalTime = arrivalTime;
    }

    public String getProcessName() {
        return processName;
    }

    public int getPriority() {
        return priority;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    // Next, after the declaration of getters and setters, Override the compareTo method to define the natural ordering of Process objects:
    @Override
    public int compareTo(Process other) {
        // Compare based on priority first;
        if (this.priority == other.priority) {
            // if priorities are equal, compare based on arrival time
            return Integer.compare(this.arrivalTime, other.arrivalTime);
        }
        // Otherwise, compare based on priority
        return Integer.compare(this.priority, other.priority);
    }
}

/*This implementation ensures that Process objects can be stored and will be
ordered primarily by priority and secondarily by arrivalTime if priorities are equal.
 */
