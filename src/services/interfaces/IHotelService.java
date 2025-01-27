package services.interfaces;

import models.Hotel;
import models.Room;

import java.util.List;

public interface IHotelService {
    boolean addHotel(Hotel hotel); // add hotel

    boolean deleteHotel(int id); // delete hotel by id

    Hotel getHotelById(int id); // Retrieves a Hotel object by the given identifier    List<Hotel> getAllHotels();


    List<Room> getAvailableRooms(int hotelId); // Returns a list of available rooms (Room) for a hotel with the specified identifier.

}
