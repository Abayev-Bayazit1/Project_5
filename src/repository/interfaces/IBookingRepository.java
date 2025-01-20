package repository.interfaces;

import models.Booking;

import java.util.List;

public interface IBookingRepository {
    boolean addBooking(Booking booking);
    boolean deleteBooking(Booking booking);
    List<Booking> getBookingsByCustomer(int customerId);

}
