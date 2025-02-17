package services;

import models.Room;
import repository.RoomRepository;
import repository.interfaces.IRoomRepository;
import services.interfaces.IRoomService;
import java.util.List;



public class RoomService implements IRoomService {

    private final IRoomRepository RoomRepository;

    public RoomService(IRoomRepository RoomRepository) {
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
    public boolean roomExists(int roomId) {

        return RoomRepository.roomExists(roomId);
    }

    @Override
    public List<Room> getAvailableRooms(int hotelId) {
        if (hotelId <= 0) {
            System.out.println("Invalid hotel ID");
            return List.of();
        }
        return RoomRepository.getAvailableRooms(hotelId);
    }

}