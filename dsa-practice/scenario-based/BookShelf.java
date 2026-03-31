import java.util.*;

class BookShelf {

    private HashMap<String, LinkedList<String>> catalog = new HashMap<>();
    private HashSet<String> uniqueBooks = new HashSet<>();

    // Add book
    public void addBook(String genre, String book) {
        if (uniqueBooks.contains(book)) {
            System.out.println("Duplicate book not allowed: " + book);
            return;
        }

        catalog.putIfAbsent(genre, new LinkedList<>());
        catalog.get(genre).add(book);
        uniqueBooks.add(book);

        System.out.println("Book added: " + book);
    }

    // Borrow book
    public void borrowBook(String genre, String book) {
        if (!catalog.containsKey(genre) || !catalog.get(genre).remove(book)) {
            System.out.println("Book not available");
            return;
        }
        uniqueBooks.remove(book);
        System.out.println("Book borrowed: " + book);
    }

    // Return book
    public void returnBook(String genre, String book) {
        addBook(genre, book);
    }

    // Display catalog
    public void displayCatalog() {
        System.out.println("Library Catalog:");
        for (String genre : catalog.keySet()) {
            System.out.println(genre + " -> " + catalog.get(genre));
        }
    }

    public static void main(String[] args) {

        BookShelf library = new BookShelf();

        library.addBook("Fiction", "1984");
        library.addBook("Fiction", "Animal Farm");
        library.addBook("Science", "A Brief History of Time");

        library.borrowBook("Fiction", "1984");
        library.displayCatalog();
    }
}
