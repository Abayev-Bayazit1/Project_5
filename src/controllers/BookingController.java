package controllers;


import controllers.interfaces.IBookingController;
import models.Booking;
import repository.BookingRepository;
import services.BookingService;
import services.interfaces.IBookingService;

import java.util.List;

public class BookingController implements IBookingController {
    private final IBookingService bookingService;

    public BookingController(IBookingService bookingService) {
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
    public boolean deleteBookingsByCustomerId(int customerId) {
        return bookingService.deleteBookingsByCustomerId(customerId);
    }

}