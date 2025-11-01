# 🏫 School Management System

![Java](https://img.shields.io/badge/Java-24-blue.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen.svg)
![MySQL](https://img.shields.io/badge/Database-MySQL-blue.svg)
![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)
![Status](https://img.shields.io/badge/Status-In%20Development-orange)

A **comprehensive School Management System** built with **Spring Boot** and **MySQL**, providing role-based access for students, teachers, and principals.  
It manages all aspects of a school — from **students, teachers, and departments** to **subjects, exams, enrollments, attendance, and events**.

---

## 🧭 Table of Contents
- [✨ Features](#-features)
- [🧰 Tech Stack](#-tech-stack)
- [🗄️ Database Structure](#️-database-structure)
- [⚙️ Setup & Installation](#️-setup--installation)
- [🚀 Usage](#-usage)
- [📡 API Endpoints](#-api-endpoints)
- [🤝 Contributing](#-contributing)
- [📜 License](#-license)

---

## ✨ Features

✅ **Role-Based Access Control**
- Student, Teacher, and Principal roles  
- Secured with Spring Security and JWT  

✅ **Auto Department Member Counting**
- Each time a teacher joins or leaves, the department’s `members` count updates automatically  

✅ **Full Academic Management**
- Students, teachers, exams, attendance, enrollments, and subjects  

✅ **Event Management**
- Manage school events, lectures, and schedules  

✅ **RESTful APIs**
- Clean, structured endpoints for easy integration with frontends (React, Next.js, etc.)

---

## 🧰 Tech Stack

| Layer | Technology |
|-------|-------------|
| **Backend** | Java 17, Spring Boot 3.x |
| **Database** | MySQL |
| **Security** | Spring Security + JWT |
| **ORM** | JPA / Hibernate |
| **Build Tool** | Maven |
| **Testing** | JUnit 5 |
| **Frontend Ready For** | React, Next.js, or Angular |

---

## 🗄️ Database Structure

**Main Tables**
- `users`
- `teachers`
- `students`
- `departments`
- `subjects`
- `exams`
- `results`
- `enrollments`
- `events`
- `lectures`
- `assignments`
- `attendance`

Each entity is linked via foreign keys for data consistency (e.g. `department_id`, `teacher_id`, `student_id`).

---

## Edit application.properties

- `spring.datasource.url=jdbc:mysql://localhost:3306/school_db`
- `spring.datasource.username=root`
- `spring.datasource.password=yourpassword`
- `spring.jpa.hibernate.ddl-auto=update`
- `spring.jpa.show-sql=true`
- `jwt.secret=yourSecretKey`

## Run the Project

- `mvn clean install`
- `mvn spring-boot:run`

App runs at: http://localhost:8080

### 🚀 Usage

## 🔐 Authentication

## Every user (Teacher, Student, Principal) can register and log in via:

### Method	Endpoint	Description:

`POST	/auth/register	Register new user`
`POST	/auth/login	Authenticate and receive JWT token`

### Use JWT in headers for all protected requests:

Authorization: Bearer <your_token_here>

## API Testing Using POSTMAN:

## 📡 API Endpoints

### 🧑‍🏫 Teachers API

###Method	Endpoint	Description

`GET	/api/teachers	Get all teachers`
`GET	/api/teachers/{id}	Get teacher by ID`
`POST	/api/teachers	Create a new teacher (auto-updates department members count)`
`PUT	/api/teachers/{id}	Update teacher information`
`DELETE	/api/teachers/{id}	Delete teacher (auto-decreases department members count)`

## 🧩 Example JSON for Creating a Teacher:

{
  `"username": "mjones",`
  `"firstName": "Mary",`
  `"lastName": "Jones",`
  `"email": "mjones@example.com",`
  `"password": "password123",`
  `"subject": "Mathematics",`
  `"qualification": "MSc Mathematics",`
  `"department": "Science",`
  `"hireDate": "2025-02-10",`
  `"phoneNumber": "0712345678",`
  `"role": "TEACHER",`
  `"address": "123 Hill Street"`
}

## 👩‍🎓 Students API

### Method	Endpoint	Description

`GET	/api/students	Get all students`
`GET	/api/students/{id}	Get student by ID`
`POST	/api/students	Create new student`
`PUT	/api/students/{id}	Update student`
`DELETE	/api/students/{id}	Delete student`

## 🧩 Example JSON:

{
  `"registrationNumber": "STU-001",`
  `"firstName": "John",`
  `"lastName": "Doe",`
  `"email": "john.doe@example.com",`
  `"grade": "Grade 10",`
  `"dateOfBirth": "2008-05-10",`
  `"gender": "Male",`
  `"parentContact": "0789001122"`
}

## 🏛️ Departments API

### Method	Endpoint	Description

`GET	/api/departments	Get all departments`
`GET	/api/departments/{id}	Get department details`
`POST	/api/departments	Create department`
`PUT	/api/departments/{id}	Update department name/members`
`DELETE	/api/departments/{id}	Delete department`

## 🧩 Example JSON:

{
  `"name": "Science",`
  `"members": 5`
}

## 📚 Subjects API

### Method	Endpoint	Description

`GET	/api/subjects	Get all subjects`
`POST	/api/subjects	Create subject (linked to department)`
`GET	/api/subjects/{id}	Get subject by ID`
`DELETE	/api/subjects/{id}	Delete subject`

## 🧩 Example JSON:

{
  `"subjectName": "Physics",`
  `"departmentId": 2`
}

## 🧾 Exams API

### Method	Endpoint	Description

`GET	/api/exams	Get all exams`
`POST	/api/exams	Create exam`
`GET	/api/exams/{id}	Get exam details`

## 🧩 Example JSON:

{
  `"studentId": 1,`
  `"examDate": "2025-04-15",`
  `"decision": "Pending",`
  `"startTime": "10:00:00",`
  `"endTime": "12:00:00",`
  `"postPone": "No"`
}

## 🧾 Enrollments API

### Method	Endpoint	Description

- `GET	/api/enrollments	Get all enrollments`
- `POST	/api/enrollments	Create enrollment record`
- `GET	/api/enrollments/{id}	Get enrollment details`

## 🧩 Example JSON:

{
  `"studentId": 1,`
  `"subjectId": 3,`
  `"academicYear": "2025",`
  `"form": "Form 2",`
}

## 🗓️ Events API

### Method	Endpoint	Description

- `GET	/api/events	List all events`
- `POST	/api/events	Create new event`  
- `DELETE	/api/events/{id}	Delete event`


## 🧩 Example JSON:

{
  `"title": "Science Fair",`
  `"lectures": "Lecture Hall 1",`
  `"date": "2025-05-20",`
  `"startTime": "09:00:00",`
  `"endTime": "12:00:00",`
  `"comments": "Annual school science competition."`
}

## 🕒 Attendance API

### Method	Endpoint	Description

`GET	/api/attendance	Get attendance records`
`POST	/api/attendance	Add new attendance record`

## 🧩 Example JSON:

{
  `"studentId": 2,`
  `"subjectId": 4,`
  `"date": "2025-04-22",`
  `"status": "Present"`
}

## 🧩 Automatic Department Member Count

When a teacher is created and assigned to a department,
→ department.members increases by 1 automatically.

When a teacher is deleted,
→ department.members decreases by 1 automatically.

This logic is implemented in the TeacherService and DepartmentService.

## ⚙️ Setup & Installation

### Clone Repository
```bash
git clone https://github.com/Bezy427/school-system-REST-API.git
cd school-system


