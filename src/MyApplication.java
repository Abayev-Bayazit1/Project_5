import controllers.BookingController;
import controllers.HotelController;
import controllers.RoomController;
import models.Booking;
import models.Hotel;
import models.Room;

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


    public void start() {
        while (true) {

            mainMenu();
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> registerHotel();
                case 2 -> bookRoom();
                case 3 -> viewBookingHistory();
                case 4 -> findAvailableRooms();
                case 5 -> deleteRoom();
                case 6 -> addRoom();
                case 7 -> viewAllHotels();
                case 0 -> {
                    System.out.println("Exiting application...");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void registerHotel() {
        System.out.print("Enter hotel name: ");
        String hotelName = scanner.nextLine();
        System.out.print("Enter hotel address: ");
        String hotelAddress = scanner.nextLine();

        Hotel hotel = new Hotel(0, hotelName, hotelAddress);
        boolean result = hotelController.addHotel(hotel);

        if (result) {
            System.out.println("Hotel added successfully!");
        } else {
            System.out.println("Failed to add hotel.");
        }

    }


    private void bookRoom(){
        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();
        System.out.print("Enter room ID: ");
        int roomId = scanner.nextInt();

        Booking booking = new Booking(0, roomId, customerId);

        // Вызываем метод контроллера с объектом Booking
        boolean result = bookingController.bookRoom(booking);

        if (result) {
            System.out.println("Room booked successfully!");
        } else {
            System.out.println("Failed to book room.");
        }
    }

    private void viewBookingHistory() {
        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();
        System.out.println(bookingController.getBookingsByCustomer(customerId));
    }

    private void findAvailableRooms() {
        System.out.println("Enter hotel ID: ");
        int hotelId = scanner.nextInt();
        System.out.println(roomController.getAvailableRooms(hotelId));
    }

    private void deleteRoom() {
        System.out.print("Enter room ID to delete: ");
        int roomId = scanner.nextInt();
        System.out.println(roomController.deleteRoom(roomId));
    }

    private void addRoom(){
        System.out.println("Enter room number: ");
        int roomNumber = scanner.nextInt();
        System.out.println("Enter hotel ID: ");
        int hotelId = scanner.nextInt();
        System.out.println("Enter room price");
        double roomPrice = scanner.nextDouble();

        Room room = new Room(0, hotelId, roomNumber, roomPrice, true);

        System.out.println(roomController.addRoom(room));
    }




    private void viewAllHotels() {
        System.out.println(hotelController.getAllHotels());
    }


}
