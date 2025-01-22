package controllers.interfaces;

import models.Hotel;

import java.util.List;

public interface IHotelController {
    boolean addHotel(Hotel hotel); //register new hotel
    List<Hotel> getAllHotels(); //получаем все отели
}
