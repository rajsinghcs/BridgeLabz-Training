package collectors;

import java.util.*;
import java.util.stream.Collectors;

public class LibraryBookStatistics {

    public static void main(String[] args) {

        List<Book> books = List.of(
                new Book("Fiction", 300),
                new Book("Fiction", 250),
                new Book("Science", 450),
                new Book("Science", 500)
        );

        Map<String, IntSummaryStatistics> stats =
                books.stream()
                        .collect(Collectors.groupingBy(
                                Book::getGenre,
                                Collectors.summarizingInt(Book::getPages)
                        ));

        stats.forEach((genre, s) -> {
            System.out.println(
                    genre + " -> Total: " + s.getSum() +
                    ", Avg: " + s.getAverage() +
                    ", Max: " + s.getMax()
            );
        });
    }
}

class Book {
    private String genre;
    private int pages;

    public Book(String genre, int pages) {
        this.genre = genre;
        this.pages = pages;
    }

    public String getGenre() { return genre; }
    public int getPages() { return pages; }
}

