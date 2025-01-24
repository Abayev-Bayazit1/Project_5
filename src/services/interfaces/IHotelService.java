package services.interfaces;

import models.Room;

import java.util.List;

public interface IHotelService {
    void addRoom (Room room);
    Room getRoomById (int id);
    List<Room> getAllRooms();
    void deleteRoomById(int id);
    List<Room> getAvailableRooms(int hotelId);
}
