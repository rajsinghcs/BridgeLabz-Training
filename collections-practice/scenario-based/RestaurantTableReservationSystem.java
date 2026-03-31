import java.util.*;

class TableAlreadyReservedException extends Exception {
    public TableAlreadyReservedException(String message) {
        super(message);
    }
}

class Table {
    int tableNumber;
    int capacity;

    public Table(int tableNumber, int capacity) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
    }
}

class Reservation {
    int tableNumber;
    String timeSlot;
    String customerName;

    public Reservation(int tableNumber, String timeSlot, String customerName) {
        this.tableNumber = tableNumber;
        this.timeSlot = timeSlot;
        this.customerName = customerName;
    }
}

public class RestaurantTableReservationSystem {

    Map<Integer, Table> tables = new HashMap<>();
    List<Reservation> reservations = new ArrayList<>();

    public void addTable(int tableNumber, int capacity) {
        tables.put(tableNumber, new Table(tableNumber, capacity));
    }

    public void reserveTable(int tableNumber, String timeSlot, String customerName)
            throws TableAlreadyReservedException {

        for (Reservation r : reservations) {
            if (r.tableNumber == tableNumber && r.timeSlot.equals(timeSlot)) {
                throw new TableAlreadyReservedException(
                        "Table " + tableNumber + " is already reserved for " + timeSlot
                );
            }
        }

        reservations.add(new Reservation(tableNumber, timeSlot, customerName));
        System.out.println("Table " + tableNumber + " reserved for " + customerName);
    }

    public void cancelReservation(int tableNumber, String timeSlot) {
        reservations.removeIf(r ->
                r.tableNumber == tableNumber && r.timeSlot.equals(timeSlot)
        );
        System.out.println("Reservation cancelled for table " + tableNumber);
    }

    public void showAvailableTables(String timeSlot) {
        System.out.println("\nAvailable tables for " + timeSlot + ":");

        for (Table table : tables.values()) {
            boolean reserved = false;

            for (Reservation r : reservations) {
                if (r.tableNumber == table.tableNumber && r.timeSlot.equals(timeSlot)) {
                    reserved = true;
                    break;
                }
            }

            if (!reserved) {
                System.out.println("Table " + table.tableNumber);
            }
        }
    }

    public static void main(String[] args) {

        RestaurantTableReservationSystem system = new RestaurantTableReservationSystem();

        system.addTable(1, 4);
        system.addTable(2, 6);
        system.addTable(3, 2);

        try {
            system.reserveTable(1, "7PM-9PM", "Raj");
            system.reserveTable(2, "7PM-9PM", "Nived");
            system.reserveTable(1, "7PM-9PM", "Rohit"); 
        } catch (TableAlreadyReservedException e) {
            System.out.println(e.getMessage());
        }

        system.showAvailableTables("7PM-9PM");

        system.cancelReservation(1, "7PM-9PM");
        system.showAvailableTables("7PM-9PM");
    }
}
