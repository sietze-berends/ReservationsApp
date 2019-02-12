package com.capgemini.molvenohotel.ReserveringsApp.controller.repository;

import com.capgemini.molvenohotel.ReserveringsApp.model.basics.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface RoomRepository extends CrudRepository<Room, Long> {
    Room findByRoomNr(String roomNr);

    Long deleteByRoomNr(String roomNr);

    @Query(value = "select * from room r where not exists (select 1 from reservation_room_list rrl join reservation re on re.id = rrl.reservation_id where rrl.room_list_id = r.id and ('2019-02-29' > re.start and '2019-02-12' < re.end) )", nativeQuery = true)
    Iterable<Room> findAvailabilityPerRoom(String start, String end, String roomNumber);
}