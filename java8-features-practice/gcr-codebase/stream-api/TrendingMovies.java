package streamapi;
import java.util.*;
class Movie {
    String name;
    double rating;
    int year;

    Movie(String name, double rating, int year) {
        this.name = name;
        this.rating = rating;
        this.year = year;
    }

    public String toString() {
        return name + " " + rating + " " + year;
    }
}
public class TrendingMovies {
    public static void main(String[] args) {

        List<Movie> movies = List.of(
            new Movie("Kalki", 4.6, 2024),
            new Movie("Tumbbad", 4.9, 2018),
            new Movie("Dune", 4.7, 2024),
            new Movie("Jawan", 4.2, 2023),
            new Movie("Inception", 4.8, 2010),
            new Movie("Interstellar", 4.9, 2014),
            new Movie("Pathaan", 3.9, 2023)
        );

        movies.stream()
            .filter(m -> m.rating >= 4)          
            .sorted((a, b) -> b.year - a.year)
            .limit(5)                            
            .forEach(System.out::println);
    }
}
