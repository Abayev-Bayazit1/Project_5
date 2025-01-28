package models;

public class Room {
    private int id;
    private int hotelID;
    private int roomNumber;
    private double price;
    private boolean isAvailable;


    public Room(int id){
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Room(int id, int hotelID, int roomNumber, double price, boolean isAvailable) {
        this.id = id;
        this.hotelID = hotelID;
        this.roomNumber = roomNumber;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public Room( int hotelID, int roomNumber, double price, Boolean isAvailable) {
        this.hotelID = hotelID;
        this.roomNumber = roomNumber;
        this.price = price;
        this.isAvailable = isAvailable;
    }
    public int getHotelID() {
        return hotelID;
    }
    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }
    public int getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Boolean getIsAvailable() {
        return isAvailable;
    }
    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    @Override
    public String toString() {
        return "ID: " + id + " HotelID: " + hotelID + " RoomNumber: " + roomNumber + " Price: " + price + " Available: " + isAvailable;
    }


}