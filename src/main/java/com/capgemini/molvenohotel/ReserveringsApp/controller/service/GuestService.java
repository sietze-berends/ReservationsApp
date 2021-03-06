package com.capgemini.molvenohotel.ReserveringsApp.controller.service;

import com.capgemini.molvenohotel.ReserveringsApp.controller.repository.GuestRepository;
import com.capgemini.molvenohotel.ReserveringsApp.model.basics.user.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    public Iterable<Guest> showAllGuests() {
        return guestRepository.findAll();
    }

    public Optional<Guest> showGuestById(Long id) {
        return guestRepository.findById(id);
    }

    public Guest addGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    public void removeGuestById(Long guestId) {
        guestRepository.deleteById(guestId);
    }

    public void removeAllGuests(List<Guest> guests) {
        guestRepository.deleteAll(guests);
    }
}