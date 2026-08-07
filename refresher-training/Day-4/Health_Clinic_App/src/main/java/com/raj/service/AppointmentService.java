package com.raj.service;

import com.raj.config.HikariConnectionPool;
import com.raj.dao.*;
import com.raj.dto.Appointment;
import com.raj.dto.Billing;
import com.raj.dto.VisitHistory;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class AppointmentService {

    private final AppointmentDAO appointmentDAO = new AppointmentDAOImpl();
    private final BillingDAO billingDAO = new BillingDAOImpl();
    private final VisitHistoryDAO visitHistoryDAO = new VisitHistoryDAOImpl();

    public int bookAppointment(int patientId, int doctorId, LocalDateTime dateTime) {
        Appointment appointment = new Appointment(patientId, doctorId, dateTime);
        return appointmentDAO.insertAppointment(appointment);
    }

    public boolean completeAppointment(int appointmentId, BigDecimal amount, String diagnosis, String notes) {
        Connection conn = null;
        try {
            conn = HikariConnectionPool.getConnection();
            conn.setAutoCommit(false);

            boolean updated = appointmentDAO.updateStatus(conn, appointmentId, "Completed");
            if (!updated) throw new SQLException("Appointment #" + appointmentId + " not found.");

            Billing billing = new Billing(appointmentId, amount, "Pending");
            int billingId = billingDAO.insertBilling(conn, billing);
            if (billingId == -1) throw new SQLException("Failed to create bill.");

            VisitHistory visit = new VisitHistory(appointmentId, diagnosis, notes);
            int visitId = visitHistoryDAO.insertVisit(conn, visit);
            if (visitId == -1) throw new SQLException("Failed to record visit history.");

            conn.commit();
            return true;

        } catch (SQLException e) {
            System.out.println("Something failed, undoing everything: " + e.getMessage());
            if (conn != null) {
                try { conn.rollback(); } catch (SQLException ex) {
                    System.out.println("Rollback also failed: " + ex.getMessage());
                }
            }
            return false;
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Failed to close connection: " + e.getMessage());
                }
            }
        }
    }

    public boolean cancelAppointment(int appointmentId) {
        return appointmentDAO.updateStatus(appointmentId, "Cancelled");
    }
}