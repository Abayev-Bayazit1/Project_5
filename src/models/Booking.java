package models;

public class Booking {
    private int id;
    private int roomId;
    private int customerId;

    public Booking(int id, int roomId, int customerId) {
        this.id = id;
        this.roomId = roomId;
        this.customerId = customerId;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public int getRoomId() {
        return roomId;
    }
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }


    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }


    @Override
    public String toString(){
        return "Booking: " + "id: " + id + ", roomId: " + roomId + ", customerId: " + customerId;
    }


}