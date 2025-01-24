package repository;
import data.interfaces.IDB;
import models.Hotel;
import models.Room;
import repository.interfaces.IRoomRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public List<Room> getAvailableRooms(int hotelId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        List<Room> availableRooms = new ArrayList<>();

        try {
            conn = db.getConnection();
            String sql = "SELECT id, hotel_id, room_number, price, is_available " +
                    "FROM rooms WHERE hotel_id = ? AND is_available = TRUE";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, hotelId);

            try (ResultSet resultSet = stmt.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    int hotelID = resultSet.getInt("hotel_id");
                    int roomNumber = resultSet.getInt("room_number");
                    double price = resultSet.getDouble("price");
                    boolean isAvailable = resultSet.getBoolean("is_available");

                    // Создаем объект Room и добавляем его в список
                    Room room = new Room(id);
                    room.setHotelID(hotelID);
                    room.setRoomNumber(roomNumber);
                    room.setPrice(price);
                    room.setIsAvailable(isAvailable);

                    availableRooms.add(room);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return availableRooms;

    }
}