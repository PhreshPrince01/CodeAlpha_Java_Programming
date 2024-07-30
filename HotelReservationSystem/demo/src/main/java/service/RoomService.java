package service;

import model.Room;
import util.CsvManager;

import java.util.List;
import java.util.stream.Collectors;

public class RoomService {
    private List<Room> rooms;

    public RoomService(List<Room> rooms) {
        this.rooms = CsvManager.loadRoomsFromCsv();
    }

    public List<Room> getAvailableRooms(String type, String checkInDate, String checkOutDate) {
        // Filter rooms by type and availability
        return rooms.stream()
                .filter(room -> room.getType().equalsIgnoreCase(type) && room.isAvailable())
                .collect(Collectors.toList());
    }
    
    public Room getRoomByNumber(int roomNumber){
        for (Room room : rooms){
            if(room.getRoomNumber() == roomNumber){
                return  room;
            }
        }
        return  null;
    }
    
    public void updateRoomAvailability(int roomNumber, boolean isAvailable){
        for (Room room : rooms){
            if (room.getRoomNumber() == roomNumber){
                room.setAvailable(isAvailable);
                CsvManager.updateRoomInScsv(room);
                break;
            }
        }
    }
}
