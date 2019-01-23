import basics.Room;
import hotel.Hotel;
import hotel.InitializeHotel;
import hotel.InitializeReservations;
import hotel.InitializeRooms;
import hotel.InitializeGuests;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Runner class for the Hotel Application
 */
public class Application {
    public static void main(String[] args) {
        InitializeHotel initializeHotel = new InitializeHotel();
        Hotel molveno = initializeHotel.makeMolveno();
        molveno.searchDate(LocalDateTime.now(), LocalDateTime.now().plusDays(3), 2, 1);

    }
}
