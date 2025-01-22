package controllers.interfaces;
import models.Booking;
import java.util.List;

public interface IBookingController {

    boolean BackRoom(Booking booking);

    List<Booking> getBookings();

    boolean deleteBooking(int bookingId);



}
