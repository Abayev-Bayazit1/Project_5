import controllers.BookingController;
import controllers.HotelController;
import controllers.RoomController;
import controllers.UserController;
import data.PostgreDB;
import data.interfaces.IDB;
import repository.BookingRepository;
import repository.HotelRepository;
import repository.RoomRepository;
import repository.UserRepository;
import repository.interfaces.IBookingRepository;
import repository.interfaces.IHotelRepository;
import repository.interfaces.IRoomRepository;
import repository.interfaces.IUserRepository;
import services.BookingService;
import services.RoomService;
import services.HotelService;
import services.UserService;
import services.interfaces.IBookingService;
import services.interfaces.IHotelService;
import services.interfaces.IRoomService;
import services.interfaces.IUserService;

public class Main {
    public static void main(String[] args) {
    IDB db = new PostgreDB("jdbc:postgresql://localhost:5432", "postgres", "0000", "Booking");
        // Создание репозиториев
        IHotelRepository hotelRepository = new HotelRepository(db);
        IRoomRepository roomRepository = new RoomRepository(db);
        IBookingRepository bookingRepository = new BookingRepository(db);
        IUserRepository userRepository = new UserRepository(db);

        // Создание сервисов
        IHotelService hotelService = new HotelService(hotelRepository);
        IRoomService roomService = new RoomService(roomRepository);
        IBookingService bookingService = new BookingService(bookingRepository);
        IUserService userService = new UserService(userRepository);

        // Создание контроллеров
        HotelController hotelController = new HotelController(hotelService);
        RoomController roomController = new RoomController(roomService);
        BookingController bookingController = new BookingController(bookingService);
        UserController userController = new UserController(userService);

        // Создание и запуск приложения
        MyApplication app = new MyApplication(hotelController, bookingController, roomController, userController);
        app.start();


        try {
        db.close();
    } catch (Exception e) {
        System.out.println("Error when closing connection " + e.getMessage());
         }
    }
}