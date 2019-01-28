package com.capgemini.molvenohotel.ReserveringsApp.controller;


import com.capgemini.molvenohotel.ReserveringsApp.basics.Reservation;
import com.capgemini.molvenohotel.ReserveringsApp.basics.Room;
import com.capgemini.molvenohotel.ReserveringsApp.hotel.BasicHotel;
import com.capgemini.molvenohotel.ReserveringsApp.hotel.Hotel;
import com.capgemini.molvenohotel.ReserveringsApp.hotel.InitializeReservations;
import com.capgemini.molvenohotel.ReserveringsApp.hotel.InitializeRooms;
import com.capgemini.molvenohotel.ReserveringsApp.search.SearchModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/hotel")
public class RoomController {

//    @Autowired
//    SearchModule searchModule;

    @GetMapping(path = "/contact")
    public String getHotelContactInfo() {
        return "Look! Here's some useless hotel info. It is somewhere in China. Bye Bye";
    }

    @GetMapping(value = "/room")
    public List<Room> getRooms(InitializeRooms initializeRooms){
        return initializeRooms.getRooms();
    }

    @GetMapping(value = "/reservation")
    public List<Reservation> getReservations(BasicHotel hotel) {
        return hotel.getReservations();
    }

    // werkt nog niet lekker, meer als voorbeeld
//    @GetMapping(value = "/room/{id}")
//    public List<Room> getRoom(@PathVariable String id){
//        return searchModule.searchAll(id);
//    }
}
