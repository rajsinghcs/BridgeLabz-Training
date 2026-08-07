package com.raj.dto;

public class Doctor {
    private int doctorId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Integer specializationId;
    private String specializationName;

    public Doctor() {}
    public Doctor(String firstName, String lastName, String email, String phone, Integer specializationId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.specializationId = specializationId;
    }

    public int getDoctorId() { return doctorId; }
    public void setDoctorId(int doctorId) { this.doctorId = doctorId; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public Integer getSpecializationId() { return specializationId; }
    public void setSpecializationId(Integer specializationId) { this.specializationId = specializationId; }
    public String getSpecializationName() { return specializationName; }
    public void setSpecializationName(String specializationName) { this.specializationName = specializationName; }

    @Override
    public String toString() {
        return "Doctor{id=" + doctorId + ", name='Dr. " + firstName + " " + lastName +
                "', email='" + email + "', specialization=" +
                (specializationName != null ? specializationName : specializationId) + "}";
    }
}