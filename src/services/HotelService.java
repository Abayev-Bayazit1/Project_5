package services;

import models.Room;
import repository.RoomRepository;
import services.interfaces.IHotelService;
import java.util.List;



public class HotelService implements IHotelService {

    private final RoomRepository RoomRepository;

    public HotelService(RoomRepository RoomRepository) {
        this.RoomRepository = RoomRepository;
    }

    @Override
    public void addRoom(Room room) {
        boolean added = RoomRepository.addRoom(room);
        if (added) {
            System.out.println("Room added: " + room);
        } else {
            System.out.println("Failed to add room: " + room);
        }
    }

    @Override
    public void deleteRoomById(int id) {
        boolean deleted = RoomRepository.deleteRoom(id);
        if (deleted) {
            System.out.println("Room with ID " + id + " deleted.");
        } else {
            System.out.println("Room with ID " + id + " not found.");
        }
    }

    @Override
    public List<Room> getAvailableRooms(int hotelId) {
        return RoomRepository.getAvailableRooms(hotelId);
    }
}
