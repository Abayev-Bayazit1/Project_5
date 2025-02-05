package repository.interfaces;

import models.Hotel;
import models.Room;

import java.util.List;

public interface IRoomRepository {
    boolean addRoom(Room room);
    boolean deleteRoom(int id);

    boolean roomExists(int roomId);

    List<Room>getAvailableRooms(int hotelId); //FIX List <Hotel>  --> List <Room>
}
