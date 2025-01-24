package services;


import models.Room;
import services.interfaces.IHotelService;


import java.util.ArrayList;
import java.util.List;

public class HotelService implements IHotelService {

    private final List<Room> rooms;

    public HotelService() {
        this.rooms = new ArrayList<>();
    }

    @Override
    public void addRoom(Room room) {
        rooms.add(room);
        System.out.println("Room added: " + room);
    }

    @Override
    public Room getRoomById(int id) {
        for (Room room : rooms) {
            if (room.getId() == id) {
                return room;
            }
        }
        System.out.println("Room with ID " + id + " not found.");
        return null;
    }


    @Override
    public List<Room> getAllRooms() {
        return new ArrayList<>(rooms);
    }

    @Override
    public void deleteRoomById(int id) {
        Room roomToDelete = null;
        for (Room room : rooms) {
            if (room.getId() == id) {
                roomToDelete = room;
                break;
            }
        }
        if (roomToDelete != null) {
            rooms.remove(roomToDelete);
            System.out.println("Room with ID " + id + " deleted.");
        } else {
            System.out.println("Room with ID " + id + " not found.");
        }
    }

    @Override
    public List<Room> getAvailableRooms(int hotelId) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getHotelID() == hotelId && room.getIsAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }
}