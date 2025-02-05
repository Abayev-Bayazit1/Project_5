package controllers;


import controllers.interfaces.IBookingController;
import models.Booking;
import repository.BookingRepository;
import services.BookingService;
import services.interfaces.IBookingService;
import services.RoomService;
import services.interfaces.IRoomService;

import java.util.List;

public class BookingController implements IBookingController {
    private final IBookingService bookingService;
    private final IRoomService roomService;


    public BookingController(IBookingService bookingService, IRoomService roomService) {
        this.roomService = roomService;
        this.bookingService = bookingService;
    }


    @Override
    public boolean bookRoom(Booking booking) {
        if(booking == null) {
            System.out.println("Booking is null");
            return false;
        }

        if(!roomService.roomExists(booking.getRoomId())){
            System.out.println("Room with ID " + booking.getRoomId() +  " does not exist");
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