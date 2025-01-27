package controllers.interfaces;
import models.Booking;
import java.util.List;

public interface IBookingController {

    boolean bookRoom(Booking booking);
    List<Booking> getBookingsByCustomer(int customerId);
    boolean deleteBooking(Booking booking);



}
