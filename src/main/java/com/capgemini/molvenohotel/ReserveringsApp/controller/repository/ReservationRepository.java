package com.capgemini.molvenohotel.ReserveringsApp.controller.repository;

import com.capgemini.molvenohotel.ReserveringsApp.model.basics.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
}
