package services.interfaces;

import models.Hotel;

import java.util.List;

public interface IHotelService {

    boolean addHotel(Hotel hotel);

    List<Hotel> getAllHotels();
}
