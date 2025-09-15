#  Banking Management System (Java + MySQL)

A simple **Bank Management System** built using **Java, JDBC, and MySQL**.  
This project was developed as part of an academic learning exercise to practice Java, JDBC, and database integration.  

##  Features
-  **User Login System** (Authentication using MySQL `users` table)  
-  **Account Management**
  - Create new bank accounts  
  - View all accounts  
-  **Transactions**
  - Deposit money  
  - Withdraw money (with balance check)  
  - Transaction history (records stored in MySQL)  
- 🗄 **Database Integration** using JDBC  

##  Technologies Used
- **Java (JDK 8+)** – Core logic  
- **JDBC** – Database connectivity  
- **MySQL** – Database for accounts, users, transactions  
- **MySQL Workbench** – Query management
- 

##  Project Structure
banking-management-system/
│
├── src/bank/
│ ├── Main.java # Main program with menu
│ ├── DatabaseConnection.java # JDBC connection utility
│ ├── Account.java # Account model (POJO)
│ ├── AccountDAO.java # Data Access Object for accounts
│ ├── UserDAO.java # Data Access Object for user login
│
└── README.md # Project documentation


##  Database Setup
Run the following script in **MySQL Workbench**:

```sql
-- Create database
CREATE DATABASE IF NOT EXISTS bankdb;
USE bankdb;

-- Accounts table
CREATE TABLE IF NOT EXISTS accounts (
    acc_no INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    balance DOUBLE DEFAULT 0
);

-- Transactions table
CREATE TABLE IF NOT EXISTS transactions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    acc_no INT,
    type VARCHAR(20),
    amount DOUBLE,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (acc_no) REFERENCES accounts(acc_no)
);

-- Users table
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE,
    password VARCHAR(100) NOT NULL
);

-- Insert default user
INSERT INTO users (username, password) VALUES ('admin', 'admin123');

## How to Run
Clone or download this repository.
Import the project into your Java IDE (Eclipse, IntelliJ, or NetBeans).
Update DatabaseConnection.java with your MySQL username & password:

java
private static final String URL = "jdbc:mysql://localhost:3306/bankdb";
private static final String USER = "root";
private static final String PASSWORD = "root"; // change if needed
Run Main.java.
Login with default credentials:
makefile
Username: admin
Password: admin123

Sample Menu
=== Banking System Login ===
Enter Username: admin
Enter Password: admin123
Login successful! Welcome, admin

=== Bank Menu ===
1. Create Account
2. View All Accounts
3. Exit
4. Deposit
5. Withdraw
6. View Transaction History
 Future Enhancements
 Secure password hashing (BCrypt)

## User Registration (sign up new users)
 Loan Management module
 Role-based access (Admin vs User)
 Better console UI

## Author
Rani Tayade
Full Stack Java Developer Intern
