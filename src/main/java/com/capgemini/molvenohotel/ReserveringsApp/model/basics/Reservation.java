package com.capgemini.molvenohotel.ReserveringsApp.model.basics;

import com.capgemini.molvenohotel.ReserveringsApp.exceptions.ReservationException;
import com.capgemini.molvenohotel.ReserveringsApp.model.user.ExtraGuest;
import com.capgemini.molvenohotel.ReserveringsApp.model.user.Guest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Models a reservation with some basic data
 */

public class Reservation {
    private List<Room> roomList;
    private LocalDateTime start;
    private LocalDateTime end;
    private Guest booker;
    private List<ExtraGuest> extraGuests;
    private static AtomicInteger counter = new AtomicInteger(1000);
    private int reservationNumber;
    private int totalGuests;
    private boolean checkedIn;
    private String startStr;
    private String endStr;

    public String getStartStr() {
        return this.startStr;
    }

    public String getEndStr() {
        return this.endStr;
    }

    public Reservation(List<Room> room, LocalDateTime start, LocalDateTime end, Guest booker, List<ExtraGuest> extraGuests) {
        this.roomList = room;
        this.start = start;
        this.end = end;
        this.booker = booker;
        this.extraGuests = extraGuests;
        this.reservationNumber = counter.getAndIncrement();
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

    // checks reservation for: res >= 1 day, has a booker, has a room, and start date is in future
    public boolean isValid() throws Exception {
        long diff = this.start.until(this.end, ChronoUnit.DAYS);
        long startDateCompare = start.until(LocalDateTime.now(), ChronoUnit.DAYS);

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

    public int getBookerId(int guestId) {
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

