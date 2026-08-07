package com.raj.dao;

import com.raj.config.HikariConnectionPool;
import com.raj.dto.Billing;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillingDAOImpl implements BillingDAO {

    private static final String INSERT_SQL =
            "INSERT INTO billing (appointment_id, amount, payment_status) VALUES (?, ?, ?)";

    @Override
    public int insertBilling(Billing billing) {
        try (Connection conn = HikariConnectionPool.getConnection()) {
            return insertBilling(conn, billing);
        } catch (SQLException e) {
            System.out.println("Insert failed: " + e.getMessage());
            return -1;
        }
    }

    @Override
    public int insertBilling(Connection conn, Billing billing) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, billing.getAppointmentId());
            pstmt.setBigDecimal(2, billing.getAmount());
            pstmt.setString(3, billing.getPaymentStatus() != null ? billing.getPaymentStatus() : "Pending");
            pstmt.executeUpdate();
            ResultSet keys = pstmt.getGeneratedKeys();
            if (keys.next()) return keys.getInt(1);
        }
        return -1;
    }

    @Override
    public Billing getBillingById(int id) {
        String sql = "SELECT * FROM billing WHERE billing_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return mapRow(rs);
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Billing getBillingByAppointment(int appointmentId) {
        String sql = "SELECT * FROM billing WHERE appointment_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, appointmentId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return mapRow(rs);
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Billing> getAllBillings() {
        List<Billing> list = new ArrayList<>();
        String sql = "SELECT * FROM billing ORDER BY billing_id";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) list.add(mapRow(rs));
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
        }
        return list;
    }

    @Override
    public boolean updatePaymentStatus(int billingId, String status) {
        String sql = "UPDATE billing SET payment_status = ? WHERE billing_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, status);
            pstmt.setInt(2, billingId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Update failed: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteBilling(int id) {
        String sql = "DELETE FROM billing WHERE billing_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Delete failed: " + e.getMessage());
            return false;
        }
    }

    private Billing mapRow(ResultSet rs) throws SQLException {
        Billing b = new Billing();
        b.setBillingId(rs.getInt("billing_id"));
        b.setAppointmentId(rs.getInt("appointment_id"));
        b.setAmount(rs.getBigDecimal("amount"));
        b.setPaymentStatus(rs.getString("payment_status"));
        Timestamp ts = rs.getTimestamp("billing_date");
        if (ts != null) b.setBillingDate(ts.toLocalDateTime());
        return b;
    }
}