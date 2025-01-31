package services;

import models.Hotel;
import repository.interfaces.IHotelRepository;
import services.interfaces.IHotelService;

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
        return hotelRepository.getAllHotels();
    }
}
