package services.interfaces;


import models.Booking;

import java.util.List;

public interface IBookingService {
    boolean addbooking(Booking booking);
    boolean  deleteBookingsByCustomerId(int customerId);
    List<Booking> getBookingsByCustomer(int customerId);


}
