package com.capgemini.molvenohotel.ReserveringsApp.controller.service;

import com.capgemini.molvenohotel.ReserveringsApp.controller.repository.RoomRepository;
import com.capgemini.molvenohotel.ReserveringsApp.model.basics.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Iterable<Room> showAllRooms() {
        return roomRepository.findAll();
    }

    public Room showRoomByRoomNr(String roomNr) {
        return roomRepository.findByRoomNr(roomNr);
    }

    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    public void removeRoomByRoomNr(String roomNr) {
        System.out.println("Deleted room id: " + roomNr);
        roomRepository.deleteByRoomNr(roomNr);
    }

    public Iterable<Room> findAvailabilityPerRoomNr(String startDate, String endDate, String roomNumber) {
        return roomRepository.findAvailabilityPerRoom(startDate, endDate, roomNumber);
    }
}