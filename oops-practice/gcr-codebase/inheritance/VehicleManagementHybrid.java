interface Refuelable {
    void refuel();
}

class BaseVehicle {
    int maxSpeed;
    String model;

    BaseVehicle(int speed, String model) {
        this.maxSpeed = speed;
        this.model = model;
    }
}

class ElectricVehicle extends BaseVehicle {
    ElectricVehicle(int speed, String model) {
        super(speed, model);
    }

    void charge() {
        System.out.println(model + " is charging...");
    }
}

class PetrolVehicle extends BaseVehicle implements Refuelable {
    PetrolVehicle(int speed, String model) {
        super(speed, model);
    }

    public void refuel() {
        System.out.println(model + " is refueling...");
    }
}

public class VehicleManagementHybrid {
    public static void main(String[] args) {
        ElectricVehicle e = new ElectricVehicle(100, "Tesla");
        e.charge();
        PetrolVehicle p = new PetrolVehicle(120, "BMW");
        p.refuel();
    }
}