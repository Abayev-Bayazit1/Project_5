import controllers.BookingController;
import controllers.HotelController;
import controllers.RoomController;

import javax.xml.transform.Source;
import java.util.Scanner;

public class MyApplication {
    private final HotelController hotelController;
    private final BookingController bookingController;
    private final RoomController roomController;
    private final Scanner scanner = new Scanner(System.in);


    public MyApplication(HotelController hotelController, BookingController bookingController, RoomController roomController) {
        this.hotelController = hotelController;
        this.bookingController = bookingController;
        this.roomController = roomController;
    }

    private void mainMenu() {
        System.out.println();
        System.out.println(" Welcome to the Hotel Booking System ");
        System.out.println("Select an option:");
        System.out.println("1. Register a new hotel");
        System.out.println("2. Book a room");
        System.out.println("3. View booking history");
        System.out.println("4. Find available rooms");
        System.out.println("5. Delete room");
        System.out.println("6. Add room");
        System.out.println("7. View all hotels");
        System.out.println("0. Exit");
        System.out.println();
        System.out.print("Enter option (1-7): ");

    }

}
