package bank;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserDAO userDao = new UserDAO();
        AccountDAO dao = new AccountDAO();

        // --- LOGIN STEP ---
        System.out.println("=== Banking System Login ===");
        System.out.print("Enter Username: ");
        String uname = sc.nextLine();
        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        if (!userDao.login(uname, pass)) {
            System.out.println("Invalid credentials. Exiting...");
            System.exit(0);
        }
        System.out.println("✅ Login successful! Welcome, " + uname);

        // --- MAIN MENU ---
        while (true) {
            System.out.println("\n=== Bank Menu ===");
            System.out.println("1. Create Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Exit");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. View Transaction History");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double bal = sc.nextDouble();
                    dao.createAccount(name, bal);
                    break;

                case 2:
                    dao.getAllAccounts().forEach(System.out::println);
                    break;

                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);

                case 4:
                    System.out.print("Enter Account No: ");
                    int accNo = sc.nextInt();
                    System.out.print("Enter Amount to Deposit: ");
                    double amount = sc.nextDouble();
                    dao.deposit(accNo, amount);
                    break;

                case 5:
                    System.out.print("Enter Account No: ");
                    int accNoW = sc.nextInt();
                    System.out.print("Enter Amount to Withdraw: ");
                    double amountW = sc.nextDouble();
                    dao.withdraw(accNoW, amountW);
                    break;

                case 6:
                    System.out.print("Enter Account No: ");
                    int accNoT = sc.nextInt();
                    showTransactions(accNoT);
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Show transactions
    private static void showTransactions(int accNo) {
        String sql = "SELECT * FROM transactions WHERE acc_no = ? ORDER BY timestamp DESC";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, accNo);
            ResultSet rs = ps.executeQuery();
            System.out.println("\n--- Transaction History ---");
            while (rs.next()) {
                System.out.println(
                        rs.getString("type") + " - " +
                                rs.getDouble("amount") + " - " +
                                rs.getTimestamp("timestamp")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
