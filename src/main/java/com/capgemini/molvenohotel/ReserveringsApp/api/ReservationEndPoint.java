package com.capgemini.molvenohotel.ReserveringsApp.api;

import com.capgemini.molvenohotel.ReserveringsApp.controller.service.ReservationService;
import com.capgemini.molvenohotel.ReserveringsApp.dto.ReservationDTO;
import com.capgemini.molvenohotel.ReserveringsApp.model.basics.Reservation;
import com.capgemini.molvenohotel.ReserveringsApp.model.basics.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@RestController
@RequestMapping("/hotel")
public class ReservationEndPoint {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/allreservations")
    public Iterable<Reservation> getAllReservations() {
        Iterable<Reservation> reservations = reservationService.showAllReservations();
        return reservations;
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @PostMapping("/allreservations/add")
    public ReservationDTO addReservation(@RequestBody ReservationDTO reservationDTO) throws Exception {
        reservationService.save(reservationDTO);
        return reservationDTO;
    }

    @GetMapping("/allreservations/{id}")
    public Reservation getReservationById(@PathVariable Long id) {
        Optional<Reservation> reservation = reservationService.showReservationById(id);
        return reservation.get();
    }
    @DeleteMapping("/allreservations/{id}/delete")
    public void deleteGuest(@PathVariable Long id){
       reservationService.removeReservationById(id);
    }
}


