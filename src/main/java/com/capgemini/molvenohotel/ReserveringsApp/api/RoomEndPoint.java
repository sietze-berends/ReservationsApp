package com.capgemini.molvenohotel.ReserveringsApp.api;

import com.capgemini.molvenohotel.ReserveringsApp.controller.service.RoomService;
import com.capgemini.molvenohotel.ReserveringsApp.model.basics.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

@RestController
@RequestMapping("/hotel")
public class RoomEndPoint {

    @Autowired
    private RoomService roomService;

    @GetMapping("/allrooms")
    public Iterable<Room> getAllRooms() {
        Iterable<Room> rooms = roomService.showAllRooms();
        return rooms;
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @PostMapping("/allrooms/add")
    public void addRoom(@RequestBody Room room) {
        roomService.addRoom(room);
    }

    @GetMapping("/allrooms/{roomNr}")
    public Room getRoomById(@PathVariable String roomNr) {
        System.out.println("Ik ben in de allroom/id");
        Room room = roomService.showRoomByRoomNr(roomNr);
        return room;
    }

    @DeleteMapping("/allrooms/{roomNr}/delete")
    public void deleteRoom(@PathVariable String roomNr){
        roomService.removeRoomByRoomNr(roomNr);
        System.out.println("Deleted room endPoint id: " + roomNr);
    }

    @GetMapping("/available/")
    public Iterable<Room> availableRoom(@RequestParam String roomNr, @RequestParam String start, @RequestParam String end) {
        return roomService.findAvailabilityPerRoomNr(start, end, roomNr);

    }


}