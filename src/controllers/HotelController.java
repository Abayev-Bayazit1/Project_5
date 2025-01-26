package controllers;

import controllers.interfaces.IHotelController;
import models.Hotel;

import java.util.List;

public class HotelController implements IHotelController {
    @Override
    public boolean addHotel(Hotel hotel) {
        return false;
    }

    @Override
    public List<Hotel> getAllHotels() {
        return List.of();
    }
}