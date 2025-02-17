package services;

import models.Booking;
import repository.BookingRepository;
import repository.interfaces.IBookingRepository;
import services.interfaces.IBookingService;

import java.util.List;

public class BookingService implements IBookingService {

    private final IBookingRepository bookingRepository;

    public BookingService(IBookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public boolean addbooking(Booking booking){
        boolean added = bookingRepository.addBooking(booking);
        if(added){System.out.println("Booking added " + booking );}
        else{System.out.print("Failed to add booking  " + booking); }

        return added;
    }

    @Override
    public boolean deleteBookingsByCustomerId(int customerId) {
        return bookingRepository.deleteBookingsByCustomerId(customerId);
    }


    @Override
    public List<Booking> getBookingsByCustomer(int customerId) {
        if (customerId <=0){
            System.out.print("Invalid customer id ");   return List.of();
        }

        List<Booking> bookings = bookingRepository.getBookingsByCustomer(customerId);

        if (bookings.isEmpty()) {
            System.out.println("No bookings found for customer ID: " + customerId);
        } else {
            System.out.println("Bookings found for customer ID: ");
            for (Booking booking : bookings) {
                System.out.println(booking);
            }
        }

        return bookings;
    }



}
