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
            Connection conn = db.getConnection();

            try{
                conn = db.getConnection();
                // execute sql request
                String sql = "INSERT INTO rooms (hotel_id, room_number, price, is_available,category_id) VALUES (?, ?, ?, ?,?)";
                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setInt(1,room.getHotelID());
                ps.setInt(2, room.getRoomNumber());
                ps.setDouble(3, room.getPrice());
                ps.setBoolean(4, room.getIsAvailable());
                ps.setInt(5,room.getCategoryId());

                return ps.executeUpdate() > 0;
            }catch (Exception e){
                System.out.println("Sql error " + e.getMessage());
                return false;
            }finally{
                try{
                    if (conn != null){
                        conn.close();
                    }
                }catch (SQLException e){
                    System.out.println("failed to connection Database " + e.getMessage());
                }
            }
        }

        @Override
        public boolean deleteRoom(int id) {
            Connection conn = null;
            PreparedStatement stmt = null;

            try {
                conn = db.getConnection();
                String sql = "DELETE FROM rooms WHERE room_id = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id);
                int affectedRows = stmt.executeUpdate();
                return affectedRows > 0;
            } catch (SQLException e) {
                System.out.println("Sql error " + e.getMessage());
                return false;
            } finally {
                try {
                    if (stmt != null) stmt.close();
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    System.out.println("failed to connection Database " + e.getMessage());
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
                String sql = "SELECT room_id, hotel_id, room_number, price, is_available " +
                        "FROM rooms WHERE hotel_id = ? AND is_available = TRUE";
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, hotelId);

                try (ResultSet resultSet = stmt.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("room_id");
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
                System.out.println("Sql error " + e.getMessage());
            } finally {
                try {
                    if (stmt != null) stmt.close();
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    System.out.println("failed to connection Database " + e.getMessage());
                }
            }

            return availableRooms;

        }
    }