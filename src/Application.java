import java.time.LocalDate;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        InitializeHotel initializeHotel = new InitializeHotel();
        Hotel molveno = initializeHotel.makeMolveno();
    }
}