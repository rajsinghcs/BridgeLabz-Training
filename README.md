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



---


# Day 7 - Spring REST API & Request Handling

## Start Developing ContactApp

### Topics Covered

- Spring REST API
- RESTful API Endpoints
- HTTP Methods
- Request Handling in Spring Boot
- `@RestController`
- `@RequestMapping`
- `@GetMapping`
- `@PostMapping`
- `@PutMapping`
- `@DeleteMapping`
- `@RequestBody`
- `@PathVariable`
- `@RequestParam`
- Response Handling
- H2 In-Memory Database Basics
- Distributed Architecture Overview

---

## 1. Spring REST API

A **REST API** allows different applications to communicate with each other over **HTTP**.

Spring Boot provides annotations that make it easy to create RESTful APIs.

### Basic Flow

    Client → Controller → Service → Repository → Database

For ContactApp:

    Client
      ↓
    REST Controller
      ↓
    Service
      ↓
    Repository
      ↓
    Database

---

## 2. RESTful API

**REST (Representational State Transfer)** is an architectural style used for designing web APIs.

A RESTful API exposes resources through URLs and uses HTTP methods to perform operations on those resources.

Example ContactApp resource:

    /contacts

### REST API Endpoints

| HTTP Method | Endpoint | Purpose |
|---|---|---|
| GET | `/contacts` | Retrieve all contacts |
| GET | `/contacts/{id}` | Retrieve a specific contact |
| POST | `/contacts` | Create a new contact |
| PUT | `/contacts/{id}` | Update an existing contact |
| DELETE | `/contacts/{id}` | Delete a contact |

---

## 3. HTTP Methods

| HTTP Method | Purpose |
|---|---|
| GET | Retrieve data |
| POST | Create new data |
| PUT | Update an existing resource |
| PATCH | Partially update a resource |
| DELETE | Delete a resource |

---

## 4. Request Handling in Spring Boot

Spring Boot provides annotations to map HTTP requests to controller methods.

### `@RestController`

Used to define a REST controller that handles HTTP requests and returns data directly, usually in JSON format.

### `@RequestMapping`

Used to define the base URL for a controller or endpoint.

### HTTP Mapping Annotations

| Annotation | HTTP Method | Purpose |
|---|---|---|
| `@GetMapping` | GET | Retrieve data |
| `@PostMapping` | POST | Create data |
| `@PutMapping` | PUT | Update data |
| `@DeleteMapping` | DELETE | Delete data |

---

## 5. Request Data Handling

Spring Boot provides annotations to extract data from different parts of an HTTP request.

### `@RequestBody`

Used to read data from the request body, usually in JSON format.

    JSON Request → Java Object

Commonly used with `POST` and `PUT` requests.

### `@PathVariable`

Used to extract a value from the URL path.

Example:

    /contacts/10

Here, `10` can represent the contact ID.

### `@RequestParam`

Used to extract values from query parameters.

Example:

    /contacts/search?name=Rahul

Here, `name` is a request parameter.

---

## 6. Response Handling

Spring Boot can return Java objects from controller methods, which are automatically converted into JSON.

`ResponseEntity` can be used to control:

- HTTP status code
- Response body
- HTTP headers

### Common HTTP Status Codes

| Status Code | Meaning |
|---|---|
| 200 OK | Request successful |
| 201 Created | Resource successfully created |
| 204 No Content | Request successful with no response body |
| 400 Bad Request | Invalid request |
| 404 Not Found | Resource not found |
| 500 Internal Server Error | Internal server error |

---

## 7. H2 In-Memory Database

**H2** is a lightweight relational database commonly used for development and testing.

An **in-memory database** stores data temporarily in memory while the application is running.

### Advantages

- Easy to configure
- Fast
- No separate database installation required
- Useful for testing
- Data is temporary


---

## Key Takeaways

- `@RestController` → Defines a REST controller
- `@RequestMapping` → Defines a base URL
- `@GetMapping` → Handles GET requests
- `@PostMapping` → Handles POST requests
- `@PutMapping` → Handles PUT requests
- `@DeleteMapping` → Handles DELETE requests
- `@RequestBody` → Reads data from the request body
- `@PathVariable` → Reads values from the URL path
- `@RequestParam` → Reads query parameters
- `ResponseEntity` → Controls HTTP responses
- H2 → Lightweight in-memory database






---

# Day 8 – Contact App: CRUD Operations & Global Exception Handling

## Overview

On Day 8, the Contact Application was enhanced by implementing complete **CRUD Operations** and **Global Exception Handling** using Spring Boot.

The application was structured using different layers such as Controller, Service, Repository, Entity, DTO, and Exception handling.

---

## Features Implemented

### CRUD Operations

Implemented all basic operations required for managing contacts:

* **Create** – Add a new contact.
* **Read** – Retrieve all contacts.
* **Read by ID** – Retrieve a specific contact using its ID.
* **Update** – Update an existing contact.
* **Delete** – Delete a contact using its ID.

---

## Global Exception Handling

Implemented centralized exception handling to manage errors consistently across the application.

### Concepts Used

* Custom Exceptions
* `@RestControllerAdvice`
* `@ExceptionHandler`
* Proper HTTP Status Codes
* Structured Error Responses
* Contact Not Found Exception Handling

### Example Flow

```text
Client Request
      ↓
Controller
      ↓
Service
      ↓
Repository
      ↓
Database
      ↓
Response

If an error occurs:
      ↓
Global Exception Handler
      ↓
Structured Error Response
```

For example, when a contact ID does not exist, the application throws a custom exception. The global exception handler catches the exception and returns an appropriate error response with the correct HTTP status code.

---

## API Endpoints

| HTTP Method | Endpoint         | Description                |
| ----------- | ---------------- | -------------------------- |
| POST        | `/contacts`      | Create a new contact       |
| GET         | `/contacts`      | Get all contacts           |
| GET         | `/contacts/{id}` | Get contact by ID          |
| PUT         | `/contacts/{id}` | Update an existing contact |
| DELETE      | `/contacts/{id}` | Delete a contact by ID     |

---

## Technologies Used

* Java
* Spring Boot
* Spring Data JPA
* H2 Database
* REST API
* Maven

---

## Project Structure

```text
ContactApp
│
├── controller
│   └── Handles HTTP requests and responses
│
├── service
│   └── Contains business logic
│
├── repository
│   └── Handles database operations
│
├── entity
│   └── Represents database tables
│
├── dto
│   └── Handles request and response data
│
└── exception
    └── Handles custom and global exceptions
```

---

## Key Learnings

* Implemented complete CRUD operations using Spring Boot.
* Understood the layered architecture of a Spring Boot application.
* Learned how to create and use custom exceptions.
* Learned how `@RestControllerAdvice` handles exceptions globally.
* Understood how `@ExceptionHandler` catches specific exceptions.
* Learned to return appropriate HTTP status codes.
* Improved API error handling and response structure.

---

## Day 8 Outcome

Successfully implemented **CRUD Operations and Global Exception Handling** in the Contact Application, making the application more robust, maintainable, and user-friendly.

---

# Day 9 – Spring Boot, Controllers & REST APIs

## Overview

On Day 9, the focus was on understanding the core concepts of **Spring Boot**, including **Auto-Configuration**, **Spring Boot Starters**, **Embedded Server**, **Controllers**, **REST APIs**, and different ways of handling HTTP requests.

---

## 1. Spring Boot Auto-Configuration

Learned how Spring Boot automatically configures beans and application components based on the dependencies available in the project.

This reduces the need for large amounts of manual configuration.

### `@SpringBootApplication`

Understood that `@SpringBootApplication` combines three important annotations:

```java
@SpringBootApplication
```

It internally includes:

* `@Configuration`
* `@EnableAutoConfiguration`
* `@ComponentScan`

### Purpose

* `@Configuration` – Marks the class as a configuration class.
* `@EnableAutoConfiguration` – Automatically configures the application based on dependencies.
* `@ComponentScan` – Scans packages and detects Spring components such as `@Controller`, `@Service`, and `@Repository`.

---

## 2. Spring Boot Starters

Studied how Spring Boot starters simplify dependency management.

For REST API and web development, the following starter was used:

```text
spring-boot-starter-web
```

A starter provides commonly required dependencies together, reducing the need to manually add each dependency.

---

## 3. Embedded Server

Learned the concept of the embedded server in Spring Boot.

Spring Boot applications can run independently because an embedded server such as **Tomcat** is included.

### Traditional Application

```text
Application
     ↓
Create WAR File
     ↓
Install External Tomcat
     ↓
Deploy WAR
     ↓
Run Application
```

### Spring Boot Application

```text
Spring Boot Application
         ↓
Embedded Tomcat
         ↓
Run Main Method
         ↓
Application Starts
```

No separate server installation or WAR deployment is required for normal Spring Boot application execution.

---

## 4. Spring Controllers

Worked with:

* `@Controller`
* `@RestController`
* `@RequestMapping`

Controllers receive HTTP requests from clients and send responses back.

### Example

```java
@RestController
@RequestMapping("/contacts")
public class ContactController {
}
```

`@RequestMapping("/contacts")` defines the common base URL for all endpoints inside the controller.

---

## 5. REST API Basics

Implemented REST API endpoints using different HTTP methods.

### Annotations Used

```java
@GetMapping
@PostMapping
@PutMapping
@PatchMapping
@DeleteMapping
```

### CRUD Mapping

| HTTP Method | Operation      |
| ----------- | -------------- |
| POST        | Create         |
| GET         | Read           |
| PUT         | Update         |
| PATCH       | Partial Update |
| DELETE      | Delete         |

---

## 6. Request Handling

Practiced receiving request data using:

* `@RequestBody`
* `@PathVariable`
* `@RequestParam`

### `@RequestBody`

Used to receive JSON data from the request body and convert it into a Java object.

```java
@PostMapping
public ContactResponse createContact(
        @RequestBody ContactRequest request) {
    // Logic
}
```

### `@PathVariable`

Used to receive values directly from the URL.

```java
@GetMapping("/{id}")
public ContactResponse getContact(
        @PathVariable Long id) {
    // Logic
}
```

Example URL:

```text
/contacts/1
```

Here, `1` is received as the `id`.

### `@RequestParam`

Used to receive query parameters.

```java
@GetMapping
public String getContact(
        @RequestParam String name) {
    return name;
}
```

Example:

```text
/contacts?name=Raj
```

---

## Practical Work

* Created Spring Boot REST controllers.
* Created API endpoints for different HTTP methods.
* Handled request data using `@RequestBody`.
* Extracted path values using `@PathVariable`.
* Handled query parameters using `@RequestParam`.
* Tested REST APIs using Postman.
* Verified the complete request and response flow.

---

## Key Learnings

* Auto-configuration reduces manual configuration.
* Spring Boot starters simplify dependency management.
* Embedded Tomcat allows applications to run independently.
* Controllers handle incoming HTTP requests.
* REST APIs use HTTP methods for CRUD operations.
* `@RequestBody`, `@PathVariable`, and `@RequestParam` handle different types of request data.

---

## Day 9 Outcome

Successfully understood and implemented the basic flow of a **Spring Boot REST API**, from receiving an HTTP request in the controller to sending an appropriate response back to the client.

---

# Day 10 – Backend with Spring Boot

## Overview

On Day 10, the focus was on understanding how Spring Boot manages application dependencies, database connectivity, object mapping, entity relationships, and database lifecycle operations.

The Contact Application backend was enhanced using **Dependency Injection**, **Spring JDBC**, **HikariCP**, **H2 Database**, **JPA/Hibernate**, **Entity Lifecycle Callbacks**, and **DTO Mapping**.

---

## 1. Dependency Injection in Spring Boot

Studied the concepts of **Inversion of Control (IoC)** and **Dependency Injection (DI)**.

Spring creates and manages application objects as **Spring Beans**.

### Example

```java
@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }
}
```

Here, Spring automatically injects `ContactRepository` into `ContactService`.

### Concepts Learned

* Spring Beans
* Inversion of Control
* Dependency Injection
* `@Autowired`
* Constructor Injection
* Type Matching
* `@Primary`
* `@Qualifier`

---

## 2. Spring Bean Scopes

Studied different Spring Bean scopes.

### Singleton Scope

Only one object is created for the Spring Application Context.

```text
Spring Container
       ↓
One Bean Object
       ↓
Shared Across Application
```

### Prototype Scope

A new object is created whenever the bean is requested.

```text
Bean Requested
      ↓
New Object

Bean Requested Again
      ↓
Another New Object
```

---

## 3. Spring JDBC

Learned the basics of **JDBC (Java Database Connectivity)**.

JDBC allows Java applications to communicate with relational databases.

### JDBC Flow

```text
Java Application
       ↓
JDBC API
       ↓
JDBC Driver
       ↓
Database
```

Also studied **Spring JDBC** and `JdbcTemplate`.

`JdbcTemplate` reduces JDBC boilerplate code and helps manage:

* Connections
* Statements
* ResultSets
* Resource Cleanup

---

## 4. HikariCP Connection Pool

Learned about **HikariCP**, the connection pool commonly used by Spring Boot.

Instead of creating a new database connection for every request, connections are reused.

### Flow

```text
Application Request
        ↓
     DataSource
        ↓
   HikariCP Pool
        ↓
Existing Database Connection
        ↓
      Database
```

### Benefits

* Improves performance.
* Reduces the cost of creating database connections repeatedly.
* Reuses existing connections.
* Manages database connections efficiently.

---

## 5. H2 Database Integration

Configured and integrated the **H2 In-Memory Database** with the Spring Boot application.

### Learned

* Database configuration using `application.properties`.
* H2 in-memory database concepts.
* H2 Console usage.
* Executing SQL queries.
* Testing CRUD operations.

### Example Configuration

```properties
spring.datasource.url=jdbc:h2:mem:contactdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.h2.console.enabled=true
```

---

## 6. JPA Entity Lifecycle

Studied JPA lifecycle callback annotations.

### `@PrePersist`

Executes before a new entity is inserted into the database.

```java
@PrePersist
public void beforeSave() {
    // Execute before INSERT
}
```

### `@PreUpdate`

Executes before an existing entity is updated.

```java
@PreUpdate
public void beforeUpdate() {
    // Execute before UPDATE
}
```

These callbacks can be used for operations such as automatically setting:

* Created Timestamp
* Updated Timestamp
* Default Values

---

## 7. Entity Relationships & Mapping

Worked with JPA entity relationships.

### Relationships Used

* `@OneToMany`
* `@ManyToOne`

### `mappedBy`

Used to define the inverse side of a bidirectional relationship.

### `cascade`

Used to define which operations should automatically propagate from one entity to related entities.

For example:

```text
Save Parent
     ↓
Cascade
     ↓
Save Child
```

### `orphanRemoval`

Used to automatically remove child entities when they are removed from their parent relationship.

---

## 8. DTO and Entity Mapping

Created separate Mapper classes to convert objects between application layers.

### Request Flow

```text
Client JSON Request
        ↓
RequestDTO
        ↓
Mapper
        ↓
Entity
        ↓
Repository
        ↓
Database
```

### Response Flow

```text
Database
    ↓
Entity
    ↓
Mapper
    ↓
ResponseDTO
    ↓
JSON Response
    ↓
Client
```

### Mapping Performed

```text
RequestDTO
    ↓
Mapper
    ↓
Entity
```

and

```text
Entity
    ↓
Mapper
    ↓
ResponseDTO
```

Using DTOs helps separate the database entity structure from the API request and response structure.

---

## Practical Implementation

Enhanced the **Contact Application Backend** using Spring Boot.

The application included:

* Dependency Injection using Spring Beans.
* Constructor-based dependency injection.
* DTO-to-Entity mapping.
* Entity-to-DTO mapping.
* CRUD operations.
* REST APIs.
* H2 database integration.
* Spring Data JPA.
* JPA/Hibernate entity relationships.
* Spring JDBC concepts.
* HikariCP connection pooling.
* JPA lifecycle callbacks.
* Global exception handling.

---

# Overall Request Flow

The complete request flow of the Contact Application is:

```text
Client / Postman
       ↓
HTTP Request
       ↓
Controller
       ↓
RequestDTO
       ↓
Service
       ↓
Mapper
       ↓
Entity
       ↓
Repository
       ↓
JPA / Hibernate
       ↓
H2 Database
       ↓
Entity
       ↓
Mapper
       ↓
ResponseDTO
       ↓
Controller
       ↓
HTTP Response
       ↓
Client / Postman
```

If an error occurs:

```text
Exception
    ↓
@RestControllerAdvice
    ↓
@ExceptionHandler
    ↓
Error Response
    ↓
Appropriate HTTP Status
    ↓
Client
```

---

# Technologies Used

* Java
* Spring Boot
* Spring MVC
* Spring Web
* Spring Data JPA
* Hibernate
* Spring JDBC
* HikariCP
* H2 Database
* REST API
* Maven
* Postman

---

# Final Outcome

By the end of **Day 8, Day 9, and Day 10**, I successfully enhanced the Contact Application and gained practical knowledge of:

* Building REST APIs using Spring Boot.
* Implementing complete CRUD operations.
* Handling HTTP requests and responses.
* Using Spring Boot Auto-Configuration and Starters.
* Working with Controllers and REST APIs.
* Managing dependencies using Dependency Injection.
* Connecting Spring Boot applications with databases.
* Using Spring Data JPA and Hibernate.
* Managing database connections using HikariCP.
* Working with the H2 in-memory database.
* Understanding JPA entity lifecycle callbacks.
* Implementing entity relationships.
* Mapping DTOs and Entities.
* Handling exceptions globally using `@RestControllerAdvice`.

The Contact Application now follows a structured backend architecture and provides a strong foundation for building larger and more scalable Spring Boot applications.



---

# Day 11 - Employee Payroll App 

## Overview

The **Employee Payroll App** is a backend application built using **Spring Boot** and **Spring Data JPA** to manage employee records and payroll-related operations through REST APIs.

## Features

* Add, view, update, and delete employees
* Get employee by ID
* Search employees by name or department
* Manage employee salary and deductions
* Calculate gross and net salary
* Use DTOs for request and response handling
* Handle errors using custom exceptions and global exception handling

## Technologies Used

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL / H2 Database
* Maven
* REST APIs
* Postman

## Architecture

```text
Controller → Service → Repository → Database
```

* **Controller:** Handles HTTP requests
* **Service:** Contains business logic
* **Repository:** Performs database operations
* **Entity:** Maps Java objects to database tables

---

# Day 12 – Custom Exception Handling

Implemented complete **Employee CRUD operations** and centralized exception handling.

### CRUD APIs

* **POST** – Create Employee
* **GET** – Get Employee(s)
* **PUT** – Update Employee
* **DELETE** – Delete Employee

### Key Concepts

* REST APIs
* DTO Pattern
* Spring Data JPA
* CRUD Operations
* Custom Exceptions
* `EmployeeNotFoundException`
* `@RestControllerAdvice`
* `@ExceptionHandler`
* HTTP Status Codes
* Postman Testing

## Outcome

Successfully built Employee CRUD functionality with **DTOs, Spring Data JPA, and centralized custom exception handling**, making the Payroll application more maintainable and robust.



---

# Day 13 – Spring Boot Profiles

## Employee Payroll Application

Today, I learned and implemented **Spring Boot Profiles** in the Employee Payroll Application.

## What I Learned

* What are Spring Boot Profiles
* Why Spring Boot Profiles are used
* Environment-specific configuration
* `application.yml`
* `application-dev.yml`
* `application-prod.yml`
* Activating a profile using `spring.profiles.active`

## Implementation

Previously, the application configuration was maintained in a single `application.properties` file.

To support different environments, I implemented **Spring Boot Profiles** and separated the configuration into multiple YAML files:

```text
application.yml
application-dev.yml
application-prod.yml
```

This allows the application to use different configurations for development and production environments without changing the main application code.

### Profile Configuration

The active profile can be configured using:

```properties
spring.profiles.active=dev
```

When the `dev` profile is active, Spring Boot loads the configuration from:

```text
application.yml
        +
application-dev.yml
```

This makes it easier to manage environment-specific settings such as database configuration, server properties, and other application settings.

---

# Day 14 – Payroll Operations with Spring Profiles

## Employee Payroll Application

Today, I continued working on the **Employee Payroll Application** and tested the application using the **Spring Boot `dev` profile**.

## Work Done

* Tested the application using the `dev` profile.
* Connected the application to the development **MySQL database**.
* Performed CRUD operations on **Employee** data.
* Performed Payroll operations and verified the stored data.
* Tested REST APIs using **Postman**.
* Verified that the application correctly loads configuration from the active profile.
* Checked database records after performing operations.

## Profile Flow

```text
Client / Postman
       ↓
Spring Boot Application
       ↓
Active Profile: dev
       ↓
application-dev.yml
       ↓
MySQL Database
       ↓
payroll_db
```

## Key Learning

Through this implementation, I understood how **Spring Boot Profiles** help manage different configurations for different environments. The `dev` profile allows the application to connect to the development database, while separate profiles such as `prod` can be used for production-specific configuration.
