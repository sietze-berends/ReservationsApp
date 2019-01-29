package com.capgemini.molvenohotel.ReserveringsApp.controller;


import com.capgemini.molvenohotel.ReserveringsApp.basics.Reservation;
import com.capgemini.molvenohotel.ReserveringsApp.basics.Room;
import com.capgemini.molvenohotel.ReserveringsApp.hotel.BasicHotel;
import com.capgemini.molvenohotel.ReserveringsApp.hotel.Hotel;
import com.capgemini.molvenohotel.ReserveringsApp.hotel.InitializeReservations;
import com.capgemini.molvenohotel.ReserveringsApp.hotel.InitializeRooms;
import com.capgemini.molvenohotel.ReserveringsApp.search.SearchModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/hotel")
public class RoomController {

    @Autowired
//    Hotel hotel;

    @GetMapping(path = "/")
    public String homepage() {
        return "This will be our homepage. Here's some useless hotel info. It is somewhere in China. Bye Bye";
    }

    @GetMapping(path = "/contact")
    public String getHotelContactInfo() {
        return "Hotel Molveno -> just a route to add info in later";
    }

    //GET
    @GetMapping(value = "/room")
    public List<Room> getRooms(InitializeRooms initializeRooms){
        return initializeRooms.getRooms();
    }

    @GetMapping(value = "/room/{roomNr}")
    public Room getRoomByNr(InitializeRooms initializeRooms, @PathVariable int roomNr){
        return initializeRooms.getOneRoom(roomNr);
    }

    //TODO: edit, add, delete

    // work in progress
//    @RequestMapping(value = "/room/add", method = RequestMethod.POST)
//    public void addRoom(@RequestBody Room room){
//        hotel.addRoom(room);
//    }
}
