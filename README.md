# Student CRUD REST API

A structured **Spring Boot REST API** for managing student records, developed progressively from basic CRUD operations to a professional API architecture using **Spring Data JPA, Hibernate, DTOs, Bean Validation, and Global Exception Handling**.

**Current Version:** `v3.0`

---

## 🚀 Key Features

* RESTful CRUD APIs
* Layered Architecture
* Spring Data JPA
* Hibernate ORM
* MySQL Database Integration
* Custom Finder Methods
* JPQL / `@Query`
* Pagination
* Sorting
* Entity Relationships
* Request & Response DTOs
* Entity ↔ DTO Mapping
* Bean Validation
* Custom Validation Messages
* Custom Exceptions
* Global Exception Handling
* Structured Error Responses
* No Lombok

---

## 🛠️ Tech Stack

| Technology              | Purpose                       |
| ----------------------- | ----------------------------- |
| Java                    | Programming Language          |
| Spring Boot             | Backend Framework             |
| Spring Web              | REST API Development          |
| Spring Data JPA         | Data Access                   |
| Hibernate               | ORM                           |
| MySQL                   | Database                      |
| Maven                   | Build & Dependency Management |
| Jakarta Bean Validation | Input Validation              |
| Postman                 | API Testing                   |

---

## 🏗️ Architecture

The project follows a **Layered Architecture** with clear separation of concerns.

```text
Client
   ↓
Controller
   ↓
DTO + Validation
   ↓
Service
   ↓
Mapper
   ↓
Repository
   ↓
MySQL
```

### Exception Flow

```text
Exception
   ↓
@RestControllerAdvice
   ↓
@ExceptionHandler
   ↓
ErrorResponse
   ↓
Client
```

---

## 📂 Project Structure

```text
studentcrud/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/studentcrud/
│       │       │
│       │       ├── controller/
│       │       │   └── StudentController.java
│       │       │
│       │       ├── service/
│       │       │   └── StudentService.java
│       │       │
│       │       ├── repository/
│       │       │   └── StudentRepository.java
│       │       │
│       │       ├── model/
│       │       │   └── Student.java
│       │       │
│       │       ├── dto/
│       │       │   ├── StudentRequestDto.java
│       │       │   └── StudentResponseDto.java
│       │       │
│       │       ├── mapper/
│       │       │   └── StudentMapper.java
│       │       │
│       │       └── exception/
│       │           ├── ResourceNotFoundException.java
│       │           ├── GlobalExceptionHandler.java
│       │           └── ErrorResponse.java
│       │
│       └── resources/
│           └── application.properties
│
├── pom.xml
└── README.md
```

---

# 🔗 API Endpoints

| Method   | Endpoint                                  | Description             |
| -------- | ----------------------------------------- | ----------------------- |
| `GET`    | `/students`                               | Get all students        |
| `GET`    | `/students/{id}`                          | Get student by ID       |
| `GET`    | `/students/name/{name}`                   | Find students by name   |
| `GET`    | `/students/email/{email}`                 | Find student by email   |
| `GET`    | `/students/course?course=Java`            | Find students by course |
| `GET`    | `/students/search?name=Rahul&course=Java` | Search by name & course |
| `POST`   | `/students`                               | Create student          |
| `PUT`    | `/students/{id}`                          | Update student          |
| `DELETE` | `/students/{id}`                          | Delete student          |
| `GET`    | `/students/page?page=0&size=5`            | Pagination              |
| `GET`    | `/students/sort/name/asc`                 | Sort by name ASC        |
| `GET`    | `/students/sort/name/desc`                | Sort by name DESC       |
| `GET`    | `/students/sort/email/asc`                | Sort by email ASC       |
| `GET`    | `/students/sort/email/desc`               | Sort by email DESC      |
| `GET`    | `/students/sort/course/asc`               | Sort by course ASC      |
| `GET`    | `/students/sort/course/desc`              | Sort by course DESC     |
| `GET`    | `/students/sort/id/asc`                   | Sort by ID ASC          |
| `GET`    | `/students/sort/id/desc`                  | Sort by ID DESC         |

---

# 🔵 V3.0 — DTO + Validation + Exception Handling

**Focus:** Improving API design, input validation, maintainability, and error handling.

### Implemented

* Request DTO
* Response DTO
* Entity ↔ DTO Mapping
* Bean Validation
* `@Valid`
* `@NotBlank`
* `@Email`
* `@Size`
* Custom Validation Messages
* `ResourceNotFoundException`
* `@RestControllerAdvice`
* `@ExceptionHandler`
* `MethodArgumentNotValidException`
* Global Exception Handling
* Structured Error Responses
* HTTP Status Codes

---

## 📦 DTO Architecture

### Request Flow

```text
Client
   ↓
StudentRequestDto
   ↓
@Valid
   ↓
Validation
   ↓
Mapper
   ↓
Student Entity
   ↓
Repository
```

### Response Flow

```text
Repository
   ↓
Student Entity
   ↓
Mapper
   ↓
StudentResponseDto
   ↓
Client
```

---

## ✅ Bean Validation

Incoming requests are validated before reaching the service layer.

Example:

```java
@NotBlank(message = "Name is required")
private String name;

@Email(message = "Please enter a valid email")
private String email;

@Size(
    min = 2,
    max = 50,
    message = "Course must be between 2 and 50 characters"
)
private String course;
```

### Controller Validation

```java
@PostMapping
public StudentResponseDto addStudent(
        @Valid @RequestBody StudentRequestDto dto) {

    return service.addStudent(dto);
}
```

---

# ⚠️ Global Exception Handling

The API provides centralized exception handling using:

* `@RestControllerAdvice`
* `@ExceptionHandler`
* `ResourceNotFoundException`
* `MethodArgumentNotValidException`

This keeps API error responses **consistent, structured, and client-friendly**.

### Validation Error

```json
{
  "status": 400,
  "message": "Validation failed",
  "errors": {
    "name": "Name is required",
    "email": "Please enter a valid email"
  }
}
```

### Resource Not Found

```json
{
  "status": 404,
  "message": "Student not found with ID: 100"
}
```

---

# 🗄️ Database Configuration

Create the MySQL database:

```sql
CREATE DATABASE studentdb;
```

Configure `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/studentdb
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

> Replace `YOUR_PASSWORD` with your local MySQL password.

---

# 📦 Main Dependencies

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>

<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope>
</dependency>
```

---

# 🧪 Testing

The API can be tested using **Postman** or any REST client.

### Recommended Testing Flow

```text
Create Student
      ↓
Get All Students
      ↓
Get Student By ID
      ↓
Update Student
      ↓
Search / Filter
      ↓
Pagination
      ↓
Sorting
      ↓
Delete Student
      ↓
Validation Testing
      ↓
Exception Testing
```

---

# 📈 Version History

## 🟢 V1.0 — Spring Boot Basics

**Focus:** Building the foundation of a Spring Boot REST API.

### Implemented

* Spring Boot fundamentals
* Spring Initializr
* Maven basics
* Project structure
* `application.properties`
* Starter dependencies
* `@SpringBootApplication`
* `@RestController`
* `@RequestMapping`
* `@GetMapping`
* `@PostMapping`
* `@PutMapping`
* `@DeleteMapping`
* `@PathVariable`
* `@RequestParam`
* `@RequestBody`
* REST API development
* Layered Architecture
* Database basics

**Result:** Basic Student CRUD REST API.

---

## 🟡 V2.0 — Spring Data JPA + Hibernate

**Focus:** Database persistence and advanced data access.

### Implemented

* JPA fundamentals
* Hibernate ORM
* MySQL database integration
* `@Entity`
* `@Id`
* `@GeneratedValue`
* `JpaRepository`
* CRUD operations
* Custom Finder Methods
* `@Query`
* Pagination
* Sorting
* Entity Relationships

```

**Result:** Advanced Student CRUD API with database querying, pagination, sorting, and JPA features.

---

## 🔵 V3.0 — Professional API Design

**Focus:** Validation, DTO architecture, and centralized error handling.

### Implemented

* Request & Response DTOs
* Entity ↔ DTO Mapping
* Bean Validation
* Custom Validation Messages
* Custom Exceptions
* Global Exception Handling
* Structured Error Responses
* HTTP `400 Bad Request`
* HTTP `404 Not Found`

**Result:** A more structured, maintainable, and client-friendly REST API.

---

# 🔄 Development Progress

```text
V1.0
Spring Boot Basics
      ↓
V2.0
Spring Data JPA + Hibernate
      ↓
V3.0
DTO + Validation + Exception Handling
      ↓
V4.0
Spring Security + JWT
```

| Version  | Status     | Focus                                |
| -------- | ---------- | ------------------------------------ |
| **V1.0** | ✅ Complete | Spring Boot & REST Basics            |
| **V2.0** | ✅ Complete | JPA, Hibernate & Database            |
| **V3.0** | 🔵 Current | DTO, Validation & Exception Handling |
| **V4.0** | ⏳ Planned  | Spring Security & JWT                |

---

# 🔮 V4.0 — Roadmap

The next version will focus on securing the REST API.

### Planned Features

* Spring Security
* User Registration
* Password Encryption
* Authentication
* JWT Generation
* JWT Validation
* Authorization
* Role-Based Access Control
* Protected REST APIs

---

# 🎯 Project Objective

This project demonstrates the progressive development of a Spring Boot backend:

```text
Spring Boot Fundamentals
        ↓
Spring Data JPA + Hibernate
        ↓
Advanced Database Operations
        ↓
DTO + Validation
        ↓
Global Exception Handling
        ↓
Spring Security + JWT
```

The objective is to build a **maintainable, scalable, and secure REST API** while applying practical Spring Boot backend development practices.

---

## 👨‍💻 Development Approach

* Clean layered architecture
* Separation of concerns
* DTO-based API design
* Centralized exception handling
* Input validation
* Database abstraction through Spring Data JPA
* Manual Java implementation without Lombok
* Progressive version-based development

---

## 📌 Current Release

**Student CRUD REST API — `v3.0`**

**Status:** Active Development
