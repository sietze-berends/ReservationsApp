package com.capgemini.molvenohotel.ReserveringsApp.api;

import com.capgemini.molvenohotel.ReserveringsApp.controller.service.GuestService;
import com.capgemini.molvenohotel.ReserveringsApp.model.user.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@RestController
@RequestMapping("/hotel")
public class GuestEndPoint {

    @Autowired
    private GuestService guestService;

    @GetMapping("/allguests")
    public Iterable<Guest> getAllGuests() {
        Iterable<Guest> guests = guestService.showAllGuests();
        return guests;
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @PostMapping("/allguests/add")
    public void addGuest(@RequestBody Guest guest) {
        guestService.addGuest(guest);
    }

    @GetMapping("/allguests/{id}")
    public Guest getGuestById(@PathVariable Long id) {
        Optional<Guest> guest = guestService.showGuestById(id);
        return guest.get();
    }

    @DeleteMapping("/allguests/{id}/delete")
    public void deleteGuest(@PathVariable Long id){
        guestService.removeGuestById(id);
        System.out.println("Deleted guest endPoint id: " + id);
    }


}