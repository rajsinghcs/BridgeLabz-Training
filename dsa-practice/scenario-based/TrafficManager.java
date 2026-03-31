import java.util.LinkedList;
import java.util.Queue;

class Vehicle {
    String number;
    Vehicle next;

    Vehicle(String number) {
        this.number = number;
        this.next = null;
    }
}

class TrafficManager {

    private Vehicle head = null;
    private Queue<String> waitingQueue = new LinkedList<>();
    private final int MAX_QUEUE_SIZE = 5;

    // Vehicle enters waiting queue
    public void enqueueVehicle(String number) {
        if (waitingQueue.size() == MAX_QUEUE_SIZE) {
            System.out.println("Queue Overflow: Cannot add " + number);
            return;
        }
        waitingQueue.add(number);
        System.out.println("Vehicle " + number + " added to waiting queue");
    }

    // Vehicle enters roundabout
    public void enterRoundabout() {
        if (waitingQueue.isEmpty()) {
            System.out.println("Queue Underflow: No vehicles waiting");
            return;
        }

        String number = waitingQueue.poll();
        Vehicle newVehicle = new Vehicle(number);

        if (head == null) {
            head = newVehicle;
            newVehicle.next = head;
        } else {
            Vehicle temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newVehicle;
            newVehicle.next = head;
        }
        System.out.println("Vehicle " + number + " entered roundabout");
    }

    // Vehicle exits roundabout
    public void exitRoundabout() {
        if (head == null) {
            System.out.println("No vehicles in roundabout");
            return;
        }

        if (head.next == head) {
            System.out.println("Vehicle " + head.number + " exited roundabout");
            head = null;
            return;
        }

        Vehicle temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        System.out.println("Vehicle " + head.number + " exited roundabout");
        temp.next = head.next;
        head = head.next;
    }

    // Print current state
    public void printRoundabout() {
        if (head == null) {
            System.out.println("Roundabout is empty");
            return;
        }

        Vehicle temp = head;
        System.out.print("Roundabout: ");
        do {
            System.out.print(temp.number + " → ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(Back to Start)");
    }

    public static void main(String[] args) {
        TrafficManager tm = new TrafficManager();

        tm.enqueueVehicle("CAR-101");
        tm.enqueueVehicle("CAR-102");
        tm.enqueueVehicle("CAR-103");

        tm.enterRoundabout();
        tm.enterRoundabout();
        tm.printRoundabout();

        tm.exitRoundabout();
        tm.printRoundabout();
    }
}
