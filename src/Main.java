import data.PostgreDB;
import data.interfaces.IDB;
import repository.HotelRepository;
import repository.interfaces.IHotelRepository;

public class Main {
    public static void main(String[] args) {
    IDB db = new PostgreDB("jdbc:postgresql://localhost:5432", "postgres", "0000", "Booking");
   // IHotelRepository repo = new HotelRepository(db);




    db.close();
    }
}