import com.healthclinic.dao.AppointmentDAO;
import com.healthclinic.dao.DoctorDAO;
import com.healthclinic.dao.PatientDAO;
import com.healthclinic.model.Appointment;
import com.healthclinic.model.Doctor;
import com.healthclinic.model.Patient;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

public class HealthClinicApp {

    private static PatientDAO patientDAO = new PatientDAO();
    private static DoctorDAO doctorDAO = new DoctorDAO();
    private static AppointmentDAO appointmentDAO = new AppointmentDAO();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Health Clinic Management System");
        boolean running = true;

        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Register Patient");
            System.out.println("2. View Doctors");
            System.out.println("3. Book Appointment");
            System.out.println("4. View Patient Appointments");
            System.out.println("5. Exit");
            System.out.println("6. View All Patients");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    registerPatient();
                    break;
                case 2:
                    viewDoctors();
                    break;
                case 3:
                    bookAppointment();
                    break;
                case 4:
                    viewPatientAppointments();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting system...");
                    break;
                case 6:
                    viewAllPatients();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void registerPatient() {
        System.out.println("\n--- Register Patient ---");
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Date of Birth (YYYY-MM-DD): ");
        String dobStr = scanner.nextLine();
        System.out.print("Contact Number: ");
        String contact = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Blood Group: ");
        String bloodGroup = scanner.nextLine();

        Patient patient = new Patient(firstName, lastName, Date.valueOf(dobStr), contact, email, address, bloodGroup);
        if (patientDAO.registerPatient(patient)) {
            System.out.println("Patient registered successfully! ID: " + patient.getId());
        } else {
            System.out.println("Failed to register patient.");
        }
    }

    private static void viewDoctors() {
        System.out.println("\n--- Available Doctors ---");
        List<Doctor> doctors = doctorDAO.getAllDoctors();
        for (Doctor d : doctors) {
            System.out.println(d);
        }
    }

    private static void bookAppointment() {
        System.out.println("\n--- Book Appointment ---");
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        System.out.print("Enter Doctor ID: ");
        int doctorId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Appointment Date (YYYY-MM-DD HH:MM:SS): ");
        String dateStr = scanner.nextLine();
        System.out.print("Reason for Visit: ");
        String reason = scanner.nextLine();

        Appointment appointment = new Appointment(patientId, doctorId, Timestamp.valueOf(dateStr), reason);
        if (appointmentDAO.bookAppointment(appointment)) {
            System.out.println("Appointment booked successfully! ID: " + appointment.getId());
        } else {
            System.out.println("Failed to book appointment.");
        }
    }

    private static void viewPatientAppointments() {
        System.out.println("\n--- View Appointments ---");
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        List<Appointment> appointments = appointmentDAO.getAppointmentsByPatient(patientId);

        if (appointments.isEmpty()) {
            System.out.println("No appointments found for this patient.");
        } else {
            for (Appointment appt : appointments) {
                System.out.println(appt);
            }
        }
    }

    private static void viewAllPatients() {
        System.out.println("\n--- All Registered Patients ---");
        List<Patient> patients = patientDAO.getAllPatients();
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
        } else {
            for (Patient p : patients) {
                System.out.println(p);
            }
        }
    }
}