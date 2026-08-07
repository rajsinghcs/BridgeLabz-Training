package com.raj.dao;

import com.raj.dto.Billing;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface BillingDAO {
    int insertBilling(Billing billing);
    Billing getBillingById(int id);
    Billing getBillingByAppointment(int appointmentId);
    List<Billing> getAllBillings();
    boolean updatePaymentStatus(int billingId, String status);
    boolean deleteBilling(int id);

    int insertBilling(Connection conn, Billing billing) throws SQLException;
}