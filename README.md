# Employee & Address Management API

This project is a **Spring Boot** application that demonstrates a clean and flexible approach to managing `Employee` and `Address` entities using **Spring Data JPA Specifications**. It includes features such as dynamic search, pagination, sorting, and data seeding with **Java Faker**.

## Features

- **Dynamic Search with Specifications**  
  - Search Employees and Addresses with multiple optional parameters.
  - All String fields support `LIKE` queries (case-insensitive).
  - Boolean and Enum filters are supported.
  
- **Pagination & Sorting**
  - API supports pageable results with page number, page size, sort field, and sort direction.
  
- **Data Seeding**
  - Automatically populates database with sample Employees and Addresses on startup.
  - Each Employee has between 1–5 associated Addresses.
  - Uses [Java Faker](https://github.com/DiUS/java-faker) for realistic test data.
  - Ensures at least 20 Employee records exist on startup.
  
- **Cascade Relationships**
  - Employee has `@OneToMany` relationship with Address.
  - Saving Employee automatically persists associated Addresses.

- **Swagger / OpenAPI Documentation**
  - All REST endpoints are documented with Swagger annotations.
  - Optional query parameters are clearly described.
  - Supports pagination and sorting parameters in Swagger UI.

- **Error Handling**
  - Graceful handling of missing records with proper HTTP status codes.
  - Data integrity exceptions handled during save operations.

## Technology Stack

- Java 21
- Spring Boot 3.5.x
- Spring Data JPA
- Hibernate 6.x
- PostgreSQL
- Java Faker
- Swagger (OpenAPI)
- Maven / Gradle

## Entities

### Employee

- `id` (PK)
- `firstname` (String)
- `lastname` (String)
- `username` (String)
- `email` (String)
- `phoneNumber` (String)
- `nationalCode` (String)
- `salary` (BigDecimal)
- `employmentDate` (LocalDateTime)
- `createdBy` (UUID)
- `lastModifiedBy` (UUID)
- `addresses` (List\<Address\>)

### Address

- `id` (PK)
- `name` (String)
- `title` (String)
- `country` (String)
- `province` (String)
- `city` (String)
- `street` (String)
- `floor` (Integer)
- `buildingNumber` (Integer)
- `unitNumber` (Integer)
- `postalCode` (String)
- `addressType` (Enum)
- `isDefault` (Boolean)
- `createdBy` (UUID)
- `lastModifiedBy` (UUID)

## API Endpoints

### Employees

- **GET /api/v1/employee** – Retrieve all employees
- **GET /api/v1/employee/search** – Search employees with optional filters: `firstname`, `lastname`, `nationalCode`, with pagination & sorting.

### Addresses

- **GET /api/v1/address** – Retrieve all addresses
- **GET /api/v1/address/search** – Search addresses with optional filters: `city`, `province`, `postalCode`, `addressType`, `isDefault`, with pagination & sorting.

## Search Examples

```http
GET /api/v1/employee/search?firstname=John&page=0&size=5&sortBy=salary&ascending=false
GET /api/v1/address/search?city=New%20York&isDefault=true
