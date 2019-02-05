package com.capgemini.molvenohotel.ReserveringsApp.api;

import com.capgemini.molvenohotel.ReserveringsApp.controller.service.RoomService;
import com.capgemini.molvenohotel.ReserveringsApp.model.basics.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@RestController
@RequestMapping("/hotel")
public class RoomEndPoint {

    @Autowired
    private RoomService roomService;

    @GetMapping("/rooms")
    public Iterable<Room    > getAllRooms() {
        Iterable<Room> rooms = roomService.showAllRooms();
        return rooms;
    }

    @GetMapping("/rooms/{id}")
    public Room getRoomById(@PathVariable Long id) {
        Optional<Room> room = roomService.showRoomById(id);
        return room.get();
    }
}