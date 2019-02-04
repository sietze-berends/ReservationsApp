package com.capgemini.molvenohotel.ReserveringsApp.initializer;

import com.capgemini.molvenohotel.ReserveringsApp.model.basics.Hotel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Class that initializes our rooms with rooms, guests, reservations and invoices
 * Uses separate initializers for the ones above to keep code readable
 */

@Component
public class InitializeHotel {

    public InitializeHotel() {
    }

    public Hotel makeMolveno() {
        InitializeRooms rooms = new InitializeRooms();
        InitializeGuests guests = new InitializeGuests();
        InitializeExtraGuests extraGuests = new InitializeExtraGuests();

        Hotel molveno = new Hotel("Molveno test", "0612345678", "", rooms.getRooms(), guests.getGuests(), extraGuests.getExtraGuests(), new ArrayList<>(), new ArrayList<>());

        InitializeReservations reservations = new InitializeReservations(molveno);
        molveno.setReservations(reservations.getReservations());

        return molveno;
    }
}