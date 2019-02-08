package com.capgemini.molvenohotel.ReserveringsApp.controller.repository;

import com.capgemini.molvenohotel.ReserveringsApp.model.basics.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface RoomRepository extends CrudRepository<Room, Long> {
    Room findByRoomNr(String roomNr);
}