import controllers.BookingController;
import controllers.HotelController;
import controllers.RoomController;
import controllers.UserController;
import models.Booking;
import models.Hotel;
import models.Room;
import models.User;

import javax.xml.transform.Source;
import java.util.Scanner;

public class MyApplication {
    private final HotelController hotelController;
    private final BookingController bookingController;
    private final RoomController roomController;
    private final UserController userController;
    private final Scanner scanner = new Scanner(System.in);
    private User currentUser;

    public MyApplication(HotelController hotelController, BookingController bookingController, RoomController roomController, UserController userController) {
        this.hotelController = hotelController;
        this.bookingController = bookingController;
        this.roomController = roomController;
        this.userController = userController;
    }

    private void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        currentUser = userController.login(username, password);

        if (currentUser != null) {
            System.out.println("Logged in as: " + currentUser.getUsername() + " (" + currentUser.getRole() + ")");
        } else {
            System.out.println("Login failed. Invalid username or password.");
        }
    }

    private void register() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter role (admin/user): ");
        String role = scanner.nextLine();

        User newUser = new User(0, username, password, role);
        boolean result = userController.register(newUser);

        if (result) {
            System.out.println("User registered successfully!");
        } else {
            System.out.println("Failed to register user.");
        }
    }

    public void start() {
        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("0. Exit");
            System.out.print("Enter option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> login();
                case 2 -> register();
                case 0 -> {
                    System.out.println("Exiting application...");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }

            if (currentUser != null) {
                mainMenu();
            }
        }
    }



    private void mainMenu() {
        while (true) {
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

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> {
                    if (currentUser.getRole().equals("admin")) {
                        registerHotel();
                    } else {
                        System.out.println("Access denied: Only admins can register hotels.");
                    }
                }
                case 2 -> bookRoom();
                case 3 -> viewBookingHistory();
                case 4 -> findAvailableRooms();
                case 5 -> {
                    if (currentUser.getRole().equals("admin")) {
                        deleteRoom();
                    } else {
                        System.out.println("Access denied: Only admins can delete rooms.");
                    }
                }
                case 6 -> {
                    if (currentUser.getRole().equals("admin")) {
                        addRoom();
                    } else {
                        System.out.println("Access denied: Only admins can add rooms.");
                    }
                }
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

    private void bookRoom() {
        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();
        System.out.print("Enter room ID: ");
        int roomId = scanner.nextInt();

        Booking booking = new Booking(0, roomId, customerId);
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
        boolean result = roomController.deleteRoom(roomId);

        if (result) {
            System.out.println("Room deleted successfully!");
        } else {
            System.out.println("Failed to delete room.");
        }
    }

    private void addRoom() {
        System.out.println("Enter room number: ");
        int roomNumber = scanner.nextInt();
        System.out.println("Enter hotel ID: ");
        int hotelId = scanner.nextInt();
        System.out.println("Enter room price: ");
        double roomPrice = scanner.nextDouble();

        Room room = new Room(0, hotelId, roomNumber, roomPrice, true);
        boolean result = roomController.addRoom(room);

        if (result) {
            System.out.println("Room added successfully!");
        } else {
            System.out.println("Failed to add room.");
        }
    }

    private void viewAllHotels() {
        System.out.println(hotelController.getAllHotels());
    }
}
