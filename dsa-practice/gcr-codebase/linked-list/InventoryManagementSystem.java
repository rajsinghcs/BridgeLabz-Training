import java.util.*;

public class InventoryManagementSystem {

    static Node head = null;

    // Node of Singly Linked List
    static class Node {
        int itemId;
        String itemName;
        int quantity;
        double price;
        Node next;

        Node(int itemId, String itemName, int quantity, double price) {
            this.itemId = itemId;
            this.itemName = itemName;
            this.quantity = quantity;
            this.price = price;
            this.next = null;
        }
    }

    // Add item at end
    public static void addItem(int id, String name, int qty, double price) {
        Node newNode = new Node(id, name, qty, price);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Add item at beginning
    public static void addAtBeginning(int id, String name, int qty, double price) {
        Node newNode = new Node(id, name, qty, price);
        newNode.next = head;
        head = newNode;
    }

    // Add item at specific position
    public static void addAtPosition(int pos, int id, String name, int qty, double price) {
        if (pos <= 1 || head == null) {
            addAtBeginning(id, name, qty, price);
            return;
        }

        Node temp = head;
        for (int i = 1; i < pos - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        Node newNode = new Node(id, name, qty, price);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Remove item by ID
    public static void removeItem(int id) {
        if (head == null) return;

        if (head.itemId == id) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            if (temp.next.itemId == id) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }

    // Update quantity by ID
    public static void updateQuantity(int id, int newQty) {
        Node temp = head;

        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                return;
            }
            temp = temp.next;
        }
    }

    // Search by Item ID
    public static void searchById(int id) {
        Node temp = head;

        while (temp != null) {
            if (temp.itemId == id) {
                printItem(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    // Search by Item Name
    public static void searchByName(String name) {
        Node temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
                printItem(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("Item not found.");
    }

    // Calculate total inventory value
    public static void totalInventoryValue() {
        Node temp = head;
        double total = 0;

        while (temp != null) {
            total += temp.quantity * temp.price;
            temp = temp.next;
        }

        System.out.println("Total Inventory Value: ₹" + total);
    }

    // Sort by Item Name
    public static void sortByName(boolean ascending) {
        for (Node i = head; i != null; i = i.next) {
            for (Node j = i.next; j != null; j = j.next) {

                if ((ascending && i.itemName.compareToIgnoreCase(j.itemName) > 0) ||
                    (!ascending && i.itemName.compareToIgnoreCase(j.itemName) < 0)) {

                    swapData(i, j);
                }
            }
        }
    }

    // Sort by Price
    public static void sortByPrice(boolean ascending) {
        for (Node i = head; i != null; i = i.next) {
            for (Node j = i.next; j != null; j = j.next) {

                if ((ascending && i.price > j.price) ||
                    (!ascending && i.price < j.price)) {

                    swapData(i, j);
                }
            }
        }
    }

    // Swap node data
    private static void swapData(Node a, Node b) {
        int id = a.itemId;
        String name = a.itemName;
        int qty = a.quantity;
        double price = a.price;

        a.itemId = b.itemId;
        a.itemName = b.itemName;
        a.quantity = b.quantity;
        a.price = b.price;

        b.itemId = id;
        b.itemName = name;
        b.quantity = qty;
        b.price = price;
    }

    // Display inventory
    public static void displayItems() {
        Node temp = head;
        while (temp != null) {
            printItem(temp);
            temp = temp.next;
        }
    }

    // Helper method
    private static void printItem(Node i) {
        System.out.println(
                "ID: " + i.itemId +
                ", Name: " + i.itemName +
                ", Qty: " + i.quantity +
                ", Price: ₹" + i.price
        );
    }

    // Main method (No menu system)
    public static void main(String[] args) {

        addItem(101, "Laptop", 5, 60000);
        addItem(102, "Mouse", 20, 500);
        addItem(103, "Keyboard", 15, 1500);

        addAtBeginning(104, "Monitor", 10, 12000);
        addAtPosition(3, 105, "Printer", 4, 18000);

        System.out.println("\nAll Items:");
        displayItems();

        System.out.println("\nSearch by ID:");
        searchById(102);

        System.out.println("\nUpdate Quantity:");
        updateQuantity(101, 7);

        System.out.println("\nTotal Inventory Value:");
        totalInventoryValue();

        System.out.println("\nSort by Name (Ascending):");
        sortByName(true);
        displayItems();

        System.out.println("\nSort by Price (Descending):");
        sortByPrice(false);
        displayItems();
    }
}
