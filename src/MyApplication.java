import controllers.*;
import models.*;
import repository.interfaces.IRoomCategoryRepository;

import javax.xml.transform.Source;
import java.util.List;
import java.util.Scanner;

public class MyApplication {
    private final HotelController hotelController;
    private final BookingController bookingController;
    private final RoomController roomController;
    private final UserController userController;
    private final RoomCategoryController roomCategoryController;
    private final Scanner scanner = new Scanner(System.in);
    private User currentUser;

    public MyApplication(HotelController hotelController, BookingController bookingController,
                         RoomController roomController,
                         UserController userController,
                         RoomCategoryController roomCategoryController) {

        this.hotelController = hotelController;
        this.bookingController = bookingController;
        this.roomController = roomController;
        this.userController = userController;
        this.roomCategoryController = roomCategoryController;

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
            System.out.println("\nWelcome to the Hotel Booking System");
            System.out.println("Select an option:");

            // Общиефункции для всех пользователеуй
            System.out.println("1. Book a room");
            System.out.println("2. View booking history");
            System.out.println("3. Find available rooms");
            System.out.println("4. View all hotels");

            // Функции только для админа
            if (currentUser.getRole().equals("admin")) {
                System.out.println("5. Register a new hotel");
                System.out.println("6. Add room");
                System.out.println("7. Delete room");
                System.out.println("8. Admin Panel");
            }

            System.out.println("0. Logout");

            System.out.print("\nEnter option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> bookRoom();
                case 2 -> viewBookingHistory();
                case 3 -> findAvailableRooms();
                case 4 -> viewAllHotels();

                // Проверяем, является ли пользователь админом перед выполнением этих функций
                case 5 -> {
                    if (isAdmin()) registerHotel();
                    else accessDenied();
                }
                case 6 -> {
                    if (isAdmin()) addRoom();
                    else accessDenied();
                }
                case 7 -> {
                    if (isAdmin()) deleteRoom();
                    else accessDenied();
                }
                case 8 -> {
                    if (isAdmin()) adminMenu();
                    else accessDenied();
                }
                case 0 -> {
                    System.out.println("Logging out...");
                    currentUser = null; // Очищаем текущего пользователя
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private boolean isAdmin() {
        return currentUser != null && currentUser.getRole().equals("admin");
    }

    private void accessDenied() {
        System.out.println("Access denied: You don't have permission to perform this action.");
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
        System.out.print("Enter hotel ID: ");
        int hotelId = scanner.nextInt();
        List<Room> availableRooms = roomController.getAvailableRooms(hotelId);

        if (availableRooms.isEmpty()) {
            System.out.println("No rooms available with hotel ID " + hotelId);
        } else {
            System.out.println("Available rooms for hotel ID " + hotelId + ":");
            for (Room room : availableRooms) {
                System.out.println(room);
            }
        }
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

    private void adminMenu() {
        while (true) {
            System.out.println("\nAdmin Panel:");
            System.out.println("1. Add Category");
            System.out.println("2. View Categories");
            System.out.println("3. Delete All Bookings for a Customer");
            System.out.println("0. Back");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addCategory();
                case 2 -> viewCategories();
                case 3 -> deleteBookingsByCustomerId();
                case 0 -> { return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }


    private void addCategory() {
        System.out.print("Enter category name: ");
        String name = scanner.nextLine();
        RoomCategory category = new RoomCategory(0, name);

        boolean added = roomCategoryController.addCategory(category);

        if (added) {
            System.out.println("Category added successfully.");
        } else {
            System.out.println("Failed to add category.");
        }
    }

    private void viewCategories() {
        List<RoomCategory> categories = roomCategoryController.getAllCategories();

        if (categories.isEmpty()) {
            System.out.println("No categories available.");
        } else {
            System.out.println("Available room categories:");
            categories.forEach(category ->
                    System.out.println("ID: " + category.getId() + " | Name: " + category.getName())
            );
        }
    }


    private void addRoom() {
        if (!isAdmin()) {
            accessDenied();
            return;
        }

        // Показать доступные категории
        System.out.println("\nAvailable categories:");
        List<RoomCategory> categories = roomCategoryController.getAllCategories();
        categories.forEach(category ->
                System.out.println("ID: " + category.getId() + " | Name: " + category.getName())
        );

        // Ввод данных
        System.out.print("\nEnter room number: ");
        int roomNumber = scanner.nextInt();
        System.out.print("Enter hotel ID: ");
        int hotelId = scanner.nextInt();
        System.out.print("Enter room price: ");
        double roomPrice = scanner.nextDouble();
        System.out.print("Enter category ID: ");
        int categoryId = scanner.nextInt();

        // Проверка существования категории
        boolean categoryExists = categories.stream()
                .anyMatch(c -> c.getId() == categoryId);

        if (!categoryExists) {
            System.out.println("Error: Category ID " + categoryId + " does not exist.");
            return;
        }

        //String categoryName = categories.get(categoryId).getName();

        // Получаем название категории
        String categoryName = categories.stream()
                .filter(c -> c.getId() == categoryId)
                .findFirst()
                .map(RoomCategory::getName)
                .orElse("Unknown");

        Room room = new Room(0, hotelId, roomNumber, roomPrice, true, categoryId, categoryName);
        boolean result = roomController.addRoom(room);


        if (result) {
            System.out.println("Room added successfully!");
        } else {
            System.out.println("Failed to add room.");
        }
    }

    private void deleteBookingsByCustomerId() {
        if (!isAdmin()) {
            accessDenied();
            return;
        }

        System.out.print("Enter Customer ID to delete all bookings: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Are you sure you want to delete all bookings for Customer ID " + customerId + "? (yes/no): ");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("yes")) {
            boolean result = bookingController.deleteBookingsByCustomerId(customerId);
            if (result) {
                System.out.println("All bookings for Customer ID " + customerId + " have been deleted.");
            } else {
                System.out.println("No bookings found or failed to delete.");
            }
        } else {
            System.out.println("Operation canceled.");
        }
    }


    private void viewAllHotels() {
        System.out.println(hotelController.getAllHotels());
    }


}
