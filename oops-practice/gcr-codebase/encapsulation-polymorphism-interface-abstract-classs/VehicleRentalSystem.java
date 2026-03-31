interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Abstract class
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate; // per day

    // Constructor
    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Encapsulation (getters only)
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    // Abstract method
    abstract double calculateRentalCost(int days);
}

// Car class
class Car extends Vehicle implements Insurable {
    private String insurancePolicyNumber; // sensitive data

    public Car(String number, double rate, String policy) {
        super(number, "Car", rate);
        this.insurancePolicyNumber = policy;
    }

    @Override
    double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return 500; // fixed insurance
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance Applied";
    }
}

// Bike class
class Bike extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Bike(String number, double rate, String policy) {
        super(number, "Bike", rate);
        this.insurancePolicyNumber = policy;
    }

    @Override
    double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return 200;
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance Applied";
    }
}

// Truck class
class Truck extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Truck(String number, double rate, String policy) {
        super(number, "Truck", rate);
        this.insurancePolicyNumber = policy;
    }

    @Override
    double calculateRentalCost(int days) {
        return (getRentalRate() * days) + 1000; // extra loading charge
    }

    @Override
    public double calculateInsurance() {
        return 1000;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance Applied";
    }
}


public class VehicleRentalSystem {

    public static void main(String[] args) {

        Vehicle v1 = new Car("CAR101", 1500, "CAR-INS-01");
        Vehicle v2 = new Bike("BIKE202", 500, "BIKE-INS-02");
        Vehicle v3 = new Truck("TRUCK303", 3000, "TRUCK-INS-03");

        Vehicle[] vehicles = { v1, v2, v3 };
        int days = 3;

        // Polymorphism
        for (Vehicle v : vehicles) {
            double rentalCost = v.calculateRentalCost(days);
            double insurance = 0;

            if (v instanceof Insurable) {
                insurance = ((Insurable) v).calculateInsurance();
            }

            System.out.println("Vehicle Type: " + v.getType());
            System.out.println("Vehicle Number: " + v.getVehicleNumber());
            System.out.println("Rental Cost (" + days + " days): " + rentalCost);
            System.out.println("Insurance Cost: " + insurance);
            System.out.println("Total Cost: " + (rentalCost + insurance));
           
        }
    }
}
