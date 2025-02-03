package controllers.interfaces;
import models.Booking;
import java.util.List;

public interface IBookingController {

    boolean bookRoom(Booking booking);
    List<Booking> getBookingsByCustomer(int customerId);
    boolean deleteBookingsByCustomerId(int customerId);



}
