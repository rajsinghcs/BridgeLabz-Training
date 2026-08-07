package com.raj.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.raj.dto.Appointment;

public interface AppointmentDAO {
    int insertAppointment(Appointment appointment);
    Appointment getAppointmentById(int id);
    List<Appointment> getAllAppointments();
    List<Appointment> getAppointmentsByPatient(int patientId);
    List<Appointment> getAppointmentsByDoctor(int doctorId);
    boolean updateAppointment(Appointment appointment);
    boolean updateStatus(int appointmentId, String status);
    boolean deleteAppointment(int id);

    boolean updateStatus(Connection conn, int appointmentId, String status) throws SQLException;
}