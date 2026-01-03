class Device {
    String deviceId;
    String status;

    Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }
}

class Thermostat extends Device {
    double temperatureSetting;

    Thermostat(String deviceId, String status, double temp) {
        super(deviceId, status);
        this.temperatureSetting = temp;
    }

    void displayStatus() {
        System.out.println("ID: " + deviceId + ", Status: " + status + ", Temp: " + temperatureSetting + "°C");
    }
}

public class SmartHomeDevice {
    public static void main(String[] args) {
        Thermostat t = new Thermostat("T1", "ON", 25.5);
        t.displayStatus();
    }
}
