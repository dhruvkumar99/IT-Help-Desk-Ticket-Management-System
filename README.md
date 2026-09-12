# IT Help Desk & Technical Support Ticket Management System

A REST API built with Spring Boot for managing IT support tickets.

## 🛠️ Technologies
- Java 17
- Spring Boot 3.1.5
- Spring Data JPA
- MySQL
- Lombok
- Maven

## 📦 Setup
1. Clone the repo
2. Create MySQL database: `CREATE DATABASE helpdesk_db;`
3. Update `application.properties` with your DB credentials
4. Run: `mvn spring-boot:run`

## 📡 API Endpoints

### Users
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/users | Create user |
| GET | /api/users | Get all users |
| GET | /api/users/{id} | Get user by ID |

### Tickets
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/tickets?userId={id} | Create ticket |
| GET | /api/tickets | Get all tickets |
| GET | /api/tickets/{id} | Get ticket by ID |
| PATCH | /api/tickets/{id}/status | Update status |
| DELETE | /api/tickets/{id} | Delete ticket |

### Comments
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/tickets/{id}/comments | Add comment |
| GET | /api/tickets/{id}/comments | Get comments |
