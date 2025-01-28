package controllers;

import controllers.interfaces.IRoomController;
import models.Room;
import services.RoomService;
import services.interfaces.IRoomService;

import java.util.List;

public class RoomController implements IRoomController{

    private final IRoomService roomService;


public RoomController(IRoomService roomService) {
    this.roomService = roomService;
}

    @Override
    public boolean addRoom(Room room) {
        if(room == null) {
            System.out.println("Invalid room data");

            return false;
        }
// дергаем метод addroom с рум серсиса
        return roomService.addRoom(room);

    }

    @Override
    public boolean deleteRoom(int id) {
        if  (id <= 0) {
            System.out.println("Invalid room ID");
            return false;
        }

        return roomService.deleteRoomById(id);
    }

    @Override
    public List<Room> getAvailableRooms(int hotelId) {
        if(hotelId <= 0) {
            System.out.println("Invalid hotel ID");
            return List.of();
        }
        // также дергаем метод с сервисов
        List<Room> rooms = roomService.getAvailableRooms(hotelId);

        if(rooms.isEmpty()) {
            System.out.println("No rooms available with hotel ID " + hotelId);
        }

        else{
            System.out.println("Available rooms for hotel ID " + hotelId + ": " + rooms);
        }

        return rooms;

    }
}
