package services;

import models.Booking;
import repository.BookingRepository;
import services.interfaces.IBookingService;

import java.util.List;

public class BookingService implements IBookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
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
    public boolean deletebooking(Booking booking) {
        if (booking == null || booking.getId() == 0 ){System.out.print ("Invalid data ");return false; }
        boolean deleted = bookingRepository.deleteBooking(booking);
        if (deleted) {
            System.out.println("Booking deleted: " + booking);
        } else {
            System.out.println("Failed to delete booking: " + booking);
        }
        return deleted;
    }

    @Override
    public List<Booking> getBookingsByCustomer(int customerid) {
        if (customerid <=0){ System.out.print("Invalid custromer id ");   return List.of();   }
        List<Booking> bookings = bookingRepository.getBookingsByCustomer(customerid);

        if (bookings.isEmpty()) {
            System.out.println("No bookings found for customer ID: " + customerid);
        } else {
            System.out.println("Bookings found for customer ID: " + customerid + " -> " + bookings);
        }

        return bookings;
    }


}
