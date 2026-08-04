CREATE DATABASE IF NOT EXISTS health_clinic_db;
USE health_clinic_db;

-- Rebuilding the normalized tables
DROP TABLE IF EXISTS patients;
DROP TABLE IF EXISTS doctors;

-- 1. Patients table - 3NF

CREATE TABLE patients (
    patient_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    date_of_birth DATE,
    gender ENUM('Male', 'Female', 'Other'),
    email VARCHAR(100) UNIQUE,
    registered_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 2. Patient phones
-- Separate table for multiple phone numbers

CREATE TABLE patient_phones (
    phone_id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT NOT NULL,
    phone_number VARCHAR(15) NOT NULL,
    FOREIGN KEY (patient_id)
        REFERENCES patients(patient_id)
        ON DELETE CASCADE,
    INDEX idx_patient_id (patient_id)
);

-- 3. Doctors

CREATE TABLE doctors (
    doctor_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    phone_number VARCHAR(15) UNIQUE,
    email VARCHAR(100) UNIQUE
);

-- 4. Specializations

CREATE TABLE specializations (
    specialization_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    description VARCHAR(255)
);

-- 5. Many-to-many relationship between doctors
-- and their specializations

CREATE TABLE doctor_specializations (
    doctor_id INT,
    specialization_id INT,
    PRIMARY KEY (doctor_id, specialization_id),
    FOREIGN KEY (doctor_id)
        REFERENCES doctors(doctor_id)
        ON DELETE CASCADE,
    FOREIGN KEY (specialization_id)
        REFERENCES specializations(specialization_id)
        ON DELETE CASCADE
);

-- 6. Appointment table

CREATE TABLE appointments (
    appointment_id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT NOT NULL,
    doctor_id INT NOT NULL,
    appointment_date DATETIME NOT NULL,
    status ENUM('Scheduled', 'Completed', 'Cancelled')
        DEFAULT 'Scheduled',
    FOREIGN KEY (patient_id)
        REFERENCES patients(patient_id),
    FOREIGN KEY (doctor_id)
        REFERENCES doctors(doctor_id),
    INDEX idx_patient_id (patient_id),
    INDEX idx_doctor_date (doctor_id, appointment_date)
);

-- 7. Billing table
-- UNIQUE appointment_id makes this a 1:1 relationship

CREATE TABLE billing (
    bill_id INT AUTO_INCREMENT PRIMARY KEY,
    appointment_id INT NOT NULL UNIQUE,
    amount DECIMAL(10,2) NOT NULL,
    payment_status ENUM('Pending', 'Paid', 'Refunded')
        DEFAULT 'Pending',
    billing_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (appointment_id)
        REFERENCES appointments(appointment_id)
);

-- 8. Visit history

CREATE TABLE visit_history (
    visit_id INT AUTO_INCREMENT PRIMARY KEY,
    appointment_id INT NOT NULL UNIQUE,
    diagnosis VARCHAR(255),
    prescription VARCHAR(255),
    visit_notes TEXT,
    FOREIGN KEY (appointment_id)
        REFERENCES appointments(appointment_id)
);


-- Sample Records

INSERT INTO patients
    (first_name, last_name, date_of_birth, gender, email)
VALUES
    ('Suresh', 'Sharma', '1982-11-23', 'Male', 'suresh.sharma@email.com');

INSERT INTO patient_phones
    (patient_id, phone_number)
VALUES
    (1, '9812345670'),
    (1, '8877665544');

INSERT INTO doctors
    (first_name, last_name, phone_number, email)
VALUES
    ('Neha', 'Verma', '9234567810', 'dr.neha@clinic.com');

INSERT INTO specializations
    (name, description)
VALUES
    ('Neurology', 'Treatment related to the nervous system'),
    ('Dermatology', 'Skin and hair related treatment');

INSERT INTO doctor_specializations
    (doctor_id, specialization_id)
VALUES
    (1, 1);

INSERT INTO appointments
    (patient_id, doctor_id, appointment_date, status)
VALUES
    (1, 1, '2026-08-06 11:30:00', 'Scheduled');

INSERT INTO billing
    (appointment_id, amount, payment_status)
VALUES
    (1, 1800.00, 'Pending');

INSERT INTO visit_history
    (appointment_id, diagnosis, prescription, visit_notes)
VALUES
    (1, 'General consultation', 'Paracetamol',
     'Patient advised to take adequate rest');


-- Verify appointment details using JOIN

SELECT
    p.first_name,
    p.last_name,
    d.first_name AS doctor_name,
    a.appointment_date,
    b.amount,
    v.diagnosis
FROM appointments a
JOIN patients p
    ON a.patient_id = p.patient_id
JOIN doctors d
    ON a.doctor_id = d.doctor_id
JOIN billing b
    ON a.appointment_id = b.appointment_id
JOIN visit_history v
    ON a.appointment_id = v.appointment_id;


-- Assignment Question 1
-- Rooms and doctor-room relationship

CREATE TABLE rooms (
    room_id INT AUTO_INCREMENT PRIMARY KEY,
    room_number VARCHAR(10) NOT NULL UNIQUE,
    floor_number INT,
    room_type VARCHAR(50)
);

CREATE TABLE doctor_room (
    doctor_id INT,
    room_id INT,
    PRIMARY KEY (doctor_id, room_id),
    FOREIGN KEY (doctor_id)
        REFERENCES doctors(doctor_id)
        ON DELETE CASCADE,
    FOREIGN KEY (room_id)
        REFERENCES rooms(room_id)
        ON DELETE CASCADE
);

INSERT INTO rooms
    (room_number, floor_number, room_type)
VALUES
    ('C105', 1, 'Consultation'),
    ('D204', 2, 'Consultation');

INSERT INTO doctor_room (doctor_id, room_id)
VALUES
    (1, 1),
    (1, 2);


SELECT
    d.first_name,
    d.last_name,
    r.room_number,
    r.floor_number
FROM doctor_room dr
JOIN doctors d
    ON dr.doctor_id = d.doctor_id
JOIN rooms r
    ON dr.room_id = r.room_id;


-- Assignment Questions 2 and 3
-- Checking query execution plans

EXPLAIN
SELECT *
FROM appointments
WHERE status = 'Scheduled';


EXPLAIN
SELECT *
FROM appointments
WHERE patient_id = 1;


EXPLAIN
SELECT *
FROM appointments
WHERE doctor_id = 1
  AND appointment_date = '2026-08-06 11:30:00';


-- Assignment Question 4
-- Covering index

CREATE INDEX idx_covering_doctor
ON appointments (doctor_id, appointment_date, status);

EXPLAIN
SELECT doctor_id, appointment_date, status
FROM appointments
WHERE doctor_id = 1;

