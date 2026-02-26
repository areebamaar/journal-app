# 📓 Journal App — Spring Boot Backend

Production-ready backend built with **Spring Boot** featuring JWT authentication, Google OAuth2 login, MongoDB Atlas persistence, Redis caching, Kafka messaging, email notifications, and external Weather API integration.

---

## 🚀 Features

* 🔐 JWT Authentication & Authorization
* 🌐 Google OAuth2 Login
* ☁️ MongoDB Atlas Database
* ⚡ Redis Caching Layer
* 📨 Kafka Producer & Consumer Integration
* 📧 Email Notification Service (SMTP)
* 🌦 Weather API Integration
* ⏰ Scheduled Background Jobs
* 📄 Swagger/OpenAPI Documentation

---

## 🧰 Tech Stack

* Java 8+
* Spring Boot
* Spring Security
* MongoDB Atlas
* Redis
* Apache Kafka
* OAuth2 Client
* JWT
* Maven

---

## 📁 Project Structure

```
src/main/java/net/areebamaar/journalApp
 ├── Config
 ├── Controller
 ├── Service
 ├── Repository
 ├── Entity
 ├── Filter
 ├── Scheduler
 └── Utilis
```

---

## ⚙️ Environment Configuration

This project uses **environment variables** for sensitive configuration.

Check `.env.example` for required variable names.

Required variables include:

MONGODB_URI
GOOGLE_CLIENT_ID
GOOGLE_CLIENT_SECRET
REDIS_HOST
REDIS_PORT
REDIS_PASSWORD
GMAIL_ID
GMAIL_PASSCODE
KAFKA_SERVER
KAFKA_CONFIG
CLIENT_ID
WEATHER_API_KEY

⚠️ Never commit real secrets to the repository.

---

## ▶️ Running the Application (Local)

1. Clone the repository

```
git clone https://github.com/areebamaar/journal-app.git
```

2. Configure environment variables in IntelliJ Run Configuration or system environment.

3. Run the application

```
mvn spring-boot:run
```

Application will start on:

```
http://localhost:8080
```

---

## 📖 API Documentation

Swagger UI:

```
http://localhost:8080/swagger-ui.html
```

---

## 🌍 Deployment

The project is designed for deployment on a VPS using environment variables for secure configuration.

---

## 👨‍💻 Author

**Areeb Amaar**
Backend Developer | Spring Boot | Java

GitHub: https://github.com/areebamaar
