package repository.interfaces;

import models.Booking;

import java.util.List;

public interface IBookingRepository {
    boolean addBooking(Booking booking);
    boolean deleteBookingsByCustomerId(int customerId);
    List<Booking> getBookingsByCustomer(int customerId);

}
