import java.util.*;

interface IRentable {
    double calculateRent(int days);
}

abstract class Vehicle implements IRentable {
    protected String vehicleNo;
    protected double ratePerDay;

    public Vehicle(String vehicleNo, double ratePerDay) {
        this.vehicleNo = vehicleNo;
        this.ratePerDay = ratePerDay;
    }
}

class Bike extends Vehicle {
    public Bike(String no) { super(no, 300); }
    public double calculateRent(int days) { return days * ratePerDay; }
}

class Car extends Vehicle {
    public Car(String no) { super(no, 800); }
    public double calculateRent(int days) { return days * ratePerDay; }
}

class Truck extends Vehicle {
    public Truck(String no) { super(no, 1500); }
    public double calculateRent(int days) { return days * ratePerDay; }
}

public class VehicleRentalApplication {
    public static void main(String[] args) {
        IRentable v = new Car("MH12AB1234");
        System.out.println("Rent: RS- " + v.calculateRent(5));
    }
}
