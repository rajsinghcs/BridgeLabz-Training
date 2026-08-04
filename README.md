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







# 📅 Day 2 — Database Programming

## 📌 Session Overview

Day 2 focused on **ER Diagrams, Database Indexing, and Normalization** with practical implementation using a **Health Clinic Database**.

---

## 🔗 1. Entity Relationship (ER) Diagram

### Concepts Covered

* Entities & Attributes
* Relationships & Cardinality
* Primary Key & Foreign Key
* Weak Entity
* ER Diagram Design

### Relationship Types

* **1:1** — One-to-One
* **1:N** — One-to-Many
* **M:N** — Many-to-Many

### Learning Outcome

Learned to design ER diagrams and model relationships between database entities.

---

## ⚡ 2. Database Indexing

### Concepts Covered

* Index and its purpose
* Clustered & Non-Clustered Index
* Composite Index
* Covering Index
* `EXPLAIN`
* Advantages & disadvantages of indexing

### Example

```sql
CREATE INDEX idx_doctor_date
ON appointments(doctor_id, appointment_date);

EXPLAIN
SELECT *
FROM appointments
WHERE doctor_id = 1
  AND appointment_date = '2026-08-06 11:30:00';
```

### Learning Outcome

Learned how indexes improve **data retrieval and query performance**, and how excessive indexing can affect `INSERT`, `UPDATE`, and `DELETE`.

---

## 🗂️ 3. Database Normalization

Studied normalization to **reduce data redundancy and improve data consistency**.

| Normal Form | Main Concept                         |
| ----------- | ------------------------------------ |
| **1NF**     | Atomic values, no repeating groups   |
| **2NF**     | 1NF + No partial dependency          |
| **3NF**     | 2NF + No transitive dependency       |
| **BCNF**    | Every determinant is a candidate key |

### Learning Outcome

Learned how to design structured and normalized relational tables.

---

## 🏥 Practical Implementation

Designed a **Health Clinic Database** using:

```text
patients
patient_phones
doctors
specializations
doctor_specializations
appointments
billing
visit_history
rooms
doctor_room
```

Implemented:

* Primary & Foreign Keys
* 1:1, 1:N & M:N relationships
* Junction tables
* Composite & Covering indexes
* Database normalization
* Query performance analysis using `EXPLAIN`

---

## 🛠️ Skills Gained

* ER Diagram & Database Modeling
* Cardinality
* Database Normalization
* 1NF, 2NF, 3NF & BCNF
* Database Indexing
* Query Optimization
* SQL `EXPLAIN`

## 📌 Key Takeaway

**Good database design = Less Redundancy + Data Consistency + Proper Relationships + Better Performance**
