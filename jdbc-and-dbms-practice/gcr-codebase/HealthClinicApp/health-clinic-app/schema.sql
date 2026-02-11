CREATE DATABASE IF NOT EXISTS health_clinic_db;
USE health_clinic_db;

-- Specialties Table
CREATE TABLE IF NOT EXISTS specialties (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    description TEXT
);

-- Doctors Table
CREATE TABLE IF NOT EXISTS doctors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    specialty_id INT,
    contact VARCHAR(20),
    email VARCHAR(100) UNIQUE,
    consultation_fee DECIMAL(10, 2),
    is_active BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (specialty_id) REFERENCES specialties(id)
);

-- Patients Table
CREATE TABLE IF NOT EXISTS patients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    date_of_birth DATE,
    contact VARCHAR(20),
    email VARCHAR(100) UNIQUE,
    address TEXT,
    blood_group VARCHAR(5)
);

-- Appointments Table
CREATE TABLE IF NOT EXISTS appointments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    doctor_id INT,
    appointment_date DATETIME NOT NULL,
    status ENUM('SCHEDULED', 'COMPLETED', 'CANCELLED') DEFAULT 'SCHEDULED',
    reason TEXT,
    FOREIGN KEY (patient_id) REFERENCES patients(id),
    FOREIGN KEY (doctor_id) REFERENCES doctors(id)
);

-- Initial Data Seeding
INSERT INTO specialties (name, description) VALUES 
('Cardiology', 'Heart and blood vessel disorders'),
('Dermatology', 'Skin, hair, and nail conditions'),
('Pediatrics', 'Medical care of infants, children, and adolescents');

INSERT INTO doctors (name, specialty_id, contact, email, consultation_fee) VALUES 
('Dr. Smith', 1, '555-0101', 'smith@clinic.com', 150.00),
('Dr. Jones', 2, '555-0102', 'jones@clinic.com', 100.00);