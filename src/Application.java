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
        System.out.println("Zoek 3 kamers voor 8 gasten...");
        System.out.println("Suggestie:");
        molveno.search(LocalDateTime.now(), LocalDateTime.now().plusDays(3), 8, 3);
    }
}
