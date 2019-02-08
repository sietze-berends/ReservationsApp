package com.capgemini.molvenohotel.ReserveringsApp.controller.service;

import com.capgemini.molvenohotel.ReserveringsApp.controller.repository.ReservationRepository;
import com.capgemini.molvenohotel.ReserveringsApp.controller.repository.RoomRepository;
import com.capgemini.molvenohotel.ReserveringsApp.model.basics.Reservation;
import com.capgemini.molvenohotel.ReserveringsApp.model.basics.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Iterable<Reservation> showAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> showReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

}
