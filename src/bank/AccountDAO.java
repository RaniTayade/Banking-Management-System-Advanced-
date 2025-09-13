package bank;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {

    // Create a new account
    public void createAccount(String name, double balance) {
        String sql = "INSERT INTO accounts(name, balance) VALUES(?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setDouble(2, balance);
            ps.executeUpdate();
            System.out.println("Account created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Fetch all accounts
    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT * FROM accounts";
        try (Connection con = DatabaseConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                accounts.add(new Account(
                        rs.getInt("acc_no"),
                        rs.getString("name"),
                        rs.getDouble("balance")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }

    // Deposit money into an account
    public void deposit(int accNo, double amount) {
        String sql = "UPDATE accounts SET balance = balance + ? WHERE acc_no = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDouble(1, amount);
            ps.setInt(2, accNo);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Deposit successful!");
            } else {
                System.out.println("Account not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
