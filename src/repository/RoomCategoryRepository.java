package repository;

import data.interfaces.IDB;
import models.RoomCategory;
import repository.interfaces.IRoomCategoryRepository;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomCategoryRepository implements IRoomCategoryRepository {
        private final IDB db;

        public RoomCategoryRepository(IDB db) {
            this.db = db;
        }


    @Override
    public boolean addCategory(RoomCategory Category) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "INSERT INTO room_categories(name) VALUES (?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, Category.getName());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());

            return false;
        }

    }

    @Override
    public List<RoomCategory> getAllCategories() {
        List<RoomCategory> categories = new ArrayList<>();
            Connection con = null;

            try{
                con = db.getConnection();
                String sql = "SELECT * FROM room_categories";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");

                    RoomCategory category = new RoomCategory(id, name);
                    categories.add(category);
                }



            } catch (SQLException e) {
                System.out.println("SQL error: " + e.getMessage());

                return List.of();
            }

        return categories;
    }
}
