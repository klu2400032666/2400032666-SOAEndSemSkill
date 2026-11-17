# Tourist Management System - JWT Token Validation

Spring Boot REST API demonstrating login, JWT generation, token validation, and protected hotel update operations.

## Requirements
- Java 17
- Maven

## Run
```bash
mvn spring-boot:run
```

## Demo login
- Username: `tourist`
- Password: `tourist123`

## 1. Generate JWT token
**POST** `http://localhost:8080/api/auth/login`

Request body:
```json
{
  "username": "tourist",
  "password": "tourist123"
}
```

Successful response: **200 OK**
```json
{
  "message": "JWT token generated successfully",
  "token": "<generated-jwt-token>",
  "tokenGenerated": true
}
```

Invalid credentials return **401 Unauthorized**. Unexpected server-side errors return **500 Internal Server Error**.

## 2. Update hotel details (requires JWT)
**PUT** `http://localhost:8080/api/hotels/1`

Header:
`Authorization: Bearer <generated-jwt-token>`

Request body:
```json
{
  "name": "Grand Tourist Hotel",
  "location": "Hyderabad",
  "pricePerNight": 3200
}
```

A successful update returns **200 OK**. A missing hotel returns **404 Not Found**. Requests without a valid JWT are rejected by Spring Security.

## Notes
- The hotel data is stored in memory for this lab demonstration and resets when the application restarts.
- The demo user and signing key are for classroom use only. Use a database, encoded passwords, and an external secret configuration in production.
