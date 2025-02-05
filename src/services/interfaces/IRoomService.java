package services.interfaces;

import models.Room;

import java.util.List;

public interface IRoomService {
    boolean addRoom (Room room);
    boolean deleteRoomById(int id);

    boolean roomExists(int roomId);

    List<Room> getAvailableRooms(int hotelId);
}
