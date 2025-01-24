package repository;
import data.interfaces.IDB;
import models.Hotel;
import models.Room;
import repository.interfaces.IRoomRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class RoomRepository implements IRoomRepository {

    private IDB db;

    public RoomRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean addRoom(Room room) {
        return false;
    }

    @Override
    public boolean deleteRoom(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = db.getConnection();
            String sql = "DELETE FROM rooms WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Hotel> getAvailableRooms(int hotelId) {
        return List.of();
    }
}