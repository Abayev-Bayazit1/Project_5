package services.interfaces;

import models.Hotel;
import repository.interfaces.IHotelRepository;

import java.util.List;

public class HotelService implements IHotelService {
    private final IHotelRepository hotelRepository;

    public HotelService(IHotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public boolean addHotel(Hotel hotel) {
        if (hotel == null || hotel.getName() == null || hotel.getAddress() == null) { // Checking the validity of the hotel data
            System.out.println("Invalid hotel data");
            return false;
        }


        boolean result = hotelRepository.addHotel(hotel); // Calling the method from the repository


        if (result) { // Output the result
            System.out.println("Hotel added successfully");
        } else {
            System.out.println("Failed to add hotel");
        }

        return result;
    }

    @Override
    public List<Hotel> getAllHotels() {
        List<Hotel> hotels = hotelRepository.getAllHotels(); // Getting a list of hotels from the repository
        if (hotels.isEmpty()) { // Check if the list is empty and display the message
            System.out.println("No hotels found");
        }

        return hotels;
    }
}
