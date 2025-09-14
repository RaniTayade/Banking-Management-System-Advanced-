#  Banking Management System (Java + MySQL)

##  Project Overview
This is a **Banking Management System** built using **Java, JDBC, and MySQL**.  
It is designed as a **learning + academic project** to understand how Java applications can interact with relational databases.
The system currently supports **account creation, deposit, and account viewing**, with upcoming features such as **withdrawals, login, transaction history, and loan management**.


##  Features
### Completed
- Create new bank accounts  
- View all existing accounts in the database  
- Deposit money into an account  


### Coming Soon
- Withdraw money from an account  
- Transaction history (each deposit/withdrawal logged)  
- Secure login system (username & password)  
- Loan management (apply, approve, track loans)  
- Admin dashboard (manage all accounts)  


##  Tech Stack
- **Language:** Java (JDK 8+)  
- **Database:** MySQL  
- **Connectivity:** JDBC  
- **IDE (optional):** IntelliJ IDEA / Eclipse / NetBeans  
- **Version Control:** Git & GitHub  


##  Project Structure
Banking-Management-System/
│── src/
│ └── bank/
│ ├── Main.java # Entry point with menu system
│ ├── DatabaseConnection.java # Manages DB connection
│ ├── Account.java # Model class (POJO)
│ └── AccountDAO.java # Data Access Object (CRUD + deposit)
│
└── README.md


##  Database Setup
1. Open **MySQL Workbench** (or terminal).  
2. Run the following SQL commands:
   ```sql
   CREATE DATABASE bankdb;

   USE bankdb;

   CREATE TABLE accounts (
       acc_no INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(100) NOT NULL,
       balance DOUBLE DEFAULT 0
   );
Update your DB credentials in DatabaseConnection.java:
java
private static final String URL = "jdbc:mysql://localhost:3306/bankdb";
private static final String USER = "root";     
private static final String PASSWORD = "root"; 


## How to Run
Clone this repository:
bash
git clone https://github.com/your-username/Banking-Management-System.git
Open project in IntelliJ/Eclipse/NetBeans.
Make sure MySQL server is running.
Compile & run Main.java.
You’ll see menu options:
markdown
=== Bank Menu ===
1. Create Account
2. View All Accounts
3. Exit
4. Deposit


## Commit History (Planned)
Commit 1: Setup project structure
Commit 2: Add Account model class
Commit 3: Add DB connection helper
Commit 4: Add AccountDAO with create & fetch
Commit 5: Update Main.java with menu options
Commit 6: Add deposit method in DAO
Commit 7: Integrate deposit option in menu
Commit 8+: Withdraw, login, history, loans


## Contribution
Want to improve this project?
Fork the repo
Create a new branch
Add your feature/fix
Submit a Pull Request 


## Author
Rani Tayade


## License
This project is for educational purposes only.
You are free to use and modify it.
