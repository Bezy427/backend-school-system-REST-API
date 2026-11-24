# 🏫 School Management System

![Java](https://img.shields.io/badge/Java-17-blue.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen.svg)
![MySQL](https://img.shields.io/badge/Database-MySQL-blue.svg)
![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)
![Status](https://img.shields.io/badge/Status-In%20Development-orange)

A backend REST API for managing a school, built with Spring Boot. It provides role-based access for students, teachers and principals, and covers departments, subjects, exams, enrollments, attendance and events.

Backend only. The API is designed to plug into any frontend (React, Next.js, Angular).

Table of Contents
Features
Tech Stack
Quick Start
Configuration
Authentication
API Endpoints
Design Notes
Roadmap
License
Features
Role-based access control: Student, Teacher and Principal roles, secured with Spring Security and JWT
Academic management: students, teachers, subjects, exams, enrollments and attendance
Departments: member count updates automatically when teachers are added or removed
Events: manage school events, lectures and schedules
Clean REST design: predictable endpoints with JSON request and response bodies
Tech Stack
Layer	Technology
Language	Java 17
Framework	Spring Boot 3.x
Security	Spring Security + JWT
Persistence	Spring Data JPA / Hibernate
Database	MySQL
Build	Maven (wrapper included)
Testing	JUnit 5
Quick Start

Prerequisites: Java 17, Maven (or use the included mvnw), and a MySQL instance.

bash
# 1. Clone
git clone https://github.com/Bezy427/backend-school-system-REST-API.git
cd backend-school-system-REST-API

# 2. Create your local config (never commit real secrets)
cp .env.example .env
# edit .env with your own database credentials and JWT secret

# 3. Run
./mvnw spring-boot:run

The API starts at http://localhost:8080.

Run the database with Docker (optional)
bash
docker compose up -d

See docker-compose.yml for the database service and credentials. Match these values in your .env.

Configuration

Set these values through environment variables or application.properties.

Setting	Example	Notes
spring.datasource.url	jdbc:mysql://localhost:3306/school_db	Database connection URL
spring.datasource.username	school_user	Do not use root outside local development
spring.datasource.password	change-me	Keep out of version control
spring.jpa.hibernate.ddl-auto	update	Use validate or migrations in production
jwt.secret	long random string	At least 32 characters. Generate with openssl rand -base64 48

⚠️ .env is listed in .gitignore. Only .env.example (with placeholder values) belongs in the repository.

Authentication

All users (teacher, student, principal) register and log in through the auth endpoints.

Method	Endpoint	Description
POST	/auth/register	Register a new user
POST	/auth/login	Authenticate and receive a JWT

Send the token on every protected request:

Authorization: Bearer <your_token_here>

Use Postman to try the endpoints.

API Endpoints
Teachers
Method	Endpoint	Description
GET	/api/teachers	List all teachers
GET	/api/teachers/{id}	Get a teacher by ID
POST	/api/teachers	Create a teacher (increments department member count)
PUT	/api/teachers/{id}	Update a teacher
DELETE	/api/teachers/{id}	Delete a teacher (decrements department member count)
<details> <summary>Example request body</summary>
json
{
  "username": "mjones",
  "firstName": "Mary",
  "lastName": "Jones",
  "email": "mjones@example.com",
  "password": "password123",
  "subject": "Mathematics",
  "qualification": "MSc Mathematics",
  "department": "Science",
  "hireDate": "2025-02-10",
  "phoneNumber": "0712345678",
  "role": "TEACHER",
  "address": "123 Hill Street"
}
</details>
Students
Method	Endpoint	Description
GET	/api/students	List all students
GET	/api/students/{id}	Get a student by ID
POST	/api/students	Create a student
PUT	/api/students/{id}	Update a student
DELETE	/api/students/{id}	Delete a student
<details> <summary>Example request body</summary>
json
{
  "registrationNumber": "STU-001",
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "grade": "Grade 10",
  "dateOfBirth": "2008-05-10",
  "gender": "Male",
  "parentContact": "0789001122"
}
</details>
Departments
Method	Endpoint	Description
GET	/api/departments	List all departments
GET	/api/departments/{id}	Get department details
POST	/api/departments	Create a department
PUT	/api/departments/{id}	Update department name or members
DELETE	/api/departments/{id}	Delete a department
<details> <summary>Example request body</summary>
json
{
  "name": "Science",
  "members": 5
}
</details>
Subjects
Method	Endpoint	Description
GET	/api/subjects	List all subjects
GET	/api/subjects/{id}	Get a subject by ID
POST	/api/subjects	Create a subject linked to a department
DELETE	/api/subjects/{id}	Delete a subject
<details> <summary>Example request body</summary>
json
{
  "subjectName": "Physics",
  "departmentId": 2
}
</details>
Exams
Method	Endpoint	Description
GET	/api/exams	List all exams
GET	/api/exams/{id}	Get exam details
POST	/api/exams	Create an exam
<details> <summary>Example request body</summary>
json
{
  "studentId": 1,
  "examDate": "2025-04-15",
  "decision": "Pending",
  "startTime": "10:00:00",
  "endTime": "12:00:00",
  "postPone": "No"
}
</details>
Enrollments
Method	Endpoint	Description
GET	/api/enrollments	List all enrollments
GET	/api/enrollments/{id}	Get enrollment details
POST	/api/enrollments	Create an enrollment record
<details> <summary>Example request body</summary>
json
{
  "studentId": 1,
  "subjectId": 3,
  "academicYear": "2025",
  "form": "Form 2"
}
</details>
Events
Method	Endpoint	Description
GET	/api/events	List all events
POST	/api/events	Create an event
DELETE	/api/events/{id}	Delete an event
<details> <summary>Example request body</summary>
json
{
  "title": "Science Fair",
  "lectures": "Lecture Hall 1",
  "date": "2025-05-20",
  "startTime": "09:00:00",
  "endTime": "12:00:00",
  "comments": "Annual school science competition."
}
</details>
Attendance
Method	Endpoint	Description
GET	/api/attendance	List attendance records
POST	/api/attendance	Add an attendance record
<details> <summary>Example request body</summary>
json
{
  "studentId": 2,
  "subjectId": 4,
  "date": "2025-04-22",
  "status": "Present"
}
</details>
Design Notes

Automatic department member count. Creating a teacher in a department increments department.members, and deleting one decrements it. This is implemented in TeacherService and DepartmentService.

Trade-off: a stored counter can drift out of sync with the real number of teachers if an update fails or runs concurrently. A more robust alternative is to compute the count from the teachers table when needed. This is on the roadmap.

Data model. Main tables: users, teachers, students, departments, subjects, exams, results, enrollments, events, lectures, assignments, attendance. Entities are linked by foreign keys (department_id, teacher_id, student_id).

Roadmap
 Migrate to PostgreSQL
 Docker Compose for the app and database
 Unit and integration tests for the auth and service layers
 Replace the stored member counter with a computed count
 OpenAPI / Swagger documentation
 Input validation and consistent error responses
License

Released under the MIT License.


