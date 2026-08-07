package com.raj.dao;

import com.raj.config.HikariConnectionPool;
import com.raj.dto.VisitHistory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VisitHistoryDAOImpl implements VisitHistoryDAO {

    private static final String INSERT_SQL =
            "INSERT INTO visit_history (appointment_id, diagnosis, notes) VALUES (?, ?, ?)";

    @Override
    public int insertVisit(VisitHistory visit) {
        try (Connection conn = HikariConnectionPool.getConnection()) {
            return insertVisit(conn, visit);
        } catch (SQLException e) {
            System.out.println("Insert failed: " + e.getMessage());
            return -1;
        }
    }

    @Override
    public int insertVisit(Connection conn, VisitHistory visit) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, visit.getAppointmentId());
            pstmt.setString(2, visit.getDiagnosis());
            pstmt.setString(3, visit.getNotes());
            pstmt.executeUpdate();
            ResultSet keys = pstmt.getGeneratedKeys();
            if (keys.next()) return keys.getInt(1);
        }
        return -1;
    }

    @Override
    public VisitHistory getVisitById(int id) {
        String sql = "SELECT * FROM visit_history WHERE visit_id = ?";
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
    public List<VisitHistory> getVisitsByAppointment(int appointmentId) {
        List<VisitHistory> list = new ArrayList<>();
        String sql = "SELECT * FROM visit_history WHERE appointment_id = ? ORDER BY visit_date DESC";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, appointmentId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) list.add(mapRow(rs));
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
        }
        return list;
    }

    @Override
    public List<VisitHistory> getAllVisits() {
        List<VisitHistory> list = new ArrayList<>();
        String sql = "SELECT * FROM visit_history ORDER BY visit_date DESC";
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
    public boolean updateVisit(VisitHistory visit) {
        String sql = "UPDATE visit_history SET diagnosis=?, notes=? WHERE visit_id=?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, visit.getDiagnosis());
            pstmt.setString(2, visit.getNotes());
            pstmt.setInt(3, visit.getVisitId());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Update failed: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteVisit(int id) {
        String sql = "DELETE FROM visit_history WHERE visit_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Delete failed: " + e.getMessage());
            return false;
        }
    }

    private VisitHistory mapRow(ResultSet rs) throws SQLException {
        VisitHistory v = new VisitHistory();
        v.setVisitId(rs.getInt("visit_id"));
        v.setAppointmentId(rs.getInt("appointment_id"));
        v.setDiagnosis(rs.getString("diagnosis"));
        v.setNotes(rs.getString("notes"));
        Timestamp ts = rs.getTimestamp("visit_date");
        if (ts != null) v.setVisitDate(ts.toLocalDateTime());
        return v;
    }
}