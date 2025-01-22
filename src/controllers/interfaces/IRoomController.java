package controllers.interfaces;
import models.Room;
import java.util.List;



public interface IRoomController {
    boolean addRoom(Room room);
    boolean deleteRoom(int id);
    List<Room> getAvailableRooms(int hotelId);
}
