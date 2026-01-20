import java.util.*;
class InvalidTimeFormatException extends Exception {
    public InvalidTimeFormatException(String message) {
        super(message);
    }
}

public class MovieScheduleManager {

    List<String> titles = new ArrayList<>();
    List<String> showTimes = new ArrayList<>();

    public void addMovie(String title, String time) throws InvalidTimeFormatException {
        if (!isValidTime(time)) {
            throw new InvalidTimeFormatException("Invalid time format: " + time);
        }
        titles.add(title);
        showTimes.add(time);
    }

    public void searchMovie(String keyword) {
        boolean found = false;
        try {
            for (int i = 0; i < titles.size(); i++) {
                if (titles.get(i).contains(keyword)) {
                    System.out.println(
                        String.format("Found: %s at %s", titles.get(i), showTimes.get(i))
                    );
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Movie not found");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Search index error occurred");
        }
    }

    public void displayAllMovies() {
        System.out.println("Movie Schedule");
        for (int i = 0; i < titles.size(); i++) {
            System.out.println(
                String.format("Movie: %s | Time: %s", titles.get(i), showTimes.get(i))
            );
        }
    }

    public void generateReport() {
        String[] titleArray = titles.toArray(new String[0]);
        String[] timeArray = showTimes.toArray(new String[0]);

        System.out.println("Printable Report");
        for (int i = 0; i < titleArray.length; i++) {
            System.out.println(titleArray[i] + " - " + timeArray[i]);
        }
    }


    private boolean isValidTime(String time) {
        if (time.length() != 5 || time.charAt(2) != ':')
            return false;
        int h = Integer.parseInt(time.substring(0, 2));
        int m = Integer.parseInt(time.substring(3, 5));
        return h < 24 && m < 60;
    }


    
    public static void main(String[] args) {
        MovieScheduleManager manager = new MovieScheduleManager();

        try {
            manager.addMovie("Krish", "18:30");
            manager.addMovie("Ravan", "21:00");
            manager.addMovie("Don", "25:99"); 
        } catch (InvalidTimeFormatException e) {
            System.out.println(e.getMessage());
        }

        manager.displayAllMovies();
        manager.searchMovie("Krish");
        manager.generateReport();
    }
}