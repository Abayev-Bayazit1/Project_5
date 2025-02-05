import controllers.*;
import data.PostgreDB;
import data.interfaces.IDB;
import repository.*;
import repository.interfaces.*;
import services.*;
import services.interfaces.*;
import services.interfaces.IRoomService;

public class Main {
    public static void main(String[] args) {
    IDB db = PostgreDB.getInstance("jdbc:postgresql://localhost:5432", "postgres", "0000", "Booking");
        // Создание репозиториев
        IHotelRepository hotelRepository = new HotelRepository(db);
        IRoomRepository roomRepository = new RoomRepository(db);
        IBookingRepository bookingRepository = new BookingRepository(db);
        IUserRepository userRepository = new UserRepository(db);
        IRoomCategoryRepository categoryRepository = new RoomCategoryRepository(db);

        // Создание сервисов
        IHotelService hotelService = new HotelService(hotelRepository);
        IRoomService roomService = new RoomService(roomRepository);
        IBookingService bookingService = new BookingService(bookingRepository);
        IUserService userService = new UserService(userRepository);
        IRoomCategoryService roomCategoryService = new RoomCategoryService(categoryRepository);

        // Создание контроллеров
        HotelController hotelController = new HotelController(hotelService);
        RoomController roomController = new RoomController(roomService);
        BookingController bookingController = new BookingController(bookingService,roomService);
        UserController userController = new UserController(userService);
        RoomCategoryController roomCategoryController = new RoomCategoryController(roomCategoryService);


        // Создание и запуск приложения
        MyApplication app = new MyApplication(
                hotelController,
                bookingController,
                roomController,
                userController,
                roomCategoryController);

        app.start();


        try {
            if (db.getConnection() != null && !db.getConnection().isClosed()) {
                db.close();
            }
        } catch (Exception e) {
            System.out.println("Error when closing connection " + e.getMessage());
        }

    }
}