# Student CRUD API

A simple REST API built with **Spring Boot**, **Spring Data JPA**, **Hibernate**, and **MySQL**. This project demonstrates CRUD (Create, Read, Update, Delete) operations using a layered architecture.

## 🚀 Features

* Create a new student
* Get all students
* Get a student by ID
* Update student details
* Delete a student
* MySQL database integration using Spring Data JPA

## 🛠️ Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven

## 📂 Project Structure

```text
src
 ├── controller
 ├── service
 ├── repository
 ├── model
 └── resources
```

## 🌐 API Endpoints

| Method | Endpoint         | Description          |
| ------ | ---------------- | -------------------- |
| GET    | `/students`      | Get all students     |
| GET    | `/students/{id}` | Get student by ID    |
| POST   | `/students`      | Create a new student |
| PUT    | `/students/{id}` | Update student       |
| DELETE | `/students/{id}` | Delete student       |

## 🗄️ Database

* MySQL
* Hibernate ORM
* Spring Data JPA

## ▶️ How to Run

1. Clone the repository.
2. Create a MySQL database named `student_db`.
3. Update `application.properties` with your MySQL username and password.
4. Run the Spring Boot application.
5. Test the APIs using Postman.

## 📚 Learning Topics Covered

* Spring Boot
* REST API
* Layered Architecture
* Spring Data JPA
* Hibernate
* MySQL Integration
* CRUD Operations
* Git & GitHub

## 🔮 Future Improvements

* Custom Finder Methods
* `@Query`
* Pagination
* Sorting
* One-to-One Mapping
* One-to-Many Mapping
* Many-to-One Mapping
* Many-to-Many Mapping

## 👨‍💻 Author

**Nitin Kushwah**
