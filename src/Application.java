import hotel.Hotel;
import hotel.InitializeHotel;
import java.time.LocalDateTime;

public class Application {
    public static void main(String[] args) {
        InitializeHotel initializeHotel = new InitializeHotel();
        Hotel molveno = initializeHotel.makeMolveno();
        molveno.search(LocalDateTime.now(), LocalDateTime.now().plusDays(3), 2, 1);
    }
}
