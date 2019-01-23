package basics;

import user.Guest;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Models a reservation with some basic data
 */
public class Reservation {
    private List<Room> roomList;
    private LocalDateTime start;
    private LocalDateTime end;
    private Guest booker;

    public Reservation(List<Room> room, LocalDateTime start, LocalDateTime end, Guest booker) {
        this.roomList = room;
        this.start = start;
        this.end = end;
        this.booker = booker;
    }

     public void addRoom(Room room){
        this.roomList.add(room);
     }
    public void addBooker(Guest booker){
        this.booker = booker;
    }
    
    public List<Room> getRoom() {
        return roomList;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }
}

