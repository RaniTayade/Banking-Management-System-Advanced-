package bank;

import java.sql.*;

public class UserDAO {

    // Authenticate user
    public boolean login(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next(); // if record exists → login success
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
