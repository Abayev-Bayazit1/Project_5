package services.interfaces;

import models.Room;

import java.util.List;

public interface IRoomService {
    boolean addRoom (Room room);
    boolean deleteRoomById(int id);
    List<Room> getAvailableRooms(int hotelId);
}
