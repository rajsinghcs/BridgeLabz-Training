class Book {
    String title;
    String author;
    String status;   // Available / Checked Out

    Book(String title, String author, String status) {
        this.title = title;
        this.author = author;
        this.status = status;
    }
}

public class LibraryManagementSystemBookSearchCheckout {

    // Display books
    static void displayBooks(Book[] books) {
        System.out.println("\nLibrary Books:");
        for (Book book : books) {
            System.out.println(
                "Title: " + book.title +
                ", Author: " + book.author +
                ", Status: " + book.status
            );
        }
    }

    // Search book by partial title
    static void searchBook(Book[] books, String keyword) {
        boolean found = false;
        System.out.println("\nSearch Results for: \"" + keyword + "\"");

        for (Book book : books) {
            if (book.title.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(
                    "Title: " + book.title +
                    ", Author: " + book.author +
                    ", Status: " + book.status
                );
                found = true;
            }
        }

        if (!found) {
            System.out.println("No book found.");
        }
    }

    // Update book status (checkout / return)
    static void updateStatus(Book[] books, String title, String newStatus) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                book.status = newStatus;
                System.out.println("Status updated successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public static void main(String[] args) {

        // Store book data in array
        Book[] books = {
            new Book("Java Programming", "James Gosling", "Available"),
            new Book("Python Basics", "Guido van Rossum", "Available"),
            new Book("Data Structures", "Mark Allen", "Checked Out"),
            new Book("Operating Systems", "Andrew Tanenbaum", "Available")
        };

        // Display books
        displayBooks(books);

        // Search by partial title
        searchBook(books, "data");

        // Checkout a book
        updateStatus(books, "Java Programming", "Checked Out");

        // Display updated list
        displayBooks(books);
    }
}
