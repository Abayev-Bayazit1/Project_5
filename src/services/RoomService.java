package services;

import models.Room;
import repository.RoomRepository;
import services.interfaces.IRoomService;
import java.util.List;



public class RoomService implements IRoomService {

    private final RoomRepository RoomRepository;

    public RoomService(RoomRepository RoomRepository) {
        this.RoomRepository = RoomRepository;
    }

    @Override
    public boolean addRoom(Room room) {
        boolean added = RoomRepository.addRoom(room);
        if (added) {
            System.out.println("Room added: " + room);
        } else {
            System.out.println("Failed to add room: " + room);
        }
        return added;
    }

    @Override
    public boolean deleteRoomById(int id) {
        boolean deleted = RoomRepository.deleteRoom(id);
        if (deleted) {
            System.out.println("Room with ID " + id + " deleted.");
        } else {
            System.out.println("Room with ID " + id + " not found.");
        }
        return deleted;
    }

    @Override
    public List<Room> getAvailableRooms(int hotelId) {
        if(hotelId <= 0){
            System.out.println("Invalid hotel ID");
            return null;
        }

        List<Room> rooms = RoomRepository.getAvailableRooms(hotelId);

        if (rooms.isEmpty()) {
            System.out.println("No rooms available for hotel " + hotelId);
        }else {
            System.out.println("Available rooms for hotel ID " + hotelId + ": " + rooms);
        }

        return rooms;
    }
}
