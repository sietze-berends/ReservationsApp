package com.capgemini.molvenohotel.ReserveringsApp.controller;

import com.capgemini.molvenohotel.ReserveringsApp.initializer.InitializeHotel;
import com.capgemini.molvenohotel.ReserveringsApp.model.basics.Hotel;
import com.capgemini.molvenohotel.ReserveringsApp.model.basics.user.Guest;
import com.capgemini.molvenohotel.ReserveringsApp.model.basics.user.InternetGuest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/hotel2")
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
