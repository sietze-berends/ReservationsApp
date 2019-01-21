package basics;

import user.Guest;

import java.time.LocalDateTime;

public class Reservation {
    private Room room;
    private LocalDateTime start;
    private LocalDateTime end;
    private Guest guest;

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

