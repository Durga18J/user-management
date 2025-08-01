# 📝 User Management Project

A simple **Spring Boot + MySQL** web application for user registration and listing with filters, pagination, and photo upload.

---

## Features
✅ User Registration (Name, Gender, DOB, Email, Mobile, State, City, Hobbies, Photo Upload)  
✅ Dynamic State & City fetching from Database  
✅ Listing Page with Filters (Name, Gender, State)  
✅ Case‑Insensitive Partial Search (e.g., "Ma" → Manoj, Manish, Suman)  
✅ Pagination support for better data handling  
✅ REST APIs for fetching users and locations  
✅ Bootstrap-based UI with AJAX for dynamic operations  

---

## 🛠 Technologies Used
- **Java 17**  
- **Spring Boot** (REST APIs, JPA, Hibernate)  
- **MySQL** (Database)  
- **Bootstrap 5 & jQuery** (Frontend)  
- **AJAX Calls** (Dynamic Data Loading)  

---

## 📂 Project Structure
user-management/
├── src/main/java/com/example/usermanagement
│ ├── controller/ # REST Controllers
│ ├── entity/ # JPA Entities
│ ├── repository/ # Spring Data JPA Repos
│ ├── service/ # Service Layer Interfaces
│ └── service/impl/ # Service Implementations
│
├── src/main/resources/
│ ├── static/ # HTML, CSS, JS
│ └── application.properties
│
└── pom.xml


---

## ▶️ How to Run Locally

### 1️⃣ Clone the Repository

git clone https://github.com/Durga18J/user-management.git
2️⃣ Open in IntelliJ/Eclipse
Import as Maven Project

3️⃣ Configure Database
Create MySQL DB: CREATE DATABASE usermgmt;

-->Update src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/usermgmt
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

4️⃣ Run the Project

mvn spring-boot:run
The app will start at:
👉 http://localhost:8080/listing.html


🌐 API Endpoints
Method	Endpoint	Description
GET	/users	Fetch all users
POST	/users/register	Register a new user
GET	/locations/states	Get list of states
GET	/locations/cities/{id}	Get cities by state ID






