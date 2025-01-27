package controllers;


import controllers.interfaces.IBookingController;
import models.Booking;
import repository.BookingRepository;
import services.BookingService;

import java.util.List;

public class BookingController implements IBookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    @Override
    public boolean bookRoom(Booking booking) {
        if(booking == null) {
            System.out.println("Booking is null");
            return false;
        }

        return bookingService.addbooking(booking);

    }

    @Override
    public List<Booking> getBookingsByCustomer(int customerId) {

        return bookingService.getBookingsByCustomer(customerId);
    }

    @Override
    public boolean deleteBooking(Booking booking) {

        return bookingService.deletebooking(booking);
    }
}