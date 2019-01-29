package com.capgemini.molvenohotel.ReserveringsApp.controller;


import com.capgemini.molvenohotel.ReserveringsApp.basics.Room;
import com.capgemini.molvenohotel.ReserveringsApp.hotel.Hotel;
import com.capgemini.molvenohotel.ReserveringsApp.hotel.InitializeHotel;
import com.capgemini.molvenohotel.ReserveringsApp.hotel.InitializeRooms;
import com.sun.org.apache.xml.internal.security.Init;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/hotel")
public class RoomController {

    private InitializeHotel initializeHotel = new InitializeHotel();
    private Hotel hotel = initializeHotel.makeMolveno();


    @GetMapping(path = "/rooms")
    public List<Room> getAllRooms() {
        return hotel.getRooms();
    }

    @GetMapping(value = "/room/{roomNr}")
    public Room getRoomByNr(InitializeRooms initializeRooms, @PathVariable String roomNr){
        return hotel.getOneRoom(roomNr);
    }

    //TODO: edit, add, delete

    // work in progress
//    @RequestMapping(value = "/room/add", method = RequestMethod.POST)
//    public void addRoom(@RequestBody Room room){
//        hotel.addRoom(room);
//    }
}
