import hotel.Hotel;
import hotel.InitializeHotel;
import java.time.LocalDateTime;

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
