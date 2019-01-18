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
import hotel.Hotel;
import hotel.InitializeHotel;
public class Application {
    public static void main(String[] args) {

        InitializeHotel initializeHotel = new InitializeHotel();
        Hotel molveno = initializeHotel.makeMolveno();

    }
}