import java.util.*;

class Flight {
    String flightNo;
    String source;
    String destination;

    Flight(String flightNo, String source, String destination) {
        this.flightNo = flightNo;
        this.source = source;
        this.destination = destination;
    }
}

public class FlightBookingSystem {

    // Available flights 
    static Flight[] flights = {
            new Flight("AI101", "Delhi", "Mumbai"),
            new Flight("AI202", "Pune", "Delhi"),
            new Flight("AI303", "Mumbai", "Chennai")
    };

    // User bookings 
    static List<Flight> bookings = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("---- Available Flights from Delhi ----");
        searchFlight("Delhi");

        System.out.println("\n---- Booking Flight AI101 ----");
        bookFlight("AI101");

        System.out.println("\n---- Booking Flight AI303 ----");
        bookFlight("AI303");

        System.out.println("\n---- User Bookings ----");
        viewBookings();
    }

    // Case-insensitive search
    static void searchFlight(String source) {
        for (Flight f : flights) {
            if (f.source.equalsIgnoreCase(source)) {
                System.out.println(f.flightNo + "  " + f.destination);
            }
        }
    }

    // Booking logic
    static void bookFlight(String flightNo) {
        for (Flight f : flights) {
            if (f.flightNo.equalsIgnoreCase(flightNo)) {
                bookings.add(f);
                System.out.println("Flight " + flightNo + " booked successfully!");
                return;
            }
        }
        System.out.println("Flight " + flightNo + " not found!");
    }

    // Display bookings
    static void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        for (Flight f : bookings) {
            System.out.println(f.flightNo + " " + f.source + "  " + f.destination);
        }
    }
}
