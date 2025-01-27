package services.interfaces;

import models.Hotel;
import repository.BookingRepository;
import repository.HotelRepository;
import repository.interfaces.IHotelRepository;

import java.util.ArrayList;
import java.util.List;

public class HotelService implements IHotelRepository {
    private final List<Hotel> hotels;

    public HotelService() {
        hotels = new ArrayList<>();
    }
    @Override
    public boolean addHotel(Hotel hotel) {
        // Simulating adding a hotel to the database
        if (hotel != null) {
            hotels.add(hotel);
            return true;
        }
        return false;
    }

    @Override
    public List<Hotel> getAllHotels() {
        // Returning the list of all hotels
        return new ArrayList<>(hotels); // Return a copy to prevent modification
    }



}
