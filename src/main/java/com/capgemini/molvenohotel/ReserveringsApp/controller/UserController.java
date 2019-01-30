package com.capgemini.molvenohotel.ReserveringsApp.controller;

import com.capgemini.molvenohotel.ReserveringsApp.basics.Room;
import com.capgemini.molvenohotel.ReserveringsApp.hotel.Hotel;
import com.capgemini.molvenohotel.ReserveringsApp.hotel.InitializeHotel;
import com.capgemini.molvenohotel.ReserveringsApp.user.Guest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/hotel")
public class UserController {
    private InitializeHotel initializeHotel = new InitializeHotel();
    private Hotel hotel = initializeHotel.makeMolveno();

    @GetMapping(value = "/guests")
    public List<Guest> getAllGuests() {
        return hotel.getGuests();
    }

}
