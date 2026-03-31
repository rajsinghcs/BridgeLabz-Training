package aeroVigil;

import java.util.HashMap;
import java.util.Map;

public class FlightUtil {

    private static final Map<String, Integer> passengerCapacity = new HashMap<>();
    private static final Map<String, Double> fuelCapacity = new HashMap<>();

    static {
        passengerCapacity.put("SpiceJet", 396);
        passengerCapacity.put("Vistara", 615);
        passengerCapacity.put("IndiGo", 230);
        passengerCapacity.put("Air Arabia", 130);

        fuelCapacity.put("SpiceJet", 200000.0);
        fuelCapacity.put("Vistara", 300000.0);
        fuelCapacity.put("IndiGo", 250000.0);
        fuelCapacity.put("Air Arabia", 150000.0);
    }

    public boolean validateFlightNumber(String flightNumber) throws InvalidFlightException {
        if (!flightNumber.matches("FL-[1-9][0-9]{3}")) {
            throw new InvalidFlightException("The flight number " + flightNumber + " is invalid");
        }
        return true;
    }

    public boolean validateFlightName(String flightName) throws InvalidFlightException {
        if (!passengerCapacity.containsKey(flightName)) {
            throw new InvalidFlightException("The flight name " + flightName + " is invalid");
        }
        return true;
    }

    public boolean validatePassengerCount(int passengerCount, String flightName)
            throws InvalidFlightException {

        int max = passengerCapacity.get(flightName);

        if (passengerCount <= 0 || passengerCount > max) {
            throw new InvalidFlightException(
                    "The passenger count " + passengerCount + " is invalid for " + flightName);
        }
        return true;
    }

    public double calculateFuelToFillTank(String flightName, double currentFuelLevel)
            throws InvalidFlightException {

        double maxFuel = fuelCapacity.get(flightName);

        if (currentFuelLevel < 0 || currentFuelLevel > maxFuel) {
            throw new InvalidFlightException("Invalid fuel level for " + flightName);
        }

        return maxFuel - currentFuelLevel;
    }
}
