import java.util.*;

public class TaskScheduler {

    static Node head = null;
    static Node current = null;

    // Node of Circular Linked List
    static class Node {
        int taskId;
        String taskName;
        int priority;
        String dueDate;
        Node next;

        Node(int taskId, String taskName, int priority, String dueDate) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.priority = priority;
            this.dueDate = dueDate;
            this.next = null;
        }
    }

    // Add task at end
    public static void addTask(int id, String name, int priority, String dueDate) {
        Node newNode = new Node(id, name, priority, dueDate);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
            return;
        }

        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;
    }

    // Add task at beginning
    public static void addTaskAtBeginning(int id, String name, int priority, String dueDate) {
        Node newNode = new Node(id, name, priority, dueDate);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
            return;
        }

        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        newNode.next = head;
        temp.next = newNode;
        head = newNode;
    }

    // Add task at specific position
    public static void addTaskAtPosition(int pos, int id, String name, int priority, String dueDate) {
        if (pos <= 1 || head == null) {
            addTaskAtBeginning(id, name, priority, dueDate);
            return;
        }

        Node temp = head;
        for (int i = 1; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        Node newNode = new Node(id, name, priority, dueDate);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Remove task by ID
    public static void removeTask(int taskId) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Node temp = head;
        Node prev = null;

        do {
            if (temp.taskId == taskId) {

                if (temp == head) {
                    Node last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = temp.next;
                }

                System.out.println("Task removed: " + taskId);
                return;
            }

            prev = temp;
            temp = temp.next;

        } while (temp != head);

        System.out.println("Task not found.");
    }

    // View current task & move to next
    public static void viewNextTask() {
        if (current == null) {
            System.out.println("No tasks available.");
            return;
        }

        printTask(current);
        current = current.next;
    }

    // Display all tasks
    public static void displayTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Node temp = head;
        do {
            printTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // Search by priority
    public static void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Node temp = head;
        boolean found = false;

        do {
            if (temp.priority == priority) {
                printTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority " + priority);
        }
    }

    // Helper method
    private static void printTask(Node t) {
        System.out.println(
                "Task ID: " + t.taskId +
                ", Name: " + t.taskName +
                ", Priority: " + t.priority +
                ", Due Date: " + t.dueDate
        );
    }

    // Main method
    public static void main(String[] args) {

        addTask(1, "Submit Assignment", 1, "10-10-2025");
        addTask(2, "Prepare Presentation", 2, "12-10-2025");
        addTask(3, "Project Review", 1, "15-10-2025");

        addTaskAtBeginning(4, "Urgent Meeting", 1, "08-10-2025");
        addTaskAtPosition(3, 5, "Code Testing", 2, "11-10-2025");

        System.out.println("\nAll Tasks:");
        displayTasks();

        System.out.println("\nView Current & Next Task:");
        viewNextTask();
        viewNextTask();

        System.out.println("\nSearch by Priority:");
        searchByPriority(1);

        System.out.println("\nRemove Task:");
        removeTask(2);

        System.out.println("\nFinal Task List:");
        displayTasks();
    }
}
