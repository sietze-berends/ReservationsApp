package com.capgemini.molvenohotel.ReserveringsApp.controller;

import com.capgemini.molvenohotel.ReserveringsApp.basics.Reservation;
import com.capgemini.molvenohotel.ReserveringsApp.hotel.BasicHotel;
import com.capgemini.molvenohotel.ReserveringsApp.hotel.Hotel;
import com.capgemini.molvenohotel.ReserveringsApp.hotel.InitializeHotel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/hotel")
public class ReservationController {

    //Gets all reservations
    @GetMapping(value = "/reservation")
    public List<Reservation> getReservations(Hotel hotel) {
        return hotel.getReservations();
    }

    //Gets reservations per booker
    @GetMapping(value = "/reservation/{bookerId}")
    public List<Reservation> getReservationByBooker (Hotel hotel, @PathVariable int bookerId){
        return hotel.getAllReservationsPerBooker(bookerId);
    }




}
