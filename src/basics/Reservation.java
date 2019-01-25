package basics;

import user.Guest;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * Models a reservation with some basic data
 */
public class Reservation {
    private List<Room> roomList;
    private LocalDateTime start;
    private LocalDateTime end;
    private Guest booker;
    private int reservationNumber;

    public Reservation(List<Room> room, LocalDateTime start, LocalDateTime end, Guest booker, int reservationNumber) {
        this.roomList = room;
        this.start = start;
        this.end = end;
        this.booker = booker;
        this.reservationNumber = reservationNumber;
    }

    public void addRoom(Room room) {
        this.roomList.add(room);
    }

    public void addBooker(Guest booker) {
        this.booker = booker;
    }

    public boolean isValid() throws Exception {
        long diff = start.until(end, ChronoUnit.DAYS);
        if ((diff >= 1) && (this.booker != null) && (this.roomList.size() >= 1)){
            return true;
        } else {
            throw new ReservationException(this);
        }
    }

    public List<Room> getRooms() {
            return roomList;
    }

    public LocalDateTime getStart () {
            return start;
    }

    public LocalDateTime getEnd () {
            return end;
    }

    public Guest getBooker() {
        return booker;
    }
}

