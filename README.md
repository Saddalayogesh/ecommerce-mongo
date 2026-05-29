# 🛒 Ecommerce MongoDB REST API

A Spring Boot REST API project for managing customers in an E-Commerce application using MongoDB.

---

## ✨ Features

- 👤 Customer Registration
- 🔐 Customer Login
- 📋 Get All Customers
- 🔍 Get Customer By ID
- ✏️ Update Customer
- 🗑️ Delete Customer
- 🍃 MongoDB Integration
- 🌐 REST API Architecture
- 📦 DTO Layer
- ⚠️ Exception Handling
- 🔄 ModelMapper Integration

---

## 🛠️ Technologies Used

- ☕ Java
- 🚀 Spring Boot
- 🌐 Spring Web
- 🍃 Spring Data MongoDB
- 🗄️ MongoDB
- 🧭 MongoDB Compass
- ⚡ Lombok
- 📦 Maven
- 🔄 ModelMapper
- 📮 Postman
- 🐙 Git & GitHub

---

## 📁 Project Structure

```text
src/main/java
│
├── controller
├── service
├── repository
├── document
├── dto
├── enums
├── exceptions
└── config
```

---

## 🔗 API Endpoints

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/api/customers` | Register Customer |
| POST | `/api/customers/login` | Customer Login |
| GET | `/api/customers` | Get All Customers |
| GET | `/api/customers/{id}` | Get Customer By ID |
| PUT | `/api/customers/{id}` | Update Customer |
| DELETE | `/api/customers/{id}` | Delete Customer |

---

## 📝 Sample Request Body

### Register Customer

```json
{
  "name": "Yogesh",
  "email": "yogesh@gmail.com",
  "password": "12345",
  "phone": "9876543210",
  "gender": "MALE",
  "addresses": [
    {
      "street": "MG Road",
      "city": "Hyderabad",
      "state": "Telangana",
      "country": "India",
      "pincode": "500001"
    }
  ]
}
```

---

## ⚙️ MongoDB Configuration

Add the following configuration in `application.properties`

```properties
spring.application.name=ecommerce-mongo

spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=ecommerce_mongo
```

---

## 🍃 MongoDB Setup

1. Install MongoDB Community Server
2. Install MongoDB Compass
3. Start MongoDB Service
4. Create Database: `ecommerce_mongo`
5. Run Spring Boot Application

---

## ▶️ Run the Project

### Clone Repository

```bash
git clone https://github.com/SaddalaYogesh/ecommerce-mongo.git
```

### Navigate to Project

```bash
cd ecommerce-mongo
```

### Run Application

```bash
mvn spring-boot:run
```

---

## 🌍 Server URL

```text
http://localhost:8080
```

---

## 🧪 Testing

Use Postman to test all REST APIs.

---

## ✅ Sample Success Response

```json
{
  "id": "6850ab12cd34",
  "name": "Yogesh",
  "email": "yogesh@gmail.com",
  "phone": "9876543210",
  "gender": "MALE"
}
```

---

## 👨‍💻 Author

**Saddala Yogesh**
