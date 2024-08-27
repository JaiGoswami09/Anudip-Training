# Online Banking System

## Overview

This project is an Online Banking System developed in Java, using the Data Access Object (DAO) design pattern. The application provides two main roles: **Accountant** and **Customer**. Accountants can manage customer accounts, while customers can transfer money and check transaction history.

## Features

### Accountant
- **Login**: Authenticate using a username and password.
- **Create Account**: Add new accounts for customers.
- **Update Account**: Modify existing account details.
- **Delete Account**: Remove accounts using the account number.
- **View Account Details**: View details of a specific account by providing the account number.
- **View All Accounts**: View details of all accounts.
- **Deposit/Withdraw**: Handle deposit and withdrawal transactions.

### Customer
- **Login**: Authenticate using a username and password.
- **Transfer Money**: Transfer money between accounts.
- **View Transaction History**: View the transaction history of a specific account.

## Prerequisites

Before you begin, ensure you have the following installed on your machine:
- **Java Development Kit (JDK)** (version 8 or above)
- **MySQL** (for the database)
- **MySQL Workbench** or **MySQL Command Line**
- An **IDE** such as IntelliJ IDEA, Eclipse, or NetBeans

## Database Setup

1. **Create the Database**:
    ```sql
    CREATE DATABASE banking_system;
    USE banking_system;
    ```

2. **Create Tables**:
    ```sql
    CREATE TABLE customers (
        id INT AUTO_INCREMENT PRIMARY KEY,
        username VARCHAR(50) UNIQUE NOT NULL,
        password VARCHAR(50) NOT NULL,
        name VARCHAR(100) NOT NULL
    );

    CREATE TABLE accounts (
        account_number VARCHAR(20) PRIMARY KEY,
        customer_id INT NOT NULL,
        balance DOUBLE NOT NULL,
        FOREIGN KEY (customer_id) REFERENCES customers(id)
    );

   CREATE TABLE transactions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    account_number VARCHAR(20) NOT NULL,
    amount DOUBLE NOT NULL,
    transaction_type VARCHAR(50) NOT NULL,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_number) REFERENCES accounts(account_number)
    on delete cascade
);
    ```

## Project Setup

1. **Clone or Download the Project**:
    ```bash
    git clone <repository-url>
    ```

2. **Import the Project into Your IDE**:
   - Open your IDE (IntelliJ IDEA, Eclipse, NetBeans).
   - Import the project as a Maven or Gradle project if applicable.

3. **Configure Database Connection**:
   - In the `DBConnection.java` file, update the `URL`, `USER`, and `PASSWORD` fields to match your MySQL setup:
   ```java
   private static final String URL = "jdbc:mysql://localhost:3306/bank_db";
   private static final String USER = "root"; // Your MySQL username
   private static final String PASSWORD = ""; // Your MySQL password

4. **Build the Project**:
   - Build the project using your IDE's build tools or via command line if using Maven/Gradle.
     

# Running the Application


### Step 1: Register a New Customer
1. Run the `Main.java` file.
2. Select option 2 to register a new customer.
3. Enter the required details:
   - Username
   - Password
   - Name
4. After registration, the customer details will be saved in the `customers` table.

### Step 2: Log in as Customer
1. Run the `Main.java` file again.
2. Select option 1 to log in as the newly registered customer.
3. If successful, you will be redirected to the `CustomerApp.java` interface.

### Step 3: Create Accounts (Accountant)
1. Run the `AccountantApp.java` file.
2. Select the option to create a new account for the customer.
3. Enter the following details:
   - Account number
   - Customer ID
   - Initial balance
4. Repeat the process to create additional accounts if needed.

### Step 4: Transfer Money
1. Log in as a customer through `CustomerApp.java`.
2. Select the "Transfer Money" option.
3. Enter the source and destination account numbers and the amount to transfer.
4. The system will process the transfer and update the balances.

### Step 5: View Transaction History
1. Select the option to view transaction history in `CustomerApp.java`.
2. Enter the account number to view all related transactions.

### Step 6: Manage Accounts (Accountant)
1. Log in to the `AccountantApp.java` and use the available options to:
   - Update accounts
   - Delete accounts
   - View specific or all accounts
   - Perform deposits and withdrawals


