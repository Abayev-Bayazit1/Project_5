package repository.interfaces;

import models.Hotel;

import java.util.List;

public interface IHotelRepository {
    boolean addHotel(Hotel hotel);
    List<Hotel> getAllHotels();
}
