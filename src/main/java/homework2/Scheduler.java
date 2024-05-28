package homework2;

import java.util.ArrayList;

public class Scheduler {

    public static void scheduleAndRun(ArrayList<Process> processes) {
        ProcessQueue processQueue = new ProcessQueue();
        int currentTime = 0;
        boolean processesRemain = true;

        while (processesRemain || !processQueue.isEmpty()) {
            // Add newly arrived processes to the queue
            processesRemain = false;
            for (Process process : processes) {
                if (process.getArrivalTime() == currentTime) {
                    processQueue.addProcess(process);
                }
                if (process.getArrivalTime() > currentTime) {
                    processesRemain = true;
                }
            }

            Process currentProcess = processQueue.peekNextProcess();
            if (currentProcess != null) {
                // Simulate running process for 1 time unit
                System.out.println("t: " + currentTime + "\t| " + currentProcess.getProcessName());

                // Decrement the burst time of the current process
                currentProcess.setBurstTime(currentProcess.getBurstTime() - 1);

                // If the current process has finished, remove it from the queue
                if (currentProcess.getBurstTime() == 0) {
                    processQueue.runNextProcess();
                }
            } else {
                System.out.println("t: " + currentTime + "\t| no  process");
            }
            currentTime++;
        }
        System.out.println("Total time: " + currentTime);
    }

    public static void main(String[] args) {
        // you can use the main method for testing
        // examples 1-5 from document
        // example 1
        ArrayList<Process> processes1 = new ArrayList<>();
        processes1.add(new Process("P1", 1, 4, 0));
        processes1.add(new Process("P2", 2, 3, 0));
        processes1.add(new Process("P3", 1, 7, 6));
        processes1.add(new Process("P4", 3, 4, 11));
        processes1.add(new Process("P5", 2, 2, 12));
        //example 2
        ArrayList<Process> processes2 = new ArrayList<>();
        processes2.add(new Process("P1", 5, 4, 0));
        processes2.add(new Process("P2", 4, 3, 1));
        processes2.add(new Process("P3", 3, 1, 2));
        processes2.add(new Process("P4", 2, 5, 3));
        processes2.add(new Process("P5", 2, 2, 4));
        //example 3
        ArrayList<Process> processes3 = new ArrayList<>();
        processes3.add(new Process("P1", 3, 3, 0));
        processes3.add(new Process("P2", 2, 4, 1));
        processes3.add(new Process("P3", 4, 6, 2));
        processes3.add(new Process("P4", 6, 4, 3));
        processes3.add(new Process("P5", 10, 2, 5));
        //example 4
        ArrayList<Process> processes4 = new ArrayList<>();
        processes4.add(new Process("P1", 2, 1, 0));
        processes4.add(new Process("P2", 6, 7, 1));
        processes4.add(new Process("P3", 3, 3, 2));
        processes4.add(new Process("P4", 5, 6, 3));
        processes4.add(new Process("P5", 4, 5, 4));
        processes4.add(new Process("P6", 10, 15, 5));
        processes4.add(new Process("P7", 9, 8, 15));
        //example 5
        ArrayList<Process> processes5 = new ArrayList<>();
        processes5.add(new Process("P1", 2, 4, 1));
        processes5.add(new Process("P2", 1, 1, 2));
        processes5.add(new Process("P3", 3, 2, 8));

        // Running the scheduler for each example
        scheduleAndRun(processes1);
        scheduleAndRun(processes2);
        scheduleAndRun(processes3);
        scheduleAndRun(processes4);
        scheduleAndRun(processes5);
    }
}

