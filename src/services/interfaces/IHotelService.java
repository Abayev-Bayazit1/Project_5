package services.interfaces;

import models.Room;

import java.util.List;

public interface IHotelService {
    void addRoom (Room room);
    void deleteRoomById(int id);
    List<Room> getAvailableRooms(int hotelId);
}
