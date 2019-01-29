package com.capgemini.molvenohotel.ReserveringsApp.controller;

import com.capgemini.molvenohotel.ReserveringsApp.basics.Reservation;
import com.capgemini.molvenohotel.ReserveringsApp.hotel.BasicHotel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/hotel")
public class ReservationController {


    @GetMapping(value = "/reservation")
    public List<Reservation> getReservations(BasicHotel hotel) {
        return hotel.getReservations();
    }





}
