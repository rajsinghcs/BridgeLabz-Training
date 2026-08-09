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


---








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

---
# Day 3 – SQL Advanced Concepts

## Topics Covered

### 1. Joins

Learned to retrieve data from multiple tables using different join operations.

**Types:**

* INNER JOIN
* LEFT JOIN
* RIGHT JOIN
* FULL OUTER JOIN (Concept)
* CROSS JOIN
* SELF JOIN

**Practiced:**

* Multiple-table joins
* Matching and non-matching records
* Table aliases

### 2. Stored Procedures

Learned to create reusable SQL programs for executing multiple statements.

**Topics:**

* Creating & calling procedures
* IN / OUT / INOUT parameters
* Variables and conditional logic

**Benefits:**

* Code reusability
* Better performance
* Improved security
* Reduced network traffic
* Easy maintenance

### 3. Triggers

Learned to automatically execute actions when database events occur.

**Types:**

* BEFORE INSERT
* AFTER INSERT
* BEFORE UPDATE
* AFTER UPDATE
* BEFORE DELETE
* AFTER DELETE

**Practiced:**

* Data validation
* Audit logging
* Data consistency

## Key Learning Outcomes

* Understood different SQL joins and their use cases.
* Implemented stored procedures for reusable operations.
* Used triggers for automated database actions.
* Gained practical knowledge of advanced SQL concepts.

## Technologies Used

* MySQL
* SQL
* MySQL Workbench


---

# 📅 Day 4 — CRUD Operations in Health Clinic App

## 📌 Session Overview

Today's focus was on implementing and testing the core CRUD functionality of the Health Clinic Application using JDBC and MySQL. I verified the flow of data between different modules and ensured that related records were created correctly.

---

## ✅ Tasks Completed

- Implemented and tested **Patient Management** operations.
- Managed **Doctor** and **Specialization** records.
- Scheduled appointments by connecting patients with doctors.
- Processed completed appointments and verified automatic record creation.
- Verified billing details and updated payment status.
- Tested the complete data flow between application layers.

---

## 📚 What I Learned

- Understood how requests travel through the **Presentation Layer**, **Service Layer**, **DAO Layer**, and finally the **Database**.
- Learned how the **DAO Pattern** separates business logic from database operations, making the application easier to maintain.
- Explored **HikariCP Connection Pooling** and understood how reusing database connections improves performance.
- Practiced **Database Transactions**, ensuring multiple related database operations either complete successfully together or roll back completely.
- Gained practical experience using **Foreign Key Constraints** to maintain data consistency between related tables.
- Improved understanding of how different modules interact to build a complete clinic management workflow.

---

## 🎯 Next Steps

- Implement and verify remaining Delete operations.
- Test Visit History retrieval and reporting.
- Add input validation and exception handling.
- Refactor repeated JDBC code for better maintainability.
- Push the completed Day 4 work to GitHub.

---

# 📅 Day 5 — Java Servlet Fundamentals

## 📌 Session Overview

Day 5 focused on Java Servlet fundamentals, Apache Tomcat, Maven Web Applications, HTTP request handling, and HTML form integration.

## 📚 Topics Covered

* Java Servlet Introduction and Architecture
* Servlet Lifecycle
* Apache Tomcat Configuration
* Maven Web Application
* `pom.xml` and WAR Packaging
* Web Container
* `HttpServlet`
* `HttpServletRequest` and `HttpServletResponse`
* `PrintWriter`
* `@WebServlet` and URL Mapping
* `doGet()` and `doPost()`
* GET vs POST
* `request.getParameter()`
* HTML Form Integration
* JSP and Servlet Integration

## 💻 Practical Work

### Greeting Application

* Created a Maven-based Servlet project.
* Configured Apache Tomcat 10.
* Created an HTML form.
* Connected the HTML form with a Servlet.
* Implemented GET and POST request handling.
* Processed user input using `request.getParameter()`.
* Generated dynamic responses using `PrintWriter`.

## 🔧 Troubleshooting

* Fixed `JAVA_HOME` configuration issues.
* Resolved Tomcat deployment problems.
* Fixed HTTP 404 and 405 errors.
* Rebuilt and redeployed the Maven WAR application.

## 🛠 Technologies Used

* Java 21
* Jakarta Servlet API 6
* Apache Tomcat 10
* Maven
* HTML
* IntelliJ IDEA

## 🎯 Key Learnings

* Servlet Request-Response Cycle
* Servlet Lifecycle
* Web Container
* URL Mapping
* GET vs POST
* Form Handling
* Maven WAR Packaging
* Tomcat Deployment



---


# 📅 Day 6 — Java Servlet

## 📌 Session Overview

Day 6 focused on creating Servlets using Maven and implementing a login application with name and password validation.

## 📚 Topics Covered

* Creating a Servlet Project using Maven
* Apache Tomcat Configuration
* Servlet API Dependency
* First Servlet
* Servlet URL Mapping
* Web Container Architecture
* Web Application Directory Structure
* HTML, JSP and Servlet Integration
* HTTP Request and Response
* Servlet Lifecycle
* `doGet()` and `doPost()`
* `HttpServletRequest`
* `HttpServletResponse`
* `@WebServlet`


## 🛠 Technologies Used

* Java
* Jakarta Servlet API
* Maven
* Apache Tomcat
* HTML
* JSP
* IntelliJ IDEA

## 🎯 Key Learnings

* Servlet Lifecycle
* `HttpServlet`
* `doGet()` and `doPost()`
* Request and Response Handling
* URL Mapping
* Web Container
* Maven Dependency Management
* HTML/JSP Integration
* Servlet-based Validation

