# Student CRUD API (Spring Boot + Spring Data JPA + MySQL)

## 📌 Project Overview

Student CRUD API is a RESTful web application built using Spring Boot, Spring Data JPA, Hibernate, and MySQL. It demonstrates how to perform complete CRUD operations, custom finder methods, JPQL queries, pagination, and sorting using a layered architecture (Controller → Service → Repository).

---

## 🚀 Features

* Create Student
* Get All Students
* Get Student by ID
* Update Student
* Delete Student
* Find Students by Name
* Find Student by Email
* Find Students by Course
* Find Students by Name and Course
* Custom Finder Methods
* JPQL using `@Query`
* Pagination
* Sorting (Ascending & Descending)

  * Name
  * Email
  * Course
  * ID

---

## 🛠️ Technologies Used

* Java 21
* Spring Boot 3
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Postman

---

## 📁 Project Structure

```
src
 └── main
     ├── java
     │   └── com.example.studentcrud
     │       ├── controller
     │       ├── model
     │       ├── repository
     │       ├── service
     │       └── StudentcrudApplication
     └── resources
         └── application.properties
```

---

## 📌 REST API Endpoints

### CRUD Operations

| Method | Endpoint         | Description       |
| ------ | ---------------- | ----------------- |
| GET    | `/students`      | Get all students  |
| GET    | `/students/{id}` | Get student by ID |
| POST   | `/students`      | Add a new student |
| PUT    | `/students/{id}` | Update student    |
| DELETE | `/students/{id}` | Delete student    |

---

### Custom Finder Methods

| Method | Endpoint                                       |
| ------ | ---------------------------------------------- |
| GET    | `/students/name/{name}`                        |
| GET    | `/students/email/{email}`                      |
| GET    | `/students/course/{course}`                    |
| GET    | `/students/search?name={name}&course={course}` |

---

### Pagination

| Method | Endpoint                       |
| ------ | ------------------------------ |
| GET    | `/students/page?page=0&size=5` |

---

### Sorting

| Method | Endpoint                     |
| ------ | ---------------------------- |
| GET    | `/students/sort/name`        |
| GET    | `/students/sort/name-desc`   |
| GET    | `/students/sort/email`       |
| GET    | `/students/sort/email-desc`  |
| GET    | `/students/sort/course`      |
| GET    | `/students/sort/course-desc` |
| GET    | `/students/sort/id`          |
| GET    | `/students/sort/id-desc`     |

---

### Pagination with Sorting

| Method | Endpoint                                   |
| ------ | ------------------------------------------ |
| GET    | `/students/page?page=0&size=5&sortBy=name` |

---

## 🗄️ Database

Database: **MySQL**

Table:

```
student
```

Columns:

* id
* name
* email
* course

---

## ▶️ How to Run

1. Clone the repository.
2. Create a MySQL database.
3. Update database credentials in `application.properties`.
4. Run the Spring Boot application.
5. Test APIs using Postman.

---

## 📚 Concepts Covered

* Spring Boot
* REST API
* Spring Data JPA
* Hibernate
* MySQL Integration
* Dependency Injection
* Entity Mapping
* Repository Pattern
* Service Layer
* CRUD Operations
* Custom Finder Methods
* JPQL (`@Query`)
* Pagination
* Sorting

---

## 🔮 Future Improvements

* One-to-One Relationship
* One-to-Many Relationship
* Many-to-One Relationship
* Many-to-Many Relationship
* Validation
* Exception Handling
* Swagger/OpenAPI Documentation
* Unit Testing
* Spring Security with JWT

---

## 👨‍💻 Author

**Nitin Kushwah**

Learning Spring Boot, Spring Data JPA, Hibernate, and Backend Development.
