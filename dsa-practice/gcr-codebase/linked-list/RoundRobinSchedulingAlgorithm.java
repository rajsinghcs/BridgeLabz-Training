import java.util.*;

public class RoundRobinScheduling {

    static Node head = null;
    static Node tail = null;

    static int timeQuantum = 2;
    static int currentTime = 0;
    static int totalProcesses = 0;
    static int totalWaitingTime = 0;
    static int totalTurnAroundTime = 0;

    // Node of Circular Linked List
    static class Node {
        int pid;
        int burstTime;
        int remainingTime;
        int priority;
        int arrivalTime;
        Node next;

        Node(int pid, int burstTime, int priority) {
            this.pid = pid;
            this.burstTime = burstTime;
            this.remainingTime = burstTime;
            this.priority = priority;
            this.arrivalTime = 0;
            this.next = null;
        }
    }

    // Add process at end
    public static void addProcess(int pid, int burstTime, int priority) {
        Node newNode = new Node(pid, burstTime, priority);
        totalProcesses++;

        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
            return;
        }

        tail.next = newNode;
        newNode.next = head;
        tail = newNode;
    }

    // Remove completed process
    public static void removeProcess(Node prev, Node curr) {
        if (curr == head && curr == tail) {
            head = tail = null;
            return;
        }

        if (curr == head) {
            head = head.next;
            tail.next = head;
        } else if (curr == tail) {
            tail = prev;
            tail.next = head;
        } else {
            prev.next = curr.next;
        }
    }

    // Display process list
    public static void displayProcesses() {
        if (head == null) {
            System.out.println("No processes left.");
            return;
        }

        Node temp = head;
        do {
            System.out.println(
                    "PID: " + temp.pid +
                    ", Remaining Time: " + temp.remainingTime
            );
            temp = temp.next;
        } while (temp != head);
    }

    // Simulate Round Robin Scheduling
    public static void roundRobinScheduling() {
        if (head == null) return;

        Node curr = head;
        Node prev = tail;

        System.out.println("\n--- Round Robin Scheduling ---");

        while (head != null) {

            if (curr.remainingTime > 0) {

                int execTime = Math.min(timeQuantum, curr.remainingTime);
                curr.remainingTime -= execTime;
                currentTime += execTime;

                System.out.println(
                        "Executing PID " + curr.pid +
                        " for " + execTime + " units"
                );

                if (curr.remainingTime == 0) {
                    int turnAroundTime = currentTime - curr.arrivalTime;
                    int waitingTime = turnAroundTime - curr.burstTime;

                    totalTurnAroundTime += turnAroundTime;
                    totalWaitingTime += waitingTime;

                    System.out.println("Process " + curr.pid + " completed.");
                    removeProcess(prev, curr);
                    curr = prev.next;
                } else {
                    prev = curr;
                    curr = curr.next;
                }

                System.out.println("\nQueue after round:");
                displayProcesses();
            }
        }
    }

    // Display averages
    public static void displayAverages() {
        System.out.println("\n--- Average Times ---");
        System.out.println("Average Waiting Time: " +
                (double) totalWaitingTime / totalProcesses);
        System.out.println("Average Turn Around Time: " +
                (double) totalTurnAroundTime / totalProcesses);
    }

    // Main method
    public static void main(String[] args) {

        addProcess(1, 5, 1);
        addProcess(2, 4, 2);
        addProcess(3, 6, 1);
        addProcess(4, 3, 3);

        System.out.println("Initial Process Queue:");
        displayProcesses();

        roundRobinScheduling();
        displayAverages();
    }
}
