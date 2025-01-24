package repository;

import data.interfaces.IDB;
import models.Booking;
import repository.interfaces.IBookingRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingRepository implements IBookingRepository {
        private final IDB db;

    public BookingRepository(IDB db) {
        this.db = db;
    }


    @Override
    public boolean addBooking(Booking booking) {
        Connection connection = null;

        try{
            connection = db.getConnection();
            String sql = "INSERT INTO bookings (room_id,customer_id) VALUES (?,?)";
            PreparedStatement st = connection.prepareStatement(sql);

            st.setInt(1,booking.getRoomId());
            st.setInt(2,booking.getCustomerId());

            return st.executeUpdate()>0;


        }catch (Exception e){
            System.out.println("SQL error: " + e.getMessage());
        return false;
        }finally {
            try{
                if(connection != null){
                    connection.close();
                }
            }catch (SQLException e){
                System.out.println("failed to close connection: " + e.getMessage());
            }
        }
    }

    @Override
    public boolean deleteBooking(Booking booking) {
       Connection conn = null;

       try {
           conn = db.getConnection();
           String sql = "DELETE FROM bookings WHERE id = ?";
           PreparedStatement st = conn.prepareStatement(sql);
           st.setInt(1,booking.getId());


           return st.executeUpdate()>0;
       }catch (Exception e){
           System.out.println("SQL error: " + e.getMessage());
           return false;
       }finally {
           try{
               if(conn != null){
                   conn.close();
               }
           }catch (SQLException e){
               System.out.println("failed to close connection: " + e.getMessage());
           }
       }
    }

    @Override
    public List<Booking> getBookingsByCustomer(int customerId) {
            Connection conn = null;
            List<Booking> bookings = new ArrayList<>();

            try{
                conn = db.getConnection();
                String sql = "SELECT * FROM bookings WHERE customer_id = ?";
                PreparedStatement st = conn.prepareStatement(sql);
                st.setInt(1,customerId);

                ResultSet rs = st.executeQuery();
                while(rs.next()){
                    Booking booking = new Booking(
                    rs.getInt("id"),
                    rs.getInt("room_id"),
                    rs.getInt("customer_id")
                    );
                    bookings.add(booking);
                }

                return bookings;
            } catch (Exception e) {
                System.out.println("SQL error: " + e.getMessage());
                return List.of();
            }finally {
                try{
                    if(conn != null){
                        conn.close();
                    }
                }catch (SQLException e){
                    System.out.println("failed to close connection: " + e.getMessage());
                }
            }
      }
}