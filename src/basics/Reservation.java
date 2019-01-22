package basics;

import user.Guest;

import java.time.LocalDateTime;

/**
 * Models a reservation with some basic data
 */
public class Reservation {
    private Room room;
    private LocalDateTime start;
    private LocalDateTime end;
    private Guest guest;

    public Reservation(Room room, LocalDateTime start, LocalDateTime end, Guest guest) {
        this.room = room;
        this.start = start;
        this.end = end;
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }
}

