import java.util.*;

interface IPayable {
    double calculateBill();
}

abstract class Patient implements IPayable {
    private int patientId;
    private String name;
    private int age;

    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Polymorphism
    public abstract void displayInfo();
}

class InPatient extends Patient {
    private int daysAdmitted;
    private double dailyCharge;

    public InPatient(int id, String name, int age, int days, double charge) {
        super(id, name, age);
        this.daysAdmitted = days;
        this.dailyCharge = charge;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    @Override
    public void displayInfo() {
        System.out.println(
                "InPatient | ID: " + getPatientId() +
                " | Name: " + getName() +
                " | Bill: ₹" + calculateBill()
        );
    }
}

class OutPatient extends Patient {
    private double consultationFee;

    public OutPatient(int id, String name, int age, double fee) {
        super(id, name, age);
        this.consultationFee = fee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void displayInfo() {
        System.out.println(
                "OutPatient | ID: " + getPatientId() +
                " | Name: " + getName() +
                " | Bill: ₹" + calculateBill()
        );
    }
}

public class HospitalPatientManagementSystem {

    public static void main(String[] args) {

        //patient details 
        Patient p1 = new InPatient(101, "Rohit", 30, 5, 2000);
        Patient p2 = new OutPatient(102, "Amit", 25, 500);
        Patient p3 = new InPatient(103, "Neha", 40, 3, 2500);

        // Store patients
        List<Patient> patients = new ArrayList<>();
        patients.add(p1);
        patients.add(p2);
        patients.add(p3);

        // Polymorphism 
        System.out.println("---- Hospital Patient Details ----");
        for (Patient p : patients) {
            p.displayInfo();
        }
    }
}
