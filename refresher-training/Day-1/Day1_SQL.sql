create database Health_Clinic_App;
use Health_Clinic_App;

create table Patients (
    PatientID int auto_increment primary key,
    FullName varchar(60) not null,
    DOB date,
    Gender enum('Male','Female','Other'),
    MobileNo varchar(15) unique,
    Email varchar(80),
    RegistrationDate timestamp default current_timestamp
);

alter table Patients modify column Email varchar(60);
alter table Patients add column City varchar(50);
alter table Patients change column City PatientCity varchar(50);
alter table Patients drop column PatientCity;
rename table Patients to ClinicPatients;
rename table ClinicPatients to Patients;

insert into Patients (FullName, DOB, Gender, MobileNo, Email)
values
('Amit Mishra','1987-03-22','Male','9834512760','amit.mishra@gmail.com'),
('Neha Gupta','1995-09-17','Female','9762384510','neha.gupta@gmail.com'),
('Suresh Yadav','1991-12-05','Male','9897456321','suresh.yadav@gmail.com');

update Patients
set MobileNo='9812345678'
where PatientID=1;

delete from Patients
where PatientID=3;

create table Doctors (
    DoctorID int auto_increment primary key,
    FirstName varchar(50),
    LastName varchar(50),
    Specialization varchar(100),
    MobileNo varchar(15) unique,
    Email varchar(80)
);

insert into Doctors (FirstName,LastName,Specialization,MobileNo,Email)
values
('Nisha','Malhotra','General Medicine','9145678230','nisha.malhotra@clinic.com'),
('Arvind','Joshi','ENT Specialist','9182345671','arvind.joshi@clinic.com');

select * from Patients;
select * from Doctors;

create database CollegeDB;
use CollegeDB;

create table Students(
    StudentID int primary key,
    StudentName varchar(100)
);

create table Enrollments(
    EnrollmentID int primary key,
    StudentID int,
    foreign key(StudentID) references Students(StudentID)
);

create table Orders(
    OrderID int,
    ProductID int,
    primary key(OrderID, ProductID)
);

insert into Students values
(101,'Riya'),
(102,'Mohit');

insert into Enrollments values
(1,101),
(2,102);

select *
from Students
inner join Enrollments
on Students.StudentID = Enrollments.StudentID;

select *
from Students
left join Enrollments
on Students.StudentID = Enrollments.StudentID;

select *
from Students
left join Enrollments
on Students.StudentID = Enrollments.StudentID

union

select *
from Students
right join Enrollments
on Students.StudentID = Enrollments.StudentID;

