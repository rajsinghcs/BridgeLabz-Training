import java.util.*;

public class LibraryManagementSystem {

    static Node head = null;
    static Node tail = null;

    // Node of Doubly Linked List
    static class Node {
        String title;
        String author;
        String genre;
        int bookId;
        boolean available;
        Node next;
        Node prev;

        Node(String title, String author, String genre, int bookId, boolean available) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.bookId = bookId;
            this.available = available;
        }
    }

    // Add book at end
    public static void addBook(String title, String author, String genre, int id, boolean available) {
        Node newNode = new Node(title, author, genre, id, available);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Add book at beginning
    public static void addAtBeginning(String title, String author, String genre, int id, boolean available) {
        Node newNode = new Node(title, author, genre, id, available);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Add book at specific position
    public static void addAtPosition(int pos, String title, String author, String genre, int id, boolean available) {
        if (pos <= 1 || head == null) {
            addAtBeginning(title, author, genre, id, available);
            return;
        }

        Node temp = head;
        for (int i = 1; i < pos - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        Node newNode = new Node(title, author, genre, id, available);
        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        } else {
            tail = newNode;
        }

        temp.next = newNode;
    }

    // Remove book by ID
    public static void removeBook(int id) {
        Node temp = head;

        while (temp != null) {
            if (temp.bookId == id) {

                if (temp == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } 
                else if (temp == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } 
                else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }

                System.out.println("Book removed: " + id);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    // Search by title
    public static void searchByTitle(String title) {
        Node temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                printBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("Book not found.");
    }

    // Search by author
    public static void searchByAuthor(String author) {
        Node temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                printBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("Book not found.");
    }

    // Update availability status
    public static void updateAvailability(int id, boolean status) {
        Node temp = head;

        while (temp != null) {
            if (temp.bookId == id) {
                temp.available = status;
                System.out.println("Availability updated for Book ID: " + id);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    // Display forward
    public static void displayForward() {
        Node temp = head;

        while (temp != null) {
            printBook(temp);
            temp = temp.next;
        }
    }

    // Display reverse
    public static void displayReverse() {
        Node temp = tail;

        while (temp != null) {
            printBook(temp);
            temp = temp.prev;
        }
    }

    // Count total books
    public static void countBooks() {
        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println("Total Books in Library: " + count);
    }

    // Helper method
    private static void printBook(Node b) {
        System.out.println(
                "ID: " + b.bookId +
                ", Title: " + b.title +
                ", Author: " + b.author +
                ", Genre: " + b.genre +
                ", Available: " + (b.available ? "Yes" : "No")
        );
    }

    // Main method 
    public static void main(String[] args) {

        addBook("The Alchemist", "Paulo Coelho", "Fiction", 101, true);
        addBook("Wings of Fire", "A. P. J. Abdul Kalam", "Biography", 102, true);
        addBook("Clean Code", "Robert C. Martin", "Programming", 103, false);

        addAtBeginning("Ikigai", "Hector Garcia", "Self Help", 104, true);
        addAtPosition(3, "Atomic Habits", "James Clear", "Self Help", 105, true);

        System.out.println("\nAll Books (Forward)");
        displayForward();

        System.out.println("\nAll Books (Reverse)");
        displayReverse();

        System.out.println("\nSearch by Title");
        searchByTitle("Atomic Habits");

        System.out.println("\nSearch by Author");
        searchByAuthor("Paulo Coelho");

        System.out.println("\nUpdate Availability");
        updateAvailability(103, true);

        System.out.println("\nCount Books");
        countBooks();
    }
}
