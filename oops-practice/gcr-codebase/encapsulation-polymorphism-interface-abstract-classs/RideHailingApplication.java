interface GPS {
    String getCurrentLocation();
    void updateLocation(String location);
}

// Abstract class
abstract class Vehicle {
    private int vehicleId;
    private String driverName;
    private double ratePerKm;

    // GPS data (encapsulated)
    private String currentLocation = "Unknown";

    // Constructor
    public Vehicle(int vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // Encapsulation (getters only)
    public int getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    protected double getRatePerKm() {
        return ratePerKm;
    }

    // Concrete method
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
    }

    // GPS helper methods
    protected void setLocation(String location) {
        currentLocation = location;
    }

    protected String getLocation() {
        return currentLocation;
    }

    // Abstract method
    abstract double calculateFare(double distance);
}

// Car class
class Car extends Vehicle implements GPS {

    public Car(int id, String driver, double rate) {
        super(id, driver, rate);
    }

    @Override
    double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    @Override
    public String getCurrentLocation() {
        return getLocation();
    }

    @Override
    public void updateLocation(String location) {
        setLocation(location);
    }
}

// Bike class
class Bike extends Vehicle implements GPS {

    public Bike(int id, String driver, double rate) {
        super(id, driver, rate);
    }

    @Override
    double calculateFare(double distance) {
        return (getRatePerKm() * distance) - 10; // cheaper ride
    }

    @Override
    public String getCurrentLocation() {
        return getLocation();
    }

    @Override
    public void updateLocation(String location) {
        setLocation(location);
    }
}

// Auto class
class Auto extends Vehicle implements GPS {

    public Auto(int id, String driver, double rate) {
        super(id, driver, rate);
    }

    @Override
    double calculateFare(double distance) {
        return (getRatePerKm() * distance) + 20; // extra charge
    }

    @Override
    public String getCurrentLocation() {
        return getLocation();
    }

    @Override
    public void updateLocation(String location) {
        setLocation(location);
    }
}

public class RideHailingApplication {

    // Polymorphic fare calculator
    public static void calculateRideFare(Vehicle v, double distance) {
        v.getVehicleDetails();
        System.out.println("Distance: " + distance + " km");
        System.out.println("Total Fare: Rs-" + v.calculateFare(distance));
        
    }
    public static void main(String[] args) {

        Vehicle v1 = new Car(101, "Amit", 15);
        Vehicle v2 = new Bike(102, "Ravi", 10);
        Vehicle v3 = new Auto(103, "Suresh", 12);

        // GPS update
        ((GPS) v1).updateLocation("City Center");
        ((GPS) v2).updateLocation("Railway Station");
        ((GPS) v3).updateLocation("Bus Stand");

        // Polymorphism
        calculateRideFare(v1, 10);
        calculateRideFare(v2, 10);
        calculateRideFare(v3, 10);
    }
}