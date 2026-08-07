package com.raj.ui;

import com.raj.dao.*;
import com.raj.dto.*;
import com.raj.service.AppointmentService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class ConsoleMenu {

    private final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter DATETIME_FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private final PatientDAO patientDAO = new PatientDAOImpl();
    private final DoctorDAO doctorDAO = new DoctorDAOImpl();
    private final SpecializationDAO specializationDAO = new SpecializationDAOImpl();
    private final AppointmentDAO appointmentDAO = new AppointmentDAOImpl();
    private final BillingDAO billingDAO = new BillingDAOImpl();
    private final VisitHistoryDAO visitHistoryDAO = new VisitHistoryDAOImpl();
    private final AppointmentService appointmentService = new AppointmentService();

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\n===== Health Clinic Console =====");
            System.out.println(" 1. Patient Management");
            System.out.println(" 2. Doctor Management");
            System.out.println(" 3. Specialization Management");
            System.out.println(" 4. Appointment Management");
            System.out.println(" 5. Billing (view)");
            System.out.println(" 6. Visit History (view)");
            System.out.println(" 0. Exit");
            System.out.print("Choose: ");

            int choice = readInt();
            switch (choice) {
                case 1 -> patientMenu();
                case 2 -> doctorMenu();
                case 3 -> specializationMenu();
                case 4 -> appointmentMenu();
                case 5 -> billingMenu();
                case 6 -> visitHistoryMenu();
                case 0 -> running = false;
                default -> System.out.println("Invalid choice.");
            }
        }
        System.out.println("Goodbye!");
    }

    // PATIENTS
    private void patientMenu() {
        System.out.println("\n-- Patients -- 1.Add 2.List 3.View 4.Update 5.Delete 0.Back");
        switch (readInt()) {
            case 1 -> addPatient();
            case 2 -> listPatients();
            case 3 -> viewPatient();
            case 4 -> updatePatient();
            case 5 -> deletePatient();
            case 0 -> { }
            default -> System.out.println("Invalid choice.");
        }
    }

    private void addPatient() {
        System.out.print("First name: "); String first = scanner.nextLine();
        System.out.print("Last name: "); String last = scanner.nextLine();
        System.out.print("Email: "); String email = scanner.nextLine();
        System.out.print("Phone: "); String phone = scanner.nextLine();
        System.out.print("Date of birth (yyyy-MM-dd, blank to skip): ");
        String dobStr = scanner.nextLine();
        LocalDate dob = null;
        if (!dobStr.isBlank()) {
            try {
                dob = LocalDate.parse(dobStr, DATE_FMT);
            } catch (DateTimeParseException ex) {
                System.out.println("Invalid date format. Please use yyyy-MM-dd.");
                return;
            }
        }
        System.out.print("Address: "); String address = scanner.nextLine();

        Patient p = new Patient(first, last, email, phone, dob, address);
        int id = patientDAO.insertPatient(p);
        System.out.println(id > 0 ? "Registered with ID: " + id : "Registration failed (duplicate email?).");
    }

    private void listPatients() {
        List<Patient> patients = patientDAO.getAllPatients();
        if (patients.isEmpty()) { System.out.println("No patients found."); return; }
        patients.forEach(System.out::println);
    }

    private void viewPatient() {
        System.out.print("Patient ID: "); int id = readInt();
        Patient p = patientDAO.getPatientById(id);
        System.out.println(p != null ? p : "Not found.");
    }

    private void updatePatient() {
        System.out.print("Patient ID to update: "); int id = readInt();
        Patient existing = patientDAO.getPatientById(id);
        if (existing == null) { System.out.println("Not found."); return; }

        System.out.print("First name [" + existing.getFirstName() + "]: ");
        String v = scanner.nextLine(); if (!v.isBlank()) existing.setFirstName(v);
        System.out.print("Last name [" + existing.getLastName() + "]: ");
        v = scanner.nextLine(); if (!v.isBlank()) existing.setLastName(v);
        System.out.print("Email [" + existing.getEmail() + "]: ");
        v = scanner.nextLine(); if (!v.isBlank()) existing.setEmail(v);
        System.out.print("Phone [" + existing.getPhone() + "]: ");
        v = scanner.nextLine(); if (!v.isBlank()) existing.setPhone(v);
        System.out.print("Address [" + existing.getAddress() + "]: ");
        v = scanner.nextLine(); if (!v.isBlank()) existing.setAddress(v);

        boolean ok = patientDAO.updatePatient(existing);
        System.out.println(ok ? "Updated." : "Update failed.");
    }

    private void deletePatient() {
        System.out.print("Patient ID to delete: "); int id = readInt();
        System.out.println(patientDAO.deletePatient(id) ? "Deleted." : "Delete failed.");
    }

    // DOCTORS
    private void doctorMenu() {
        System.out.println("\n-- Doctors -- 1.Add 2.List 3.View 4.Update 5.Delete 6.Assign Specialization 0.Back");
        switch (readInt()) {
            case 1 -> addDoctor();
            case 2 -> listDoctors();
            case 3 -> viewDoctor();
            case 4 -> updateDoctor();
            case 5 -> deleteDoctor();
            case 6 -> assignSpecialization();
            case 0 -> { }
            default -> System.out.println("Invalid choice.");
        }
    }

    private void addDoctor() {
        System.out.print("First name: "); String first = scanner.nextLine();
        System.out.print("Last name: "); String last = scanner.nextLine();
        System.out.print("Email: "); String email = scanner.nextLine();
        System.out.print("Phone: "); String phone = scanner.nextLine();
        System.out.print("Specialization ID (blank to skip): "); String specStr = scanner.nextLine();
        Integer specId = specStr.isBlank() ? null : Integer.parseInt(specStr);

        Doctor d = new Doctor(first, last, email, phone, specId);
        int id = doctorDAO.insertDoctor(d);
        System.out.println(id > 0 ? "Registered with ID: " + id : "Registration failed (duplicate email?).");
    }

    private void listDoctors() {
        List<Doctor> doctors = doctorDAO.getAllDoctors();
        if (doctors.isEmpty()) { System.out.println("No doctors found."); return; }
        doctors.forEach(System.out::println);
    }

    private void viewDoctor() {
        System.out.print("Doctor ID: "); int id = readInt();
        Doctor d = doctorDAO.getDoctorById(id);
        System.out.println(d != null ? d : "Not found.");
    }

    private void updateDoctor() {
        System.out.print("Doctor ID to update: "); int id = readInt();
        Doctor existing = doctorDAO.getDoctorById(id);
        if (existing == null) { System.out.println("Not found."); return; }

        System.out.print("First name [" + existing.getFirstName() + "]: ");
        String v = scanner.nextLine(); if (!v.isBlank()) existing.setFirstName(v);
        System.out.print("Last name [" + existing.getLastName() + "]: ");
        v = scanner.nextLine(); if (!v.isBlank()) existing.setLastName(v);
        System.out.print("Email [" + existing.getEmail() + "]: ");
        v = scanner.nextLine(); if (!v.isBlank()) existing.setEmail(v);
        System.out.print("Phone [" + existing.getPhone() + "]: ");
        v = scanner.nextLine(); if (!v.isBlank()) existing.setPhone(v);

        boolean ok = doctorDAO.updateDoctor(existing);
        System.out.println(ok ? "Updated." : "Update failed.");
    }

    private void deleteDoctor() {
        System.out.print("Doctor ID to delete: "); int id = readInt();
        System.out.println(doctorDAO.deleteDoctor(id) ? "Deleted." : "Delete failed.");
    }

    private void assignSpecialization() {
        System.out.print("Doctor ID: "); int doctorId = readInt();
        System.out.print("Specialization ID: "); int specId = readInt();
        System.out.println(doctorDAO.assignSpecialization(doctorId, specId) ? "Assigned." : "Assignment failed.");
    }

    //SPECIALIZATIONS
    private void specializationMenu() {
        System.out.println("\n-- Specializations -- 1.Add 2.List 3.Update 4.Delete 0.Back");
        switch (readInt()) {
            case 1 -> {
                System.out.print("Name: "); String name = scanner.nextLine();
                int id = specializationDAO.insertSpecialization(new Specialization(name));
                System.out.println(id > 0 ? "Added with ID: " + id : "Add failed (duplicate name?).");
            }
            case 2 -> {
                List<Specialization> list = specializationDAO.getAllSpecializations();
                if (list.isEmpty()) System.out.println("None found.");
                else list.forEach(System.out::println);
            }
            case 3 -> {
                System.out.print("Specialization ID to update: "); int id = readInt();
                System.out.print("New name: "); String name = scanner.nextLine();
                Specialization s = new Specialization(name);
                s.setSpecializationId(id);
                System.out.println(specializationDAO.updateSpecialization(s) ? "Updated." : "Update failed.");
            }
            case 4 -> {
                System.out.print("Specialization ID to delete: "); int id = readInt();
                System.out.println(specializationDAO.deleteSpecialization(id) ? "Deleted." : "Delete failed.");
            }
            case 0 -> { }
            default -> System.out.println("Invalid choice.");
        }
    }

    //APPOINTMENTS
    private void appointmentMenu() {
        System.out.println("\n-- Appointments -- 1.Book 2.List All 3.By Patient 4.By Doctor 5.Complete 6.Cancel 7.Delete 0.Back");
        switch (readInt()) {
            case 1 -> bookAppointment();
            case 2 -> appointmentDAO.getAllAppointments().forEach(System.out::println);
            case 3 -> {
                System.out.print("Patient ID: "); int pid = readInt();
                appointmentDAO.getAppointmentsByPatient(pid).forEach(System.out::println);
            }
            case 4 -> {
                System.out.print("Doctor ID: "); int did = readInt();
                appointmentDAO.getAppointmentsByDoctor(did).forEach(System.out::println);
            }
            case 5 -> completeAppointment();
            case 6 -> {
                System.out.print("Appointment ID to cancel: "); int id = readInt();
                System.out.println(appointmentService.cancelAppointment(id) ? "Cancelled." : "Cancel failed.");
            }
            case 7 -> {
                System.out.print("Appointment ID to delete: "); int id = readInt();
                System.out.println(appointmentDAO.deleteAppointment(id) ? "Deleted." : "Delete failed.");
            }
            case 0 -> { }
            default -> System.out.println("Invalid choice.");
        }
    }

    private void bookAppointment() {
        System.out.print("Patient ID: "); int patientId = readInt();
        System.out.print("Doctor ID: "); int doctorId = readInt();
        System.out.print("Date/time (yyyy-MM-dd HH:mm): "); String dtStr = scanner.nextLine();
        LocalDateTime dateTime = LocalDateTime.parse(dtStr, DATETIME_FMT);

        int id = appointmentService.bookAppointment(patientId, doctorId, dateTime);
        System.out.println(id > 0 ? "Booked with ID: " + id : "Booking failed.");
    }

    private void completeAppointment() {
        System.out.print("Appointment ID: "); int id = readInt();
        System.out.print("Bill amount: "); BigDecimal amount = new BigDecimal(scanner.nextLine());
        System.out.print("Diagnosis: "); String diagnosis = scanner.nextLine();
        System.out.print("Notes: "); String notes = scanner.nextLine();

        boolean success = appointmentService.completeAppointment(id, amount, diagnosis, notes);
        System.out.println(success ? "Appointment completed! Bill and visit record created." : "Something went wrong — nothing was saved.");
    }

    // BILLING
    private void billingMenu() {
        System.out.println("\n-- Billing -- 1.List All 2.By Appointment 3.Mark Paid 0.Back");
        switch (readInt()) {
            case 1 -> billingDAO.getAllBillings().forEach(System.out::println);
            case 2 -> {
                System.out.print("Appointment ID: "); int aid = readInt();
                Billing b = billingDAO.getBillingByAppointment(aid);
                System.out.println(b != null ? b : "No bill found.");
            }
            case 3 -> {
                System.out.print("Billing ID: "); int bid = readInt();
                System.out.println(billingDAO.updatePaymentStatus(bid, "Paid") ? "Marked Paid." : "Update failed.");
            }
            case 0 -> { }
            default -> System.out.println("Invalid choice.");
        }
    }

    // VISIT HISTORY
    private void visitHistoryMenu() {
        System.out.println("\n-- Visit History -- 1.List All 2.By Appointment 0.Back");
        switch (readInt()) {
            case 1 -> visitHistoryDAO.getAllVisits().forEach(System.out::println);
            case 2 -> {
                System.out.print("Appointment ID: "); int aid = readInt();
                visitHistoryDAO.getVisitsByAppointment(aid).forEach(System.out::println);
            }
            case 0 -> { }
            default -> System.out.println("Invalid choice.");
        }
    }

    //HELPERS
    private int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }
}