# Banking Service

A RESTful Banking Service API built with Spring Boot that provides core banking functionalities including account management, deposits, withdrawals, and transaction statements.

## Features

- **Account Management**: Automatic account creation and retrieval
- **Deposit Operations**: Deposit money into accounts with date tracking
- **Withdrawal Operations**: Withdraw money with balance validation
- **Transaction History**: View detailed account statements with all transactions
- **Balance Inquiry**: Check current account balance
- **Input Validation**: Comprehensive validation for all operations
- **Exception Handling**: Global exception handling for robust error management
- **In-Memory Storage**: Uses H2 database for data persistence

## Tech Stack

- **Java 17**
- **Spring Boot 4.0.1**
- **Spring Web MVC** - REST API development
- **Spring Validation** - Input validation
- **H2 Database** - In-memory database
- **Lombok** - Reduce boilerplate code
- **Maven** - Dependency management and build tool

## Prerequisites

- Java Development Kit (JDK) 17 or higher
- Maven 3.6+ (or use the included Maven wrapper)

## Installation

1. **Clone the repository**:
```bash
git clone <repository-url>
cd Banking_Service
```

2. **Build the project**:
```bash
./mvnw clean install
```

Or on Windows:
```bash
mvnw.cmd clean install
```

## Running the Application

1. **Start the application**:
```bash
./mvnw spring-boot:run
```

Or on Windows:
```bash
mvnw.cmd spring-boot:run
```

2. The application will start on `http://localhost:8080`

## API Endpoints

### Base URL
```
http://localhost:8080/api/accounts
```

### 1. Deposit Money

**Endpoint**: `POST /api/accounts/{accountId}/deposit`

**Request Body**:
```json
{
  "amount": 1000,
  "date": "2024-01-15"
}
```

**Response**:
```json
{
  "balance": 1000,
  "message": "Deposit successful"
}
```

**Example**:
```bash
curl -X POST http://localhost:8080/api/accounts/ACC001/deposit \
  -H "Content-Type: application/json" \
  -d '{"amount": 1000, "date": "2024-01-15"}'
```

### 2. Withdraw Money

**Endpoint**: `POST /api/accounts/{accountId}/withdraw`

**Request Body**:
```json
{
  "amount": 500,
  "date": "2024-01-16"
}
```

**Response**:
```json
{
  "balance": 500,
  "message": "Withdrawal successful"
}
```

**Example**:
```bash
curl -X POST http://localhost:8080/api/accounts/ACC001/withdraw \
  -H "Content-Type: application/json" \
  -d '{"amount": 500, "date": "2024-01-16"}'
```

### 3. Get Account Statement

**Endpoint**: `GET /api/accounts/{accountId}/statement`

**Response**:
```json
{
  "statement": "Date || Amount || Balance\n2024-01-16 || -500 || 500\n2024-01-15 || 1000 || 1000\n",
  "message": null
}
```

**Example**:
```bash
curl -X GET http://localhost:8080/api/accounts/ACC001/statement
```

### 4. Get Account Balance

**Endpoint**: `GET /api/accounts/{accountId}/balance`

**Response**:
```json
{
  "balance": 500,
  "message": "Current balance"
}
```

**Example**:
```bash
curl -X GET http://localhost:8080/api/accounts/ACC001/balance
```

