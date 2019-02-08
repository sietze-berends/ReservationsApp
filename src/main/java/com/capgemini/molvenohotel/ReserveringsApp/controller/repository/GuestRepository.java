package com.capgemini.molvenohotel.ReserveringsApp.controller.repository;

import com.capgemini.molvenohotel.ReserveringsApp.model.basics.user.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface GuestRepository extends CrudRepository<Guest, Long> {
    Guest findByEmail(String email);
}