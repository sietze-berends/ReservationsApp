package com.capgemini.molvenohotel.ReserveringsApp.model.basics;

import com.capgemini.molvenohotel.ReserveringsApp.model.basics.user.ExtraGuest;
import com.capgemini.molvenohotel.ReserveringsApp.model.basics.user.Guest;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Models a reservation with some basic data
 */

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany
    private List<Room> roomList;
    private LocalDateTime start;
    private LocalDateTime end;

    @OneToOne
    private Guest booker;

    @OneToMany
    private List<ExtraGuest> extraGuests;
    private int reservationNumber;
    private int totalGuests;
    private boolean checkedIn;
    private String startStr;
    private String endStr;

    public String getStartStr() {
        return startStr;
    }

    public String getEndStr() {
        return endStr;
    }
    public Reservation(){}
    public Reservation(List<Room> rooms, LocalDateTime start, LocalDateTime end, Guest booker, List<ExtraGuest> extraGuests) {
        this.roomList = rooms;
        this.start = start;
        this.end = end;
        this.booker = booker;
        this.extraGuests = extraGuests;
        this.totalGuests = 1;
        for (ExtraGuest extraGuest : extraGuests) {
            this.totalGuests++;
        }
        this.checkedIn = false;
        this.startStr = this.start.format(DateTimeFormatter.ofPattern("dd-MM-yyyy : hh:mm"));
        this.endStr = this.end.format(DateTimeFormatter.ofPattern("dd-MM-yyyy : hh:mm"));
    }

    public void addRoom(Room room) {
        this.roomList.add(room);
    }

    public void addBooker(Guest booker) {
        this.booker = booker;
    }

    public List<Room> getRooms() {
        return roomList;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public Guest getBooker() {
        return booker;
    }

    public long getBookerId(long guestId) {
        return booker.getGuestId();
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public int getTotalGuests() {
        return totalGuests;
    }

    public void setTotalGuests(int totalGuests) {
        this.totalGuests = totalGuests;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public void setBooker(Guest booker) {
        this.booker = booker;
    }

    public List<ExtraGuest> getExtraGuests() {
        return extraGuests;
    }

    public void setExtraGuests(List<ExtraGuest> extraGuests) {
        this.extraGuests = extraGuests;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", roomList=" + roomList +
                ", start=" + start +
                ", end=" + end +
                ", booker=" + booker +
                ", extraGuests=" + extraGuests +
                ", reservationNumber=" + reservationNumber +
                ", totalGuests=" + totalGuests +
                ", checkedIn=" + checkedIn +
                ", startStr='" + startStr + '\'' +
                ", endStr='" + endStr + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }
}

