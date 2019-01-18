import java.time.LocalDate;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
<<<<<<< HEAD
        Hotel molveno = new Hotel("Molveno", "", "");
=======
        InitializeHotel initializeHotel = new InitializeHotel();
        Hotel molveno = initializeHotel.makeMolveno();
>>>>>>> feature/Guest
    }
}