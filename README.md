# Refresher Training

This repository contains my refresher training work, practice programs, concepts, and assignments covered during the training sessions.

The purpose of this repository is to revise core concepts, strengthen practical knowledge, and maintain hands-on practice.

---

# 📅 Day 1 – DBMS & SQL Fundamentals

## Overview

Day 1 focused on the fundamentals of **Database Management Systems (DBMS)**, relational databases, SQL, database design, normalization, joins, and commonly used SQL commands.

The session also included hands-on practice by creating and managing a **Health Clinic Database**.

---

## 📖 Topics Covered

### 1. Database Fundamentals

- What is Data?
- What is a Database?
- What is DBMS?
- File System vs DBMS
- Advantages of DBMS
- Types of DBMS
- Introduction to RDBMS
- Features of RDBMS
- Relational vs Non-Relational Database
- SQL vs NoSQL
- When to use SQL
- When to use NoSQL

---

## 2. SQL Overview

SQL (Structured Query Language) is used to create, manage, manipulate, and retrieve data from relational databases.

### SQL Command Categories

#### DDL – Data Definition Language

Used to define and modify database structures.

- `CREATE`
- `ALTER`
- `DROP`
- `RENAME`

#### DML – Data Manipulation Language

Used to modify data stored in tables.

- `INSERT`
- `UPDATE`
- `DELETE`

#### DQL – Data Query Language

Used to retrieve data.

- `SELECT`

#### DCL – Data Control Language

Used to control database permissions.

- `GRANT`
- `REVOKE`

#### TCL – Transaction Control Language

Used to manage database transactions.

- `COMMIT`
- `ROLLBACK`
- `SAVEPOINT`

---

# 🔑 Database Design

## Keys

The following database keys were covered:

- Primary Key
- Foreign Key
- Candidate Key
- Composite Key
- Unique Key

## Constraints

- `NOT NULL`
- `UNIQUE`
- `DEFAULT`
- `CHECK`
- `PRIMARY KEY`
- `FOREIGN KEY`

Constraints help maintain the accuracy, consistency, and integrity of data.

---

# 🛠️ Table Operations

Practiced the following table operations:

- Create Database
- Create Table
- Alter Table
- Rename Table
- Drop Column
- Modify Column
- Add Column

Example:

```sql
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