import java.util.*;
class User{
    String gender;
    String name;
    
    User(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }
}

    class Driver{
        String gender;
        String name;
        boolean isAvailable;

        Driver(String name  , String gender) {
            this.name = name;
            this.gender = gender;
            this.isAvailable = true;
        }
    }

    class Ride{
        User userName;
        double distance;
        Driver driver;
        double fare;

        Ride(User userName, Driver driver, double distance, double fare) {
            this.userName = userName;
            this.driver = driver;
            this.distance = distance;
            this.fare = fare;
       }
   }

    interface FareCalculator {
        double calculateFare(double distance);
    }

    class GeneralFare implements FareCalculator {
        public double calculateFare(double distance) {
            return distance * 10; // ₹10 per km
       }
    }
    
    class NoDriverAvailableException extends Exception {
        public NoDriverAvailableException(String message) {
            super(message);
       }
    }
    
    class RideService{
        List<Driver> drivers = new ArrayList<>();
        List<Ride> ridesHistory = new ArrayList<>();
        
        
        public void addDriver(Driver driver) {
            drivers.add(driver);
        }
        
        public Driver assignDriver() throws NoDriverAvailableException{
            for(Driver driver: drivers){
                if(driver.isAvailable){
                    driver.isAvailable = false;
                    return driver;
                }
           }
           throw new NoDriverAvailableException("No drivers available at the moment.");
        }
        
        public Ride bookRide(User userName, double distance, FareCalculator calculator) throws NoDriverAvailableException {
            Driver assignedDriver = assignDriver();
            double fare = calculator.calculateFare(distance);
            Ride newRide = new Ride(userName, assignedDriver, distance, fare);
            ridesHistory.add(newRide);
            return newRide;
        }
        
        public void showRideHistory() {
            for (Ride r : ridesHistory) {
                System.out.println("User: " + r.userName.name +", Driver: " + r.driver.name +", Distance: " + r.distance +", Fare: RS- " + r.fare);
            }
        }
    }
    
    public class RideManagementSystem{
        public static void main(String[] args) {
            RideService rideService = new RideService();
            rideService.addDriver(new Driver("Rohit", "Male"));
            rideService.addDriver(new Driver("Nived", "Male"));
            
            
            User user1 = new User("Raj Bahadur Singh","Male");
            FareCalculator generalFare = new GeneralFare();
            
            
            try{
                Ride ride1 = rideService.bookRide(user1, 15.0, generalFare);
                System.out.println("Ride booked successfully for " + user1.name);
                System.out.println("Driver assigned: " + ride1.driver.name);
                System.out.println("Fare: RS- " + generalFare.calculateFare(15.0));
            
            } catch (NoDriverAvailableException e) {
                System.out.println(e.getMessage());
            }
            
            System.out.println("\nRide History:");
            rideService.showRideHistory();
        }
    }
