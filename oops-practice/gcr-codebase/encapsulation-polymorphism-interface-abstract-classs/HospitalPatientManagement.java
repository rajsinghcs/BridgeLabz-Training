interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// Abstract class
abstract class Patient {
    private int patientId;
    private String name;
    private int age;

    // Sensitive data (encapsulated)
    private String diagnosis;
    private String medicalHistory = "";

    // Constructor
    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Encapsulation (getters)
    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Controlled access to sensitive data
    protected void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    protected String getDiagnosis() {
        return diagnosis;
    }

    protected void addToMedicalHistory(String record) {
        medicalHistory += record + "\n";
    }

    protected String getMedicalHistory() {
        return medicalHistory;
    }

    // Concrete method
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    // Abstract method
    abstract double calculateBill();
}

// In-Patient
class InPatient extends Patient implements MedicalRecord {

    private int daysAdmitted;
    private double dailyCharge;

    public InPatient(int id, String name, int age, int days, double charge) {
        super(id, name, age);
        this.daysAdmitted = days;
        this.dailyCharge = charge;
    }

    @Override
    double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    @Override
    public void addRecord(String record) {
        addToMedicalHistory(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records:\n" + getMedicalHistory());
    }
}

// Out-Patient
class OutPatient extends Patient implements MedicalRecord {

    private double consultationFee;

    public OutPatient(int id, String name, int age, double fee) {
        super(id, name, age);
        this.consultationFee = fee;
    }

    @Override
    double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        addToMedicalHistory(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records:\n" + getMedicalHistory());
    }
}

public class HospitalPatientManagement {

    public static void processPatient(Patient p) {
        p.getPatientDetails();
        System.out.println("Total Bill: " + p.calculateBill());

        if (p instanceof MedicalRecord) {
            MedicalRecord mr = (MedicalRecord) p;
            mr.viewRecords();
        }

    }

    public static void main(String[] args) {

        Patient p1 = new InPatient(101, "Ramesh", 45, 5, 3000);
        Patient p2 = new OutPatient(102, "Sita", 30, 800);

        ((MedicalRecord) p1).addRecord("Admitted for surgery");
        ((MedicalRecord) p2).addRecord("General checkup");

        // Polymorphism
        processPatient(p1);
        processPatient(p2);
    }
}
