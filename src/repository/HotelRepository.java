package repository;

import data.interfaces.IDB;
import models.Hotel;
import repository.interfaces.IHotelRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HotelRepository implements IHotelRepository {

    private final IDB db;


    public HotelRepository(IDB db) {
        this.db = db;
    }


    @Override
    public boolean addHotel(Hotel hotel) {
        Connection conn = null;

        try{
            conn = db.getConnection();
            String sql  = "INSERT INTO hotels (name, address ) VALUES (?,?)";
            PreparedStatement st  = conn.prepareStatement(sql);
            st.setString(1,hotel.getName());
            st.setString(2, hotel.getAddress());
            return st.executeUpdate() > 0;

        }catch (Exception e){
            System.out.println("sql error " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Hotel> getAllHotels() {
        Connection conn = null;

        try{
            conn = db.getConnection();
            String sql = "SELECT * FROM hotels";
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Hotel> hotels = new ArrayList<>();
            while (rs.next()) {
                Hotel hotel = new Hotel(rs.getInt("id"),rs.getString("name"), rs.getString("address"));

                hotels.add(hotel);
            }

            return hotels;
        }catch(Exception e){
            System.out.println("sql error " + e.getMessage());
            }

    return null;
    }
}