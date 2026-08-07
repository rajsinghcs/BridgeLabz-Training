package com.raj.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Billing {
    private int billingId;
    private int appointmentId;
    private BigDecimal amount;
    private String paymentStatus;
    private LocalDateTime billingDate;

    public Billing() {}
    public Billing(int appointmentId, BigDecimal amount, String paymentStatus) {
        this.appointmentId = appointmentId;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }

    public int getBillingId() { return billingId; }
    public void setBillingId(int billingId) { this.billingId = billingId; }
    public int getAppointmentId() { return appointmentId; }
    public void setAppointmentId(int appointmentId) { this.appointmentId = appointmentId; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
    public LocalDateTime getBillingDate() { return billingDate; }
    public void setBillingDate(LocalDateTime billingDate) { this.billingDate = billingDate; }

    @Override
    public String toString() {
        return "Billing{id=" + billingId + ", appointmentId=" + appointmentId +
                ", amount=" + amount + ", status='" + paymentStatus + "'}";
    }
}