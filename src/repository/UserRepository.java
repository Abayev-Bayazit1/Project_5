package repository;

import data.interfaces.IDB;
import models.User;
import repository.interfaces.IUserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserRepository implements IUserRepository {
    private final IDB db;

    public UserRepository(IDB db) {
        this.db = db;
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        Connection conn = null;

        try {
            conn = db.getConnection();
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role")
                );
            }
        } catch (Exception e) {
            System.out.println("SQL error: " + e.getMessage());
        }

        return null;
    }

    @Override
    public boolean addUser(User user) {
        Connection conn = null;

        try {
            conn = db.getConnection();
            String sql = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, user.getUsername());
            st.setString(2, user.getPassword());
            st.setString(3, user.getRole());

            return st.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("SQL error: " + e.getMessage());

            return false;
        }
    }
}
