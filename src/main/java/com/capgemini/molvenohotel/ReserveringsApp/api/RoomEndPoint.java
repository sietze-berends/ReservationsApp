package com.capgemini.molvenohotel.ReserveringsApp.api;

import com.capgemini.molvenohotel.ReserveringsApp.controller.service.RoomService;
import com.capgemini.molvenohotel.ReserveringsApp.model.basics.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

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

    @GetMapping("/allrooms/{id}")
    public Room getRoomById(@PathVariable Long id) {
        Optional<Room> room = roomService.showRoomById(id);
        return room.get();
    }


}