package com.raj.dao;

import com.raj.dto.VisitHistory;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface VisitHistoryDAO {
    int insertVisit(VisitHistory visit);
    VisitHistory getVisitById(int id);
    List<VisitHistory> getVisitsByAppointment(int appointmentId);
    List<VisitHistory> getAllVisits();
    boolean updateVisit(VisitHistory visit);
    boolean deleteVisit(int id);

    int insertVisit(Connection conn, VisitHistory visit) throws SQLException;
}