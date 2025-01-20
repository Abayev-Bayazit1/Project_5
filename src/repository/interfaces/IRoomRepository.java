package repository.interfaces;

import models.Hotel;
import models.Room;

import java.util.List;

public interface IRoomRepository {
    boolean addRoom(Room room);
    boolean deleteRoom(int id);
    Room getRoomById(int id);
    List<Hotel>getAvailableRooms(int hotelId);

}
