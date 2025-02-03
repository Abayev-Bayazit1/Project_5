package models;

public class Room {
    private int id;
    private int hotelID;
    private int roomNumber;
    private double price;
    private boolean isAvailable;
    private int categoryId;
    private String categoryName;


    public Room(int id){
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Room(int id, int hotelID, int roomNumber, double price, boolean isAvailable, int categoryId, String categoryName) {
        this.id = id;
        this.hotelID = hotelID;
        this.roomNumber = roomNumber;
        this.price = price;
        this.isAvailable = isAvailable;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    // Геттеры и сеттеры

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


    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }


    @Override
    public String toString() {
        return "ID: " + id + " | HotelID: " + hotelID + " | Room: " + roomNumber +
                " | Price: " + price + " | Available: " + isAvailable + " | Category: " + categoryName;
    }

}