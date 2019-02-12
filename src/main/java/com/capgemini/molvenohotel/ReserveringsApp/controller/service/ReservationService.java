package com.capgemini.molvenohotel.ReserveringsApp.controller.service;

import com.capgemini.molvenohotel.ReserveringsApp.controller.repository.GuestRepository;
import com.capgemini.molvenohotel.ReserveringsApp.controller.repository.ReservationRepository;
import com.capgemini.molvenohotel.ReserveringsApp.controller.repository.RoomRepository;
import com.capgemini.molvenohotel.ReserveringsApp.dto.ReservationDTO;
import com.capgemini.molvenohotel.ReserveringsApp.model.basics.Reservation;
import com.capgemini.molvenohotel.ReserveringsApp.model.basics.Room;
import com.capgemini.molvenohotel.ReserveringsApp.model.basics.user.ExtraGuest;
import com.capgemini.molvenohotel.ReserveringsApp.model.basics.user.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private GuestRepository guestRepository;

    public Iterable<Reservation> showAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> showReservationById(Long id) {
        return reservationRepository.findById(id);
    }


    public Reservation save(ReservationDTO reservationDTO) {

        // initialize the extra guests as an empty array with the right size
            int guests = Integer.parseInt(reservationDTO.getGuests());
        List<ExtraGuest> extraGuests = new ArrayList<>();

        // initialize the head booker
        Guest booker = guestRepository.findByEmail(reservationDTO.getBooker().split("-")[1].replace(" ", ""));

        // initialize all the rooms
        List<Room> rooms = new ArrayList<>();
        String roomsString[] = reservationDTO.getRooms().split(",");
        for (String room : roomsString) {
            rooms.add(roomRepository.findByRoomNr(room.replace(" ", "")));
        }

        // initialize the start date and end date
        String startString[] = reservationDTO.getFrom().split("-");
        LocalDate startDate = LocalDate.of(Integer.valueOf(startString[0]), Integer.valueOf(startString[1]), Integer.valueOf(startString[2]));
        LocalTime startTime = LocalTime.of(11, 00);
        String endString[] = reservationDTO.getUntil().split("-");
        LocalDate endDate = LocalDate.of(Integer.valueOf(endString[0]), Integer.valueOf(endString[1]), Integer.valueOf(endString[2]));
        LocalTime endTime = LocalTime.of(14, 00);
        LocalDateTime start = LocalDateTime.of(startDate, startTime);
        LocalDateTime end = LocalDateTime.of(endDate, endTime);

        // make the reservation and set the total guest amount
        Reservation reservation = new Reservation(rooms, start, end, booker, extraGuests);
        reservation.setTotalGuests(guests);

        return reservationRepository.save(reservation);
    }

    public void removeReservationById(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }

    public Reservation showReservationByReservationNumber(int reservationNumber) {
        return reservationRepository.findByReservationNumber(reservationNumber);
    }

}