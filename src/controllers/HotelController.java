package controllers;

import controllers.interfaces.IHotelController;
import models.Hotel;
import services.HotelService;
import services.interfaces.IHotelService;

import java.util.List;

public class HotelController implements IHotelController {

    private final IHotelService hotelService;

    public HotelController(IHotelService hotelService) {  // Constructor to initialize HotelService
        this.hotelService = hotelService;
    }

    @Override
    public boolean addHotel(Hotel hotel) {
        boolean result = hotelService.addHotel(hotel); // Delegate adding a hotel to the service
        if (result) {
            System.out.println("Hotel added successfully from Controller.");
        } else {
            System.out.println("Failed to add hotel from Controller.");
        }
        return result;
    }

    @Override
    public List<Hotel> getAllHotels() {  // Delegate fetching all hotels to the service
        List<Hotel> hotels = hotelService.getAllHotels();
        if (hotels.isEmpty()) {
            System.out.println("No hotels found in Controller.");
        }
        return hotels;
    }
}