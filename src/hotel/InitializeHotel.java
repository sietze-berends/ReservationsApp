package hotel;

import hotel.Hotel;
import user.Guest;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Class that initializes our hotel with rooms, guests, reservations and invoices
 * Uses separate initializers for the ones above to keep code readable
 */
public class InitializeHotel {

    public Hotel makeMolveno() {
        InitializeRooms rooms = new InitializeRooms();
        InitializeGuests guests = new InitializeGuests();

        Hotel molveno = new Hotel("Molveno test", "", "", rooms.getRooms(), guests.getGuests(), new ArrayList<>(), new ArrayList<>());

        InitializeReservations reservations = new InitializeReservations(molveno);
        molveno.setReservations(reservations.getReservations());

        return molveno;
    }

}