package basics;

import user.ExtraGuest;
import user.Guest;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * Models a reservation with some basic data
 */
public class Reservation {
    private List<Room> roomList;
    private LocalDateTime start;
    private LocalDateTime end;
    private Guest booker;
    private List<ExtraGuest> extraGuests;

    public Reservation(List<Room> room, LocalDateTime start, LocalDateTime end, Guest booker) {
        this.roomList = room;
        this.start = start;
        this.end = end;
        this.booker = booker;
        this.extraGuests = new ArrayList<>();
    }

    public void checkIn(){
        booker.setCheckedIn(true);
    }

    public void checkOut(){
        booker.setCheckedIn(false);
    }

    // date in future still needs work
    public boolean isValid() throws Exception {
        long diff = start.until(end, ChronoUnit.DAYS);
        long startDateCompare = start.until(LocalDateTime.now(), ChronoUnit.DAYS);
        if ((diff >= 1) && (this.booker != null) && (this.roomList.size() >= 1) && (startDateCompare < 0)){
            return true;
        } else {
            throw new ReservationException(this);
        }
    }

    public void addRoom(Room room) {
        this.roomList.add(room);
    }

    public void addBooker(Guest booker) {
        this.booker = booker;
    }

    public Guest getBooker() {
        return booker;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public List<Room> getRoom () {
            return roomList;
    }

    public LocalDateTime getStart () {
            return start;
    }

    public LocalDateTime getEnd () {
            return end;
    }

    public List<ExtraGuest> getExtraGuests() {
        return extraGuests;
    }

    public void addExtraGuests(ExtraGuest extraGuest) {
        extraGuests.add(extraGuest);
    }
}

