package com.raj.dao;

import com.raj.dto.Doctor;
import java.util.List;

public interface DoctorDAO {
    int insertDoctor(Doctor doctor);
    Doctor getDoctorById(int id);
    List<Doctor> getAllDoctors();
    boolean updateDoctor(Doctor doctor);
    boolean deleteDoctor(int id);
    boolean assignSpecialization(int doctorId, int specializationId);
}