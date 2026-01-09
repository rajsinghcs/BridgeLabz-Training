import java.util.*;

public class MovieManagementSystem {

    static Node head = null;
    static Node tail = null;
    static Scanner sc = new Scanner(System.in);

    // Node of Doubly Linked List
    static class Node {
        String title;
        String director;
        int year;
        double rating;
        Node next;
        Node prev;

        Node(String title, String director, int year, double rating) {
            this.title = title;
            this.director = director;
            this.year = year;
            this.rating = rating;
        }
    }

    // Add movie at end
    public static void addMovie(String title, String director, int year, double rating) {
        Node newNode = new Node(title, director, year, rating);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Remove movie by title
    public static void removeMovie(String title) {
        Node temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {

                if (temp == head) {
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } 
                else if (temp == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } 
                else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }

                System.out.println("Movie removed: " + title);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    // Search by Director
    public static void searchByDirector(String director) {
        Node temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                printMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No movies found for director.");
        }
    }

    // Search by Rating
    public static void searchByRating(double rating) {
        Node temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.rating == rating) {
                printMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No movies found with rating.");
        }
    }

    // Display forward
    public static void displayForward() {
        Node temp = head;

        while (temp != null) {
            printMovie(temp);
            temp = temp.next;
        }
    }

    // Display reverse
    public static void displayReverse() {
        Node temp = tail;

        while (temp != null) {
            printMovie(temp);
            temp = temp.prev;
        }
    }

    // Update rating by title
    public static void updateRating(String title, double newRating) {
        Node temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated for " + title);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    // Helper method
    private static void printMovie(Node m) {
        System.out.println(
                "Title: " + m.title +
                ", Director: " + m.director +
                ", Year: " + m.year +
                ", Rating: " + m.rating
        );
    }

    // Main method 
    public static void main(String[] args) {

        addMovie("3 Idiots", "Rajkumar Hirani", 2009, 8.4);
        addMovie("Dangal", "Nitesh Tiwari", 2016, 8.3);
        addMovie("Baahubali: The Beginning", "S. S. Rajamouli", 2015, 8.0);
        addMovie("Baahubali: The Conclusion", "S. S. Rajamouli", 2017, 8.2);
        addMovie("KGF: Chapter 1", "Prashanth Neel", 2018, 8.2);
        addMovie("RRR", "S. S. Rajamouli", 2022, 8.8);

        System.out.println("\nAll Movies (Forward)");
        displayForward();

        System.out.println("\nAll Movies (Reverse)");
        displayReverse();

        System.out.println("\nSearch by Director");
        searchByDirector("S. S. Rajamouli");

        System.out.println("\nUpdate Rating");
        updateRating("KGF: Chapter 1", 8.5);

        System.out.println("\nRemove Movie");
        removeMovie("Dangal");

        System.out.println("\nFinal Movie List");
        displayForward();
    }
}
