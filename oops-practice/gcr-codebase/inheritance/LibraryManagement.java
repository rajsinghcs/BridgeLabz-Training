class Book {
    String title;
    int publicationYear;

    Book(String title, int year) {
        this.title = title;
        this.publicationYear = year;
    }
}

class Author extends Book {
    String name, bio;
    Author(String title, int year, String name, String bio) {
        super(title, year);
        this.name = name;
        this.bio = bio;
    }

    void displayInfo() {
        System.out.println("Title: " + title + ", Year: " + publicationYear);
        System.out.println("Author: " + name + " - " + bio);
    }
}

class LibraryManagement {
    public static void main(String[] args) {
        Author a = new Author("Harry Potter", 1997, "J.K. Rowling", "British author, best known for Harry Potter");
        a.displayInfo();
    }
}
