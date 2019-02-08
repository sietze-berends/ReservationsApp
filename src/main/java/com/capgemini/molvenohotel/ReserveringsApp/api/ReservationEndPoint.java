package com.capgemini.molvenohotel.ReserveringsApp.api;

import com.capgemini.molvenohotel.ReserveringsApp.controller.service.ReservationService;
import com.capgemini.molvenohotel.ReserveringsApp.dto.ReservationDTO;
import com.capgemini.molvenohotel.ReserveringsApp.model.basics.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

@RestController
@RequestMapping("/hotel")
public class ReservationEndPoint {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/reservations")
    public Iterable<Reservation> getAllReservations() {
        Iterable<Reservation> reservations = reservationService.showAllReservations();
        return reservations;
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @PostMapping("/reservations/add")
    public ReservationDTO addReservation(@RequestBody ReservationDTO reservationDTO) throws Exception {
        reservationService.save(reservationDTO);
        return reservationDTO;
    }
}
