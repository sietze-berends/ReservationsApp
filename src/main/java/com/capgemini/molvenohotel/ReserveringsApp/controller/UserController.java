package com.capgemini.molvenohotel.ReserveringsApp.controller;

import com.capgemini.molvenohotel.ReserveringsApp.hotel.Hotel;
import com.capgemini.molvenohotel.ReserveringsApp.hotel.InitializeHotel;
import com.capgemini.molvenohotel.ReserveringsApp.user.Guest;
import com.capgemini.molvenohotel.ReserveringsApp.user.InternetGuest;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/guests/add")
    public Guest guest(@RequestBody InternetGuest guest) {
        return hotel.addGuest(guest);
    }

}
