package com.capgemini.molvenohotel.ReserveringsApp.model.basics;

import com.capgemini.molvenohotel.ReserveringsApp.exceptions.ReservationException;
import com.capgemini.molvenohotel.ReserveringsApp.model.user.ExtraGuest;
import com.capgemini.molvenohotel.ReserveringsApp.model.user.Guest;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * Models a reservation with some basic data
 */

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public Reservation(int reservationNumber, List<Room> room, LocalDateTime start, LocalDateTime end, Guest booker, List<ExtraGuest> extraGuests) {
        this.roomList = room;
        this.start = start;
        this.end = end;
        this.booker = booker;
        this.extraGuests = extraGuests;
        this.totalGuests = 1;
        for (ExtraGuest extraGuest : extraGuests) {
            this.totalGuests++;
        }
        this.reservationNumber = reservationNumber;
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

    // checks reservation for: res >= 1 day, has a booker, has a room, and start date is in future
    public boolean isValid() throws Exception {
        long diff = this.start.until(this.end, ChronoUnit.DAYS);
        long startDateCompare = this.start.until(LocalDateTime.now(), ChronoUnit.DAYS);
        if ((diff >= 1) && (this.booker != null) && (this.roomList.size() >= 1) && (startDateCompare <= 0)) {
            return true;
        } else {
            throw new ReservationException(this);
        }
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
}

