package services.interfaces;


import models.Booking;

import java.util.List;

public interface IBookingService {
    boolean addbooking(Booking booking);

    boolean deletebooking(Booking booking);
    List<Booking> getBookingsByCustomer(int customerid);


}
