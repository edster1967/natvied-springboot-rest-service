# Spring Boot REST Service

A demonstration Spring Boot REST API application showcasing modern Java development practices with a layered architecture, JPA persistence, and containerization support.

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technology Stack](#technology-stack)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [API Documentation](#api-documentation)
- [Docker Support](#docker-support)
- [Configuration](#configuration)
- [Testing](#testing)
- [Monitoring](#monitoring)

## 🔍 Overview

This project is a Spring Boot-based RESTful web service that demonstrates best practices for building production-ready APIs. It includes a complete CRUD implementation for Product management and placeholder endpoints for Customer operations.

## ✨ Features

- **RESTful API Design**: Clean REST endpoints following HTTP conventions
- **Layered Architecture**: Separation of concerns with Controller, Service, and Repository layers
- **JPA/Hibernate Integration**: Object-relational mapping for database operations
- **H2 In-Memory Database**: Quick setup for development and testing
- **OpenAPI/Swagger UI**: Interactive API documentation
- **Spring Boot Actuator**: Application health checks and metrics
- **Docker Support**: Multi-stage Dockerfile for containerized deployment
- **Logging**: SLF4J logging with Logback configuration
- **Maven Wrapper**: No need to install Maven locally

## 🛠 Technology Stack

- **Java**: 17
- **Spring Boot**: 3.1.4
- **Spring Data JPA**: Database abstraction layer
- **H2 Database**: In-memory database for development
- **SpringDoc OpenAPI**: API documentation (v1.3.9)
- **Maven**: Build and dependency management
- **Docker**: Container support with Eclipse Temurin JDK/JRE
- **Logback**: Logging framework

## 📁 Project Structure

```
src/
├── main/
│   ├── java/com/natived/restservice/myrestapp/
│   │   ├── controllers/          # REST Controllers
│   │   │   ├── CustomerController.java
│   │   │   └── ProductController.java
│   │   ├── domain/               # Entity Models
│   │   │   └── Product.java
│   │   ├── repositories/         # Data Access Layer
│   │   │   └── ProductRepository.java
│   │   ├── services/             # Business Logic Layer
│   │   │   ├── ProductService.java
│   │   │   └── impl/
│   │   │       └── ProductServiceImpl.java
│   │   └── MyRestAppApplication.java
│   └── resources/
│       ├── application.properties
│       ├── application-local.properties
│       ├── data.sql              # Initial data script
│       └── logback.xml           # Logging configuration
└── test/
    └── java/                     # Test classes
```

## ⚙️ Prerequisites

- **Java 17** or higher
- **Maven 3.6+** (or use the included Maven wrapper)
- **Docker** (optional, for containerized deployment)

## 🚀 Getting Started

### Running Locally

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd natvied-springboot-rest-service
   ```

2. **Build the project**
   ```bash
   # Using Maven wrapper (recommended)
   ./mvnw clean package

   # Or using installed Maven
   mvn clean package
   ```

3. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```

   The application will start on `http://localhost:8080`

### Running with Docker

1. **Build the Docker image**
   ```bash
   docker build -t springboot-rest-service .
   ```

2. **Run the container**
   ```bash
   docker run -p 8080:8080 springboot-rest-service
   ```

## 🌐 API Endpoints

### Product Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/product` | Get all products |
| GET | `/product/{id}` | Get product by ID |
| POST | `/product` | Create a new product |
| PUT | `/product/{productId}` | Update an existing product |
| DELETE | `/product/{productId}` | Delete a product |

#### Example Product Request Body

```json
{
  "productDescription": "Sample Product",
  "productCost": "99.99",
  "productType": "Electronics"
}
```

### Customer Endpoints (Demo)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/customer` | Get customer (placeholder) |
| POST | `/customer` | Create customer (placeholder) |
| PUT | `/customer` | Update customer (placeholder) |
| DELETE | `/customer` | Delete customer (placeholder) |

## 📚 API Documentation

Once the application is running, you can access the interactive API documentation:

- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **OpenAPI JSON**: http://localhost:8080/v3/api-docs

## 🐳 Docker Support

The project includes a multi-stage Dockerfile for optimized container builds:

- **Stage 1 (Builder)**: Uses Eclipse Temurin JDK 17 to build the application
- **Stage 2 (Runtime)**: Uses Eclipse Temurin JRE 17 for a lightweight runtime image

This approach reduces the final image size by excluding build tools and dependencies.

## ⚙️ Configuration

### Application Profiles

The application uses Spring profiles for environment-specific configuration:

- **Default profile**: Set to `local` in `application.properties`
- **Local profile**: Configured in `application-local.properties`

### H2 Database Console

Access the H2 database console at: http://localhost:8080/h2-console

**Connection Settings:**
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: (leave empty)

### Logging

Logging is configured via `logback.xml`. Log files are stored in the `logs/` directory with automatic archiving.

## 🧪 Testing

Run the test suite:

```bash
./mvnw test
```

## 📊 Monitoring

Spring Boot Actuator endpoints are available for application monitoring:

- **Health Check**: http://localhost:8080/actuator/health
- **Application Info**: http://localhost:8080/actuator/info

Additional actuator endpoints can be enabled in the application properties.

## 🏗️ Build Information

- **Group ID**: `com.natived.restservice`
- **Artifact ID**: `my-rest-app`
- **Version**: `0.0.1-SNAPSHOT`
- **Packaging**: JAR

## 📝 Notes

- The application uses an in-memory H2 database, so data is not persisted between restarts
- Initial sample data is loaded from `data.sql` on startup
- The Customer endpoints are placeholder implementations for demonstration purposes

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is a demonstration/learning project. Please check with the repository owner for license information.

---

**Made with ☕ and Spring Boot**
