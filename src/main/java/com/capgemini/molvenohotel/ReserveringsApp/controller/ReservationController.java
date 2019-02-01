package com.capgemini.molvenohotel.ReserveringsApp.controller;

import com.capgemini.molvenohotel.ReserveringsApp.basics.InternetReservation;
import com.capgemini.molvenohotel.ReserveringsApp.basics.Reservation;
import com.capgemini.molvenohotel.ReserveringsApp.basics.Room;
import com.capgemini.molvenohotel.ReserveringsApp.hotel.Hotel;
import com.capgemini.molvenohotel.ReserveringsApp.hotel.InitializeHotel;

import com.capgemini.molvenohotel.ReserveringsApp.user.ExtraGuest;
import com.capgemini.molvenohotel.ReserveringsApp.user.Guest;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/hotel")
public class ReservationController {

    private InitializeHotel initializeHotel = new InitializeHotel();
    private Hotel hotel = initializeHotel.makeMolveno();

    //Gets all reservations
    @GetMapping(value = "/reservations")
    public List<Reservation> getReservations() {
        return hotel.getReservations();
    }

    @PostMapping(value = "/reservations/add")
    public List<Reservation> addReservation(@RequestBody InternetReservation internetReservation) throws Exception {
        Guest booker = hotel.getGuestByName(internetReservation.getBooker());
        String rooms[] = internetReservation.getRooms().split(",");
        List<Room> roomsList = new ArrayList<>();

        for (String room : rooms) {
            roomsList.add(hotel.getOneRoom(room));
        }

        String startString[] = internetReservation.getFrom().split("-");
        LocalDate startDate = LocalDate.of(Integer.valueOf(startString[0]), Integer.valueOf(startString[1]), Integer.valueOf(startString[2]));
        LocalTime startTime = LocalTime.of(11, 00);

        String endString[] = internetReservation.getUntil().split("-");
        LocalDate endDate = LocalDate.of(Integer.valueOf(endString[0]), Integer.valueOf(endString[1]), Integer.valueOf(endString[2]));
        LocalTime endTime = LocalTime.of(14, 00);

        LocalDateTime start = LocalDateTime.of(startDate, startTime);
        LocalDateTime end = LocalDateTime.of(endDate, endTime);

        List<ExtraGuest> extraGuests = new ArrayList<>();

        hotel.addReservation(new Reservation(roomsList, start, end, booker, extraGuests));
        return hotel.getReservations();
    }

    //Gets reservations per booker
    @GetMapping(value = "/reservation/{bookerId}")
    public List<Reservation> getReservationByBooker (@PathVariable int bookerId){
        return hotel.getAllReservationsPerBooker(bookerId);
    }
}