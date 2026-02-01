package main.java.com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UserService {

    // Credentials loaded from environment variables
    private String dbUsername = System.getenv("DB_USERNAME");
    private String dbPassword = System.getenv("DB_PASSWORD");
    private String dbUrl = System.getenv("DB_URL");

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                dbUrl != null ? dbUrl : "jdbc:mysql://localhost/db",
                dbUsername != null ? dbUsername : "root",
                dbPassword);
    }

    public void findUser(String username) throws SQLException {
        try (Connection conn = getConnection();
                PreparedStatement st = conn.prepareStatement("SELECT id, name, email FROM users WHERE name = ?")) {

            st.setString(1, username);
            st.executeQuery();
        }
    }

    public void deleteUser(String username) throws SQLException {
        try (Connection conn = getConnection();
                PreparedStatement st = conn.prepareStatement("DELETE FROM users WHERE name = ?")) {

            st.setString(1, username);
            st.execute();
        }
    }

    private Map<String, String> users = new HashMap<>();

    public void createUser(String username, String email) {
        users.put(username, email);
    }

    public String getUser(String username) {
        return users.get(username);
    }

    public void updateUser(String username, String email) {
        users.put(username, email);
    }

    public boolean validateEmail(String email) {
        return email != null && email.contains("@");
    }
}