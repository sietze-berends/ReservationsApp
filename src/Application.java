import hotel.Hotel;
import hotel.InitializeHotel;

public class Application {
    public static void main(String[] args) {
        InitializeHotel initializeHotel = new InitializeHotel();
        Hotel molveno = initializeHotel.makeMolveno();
        System.out.println(molveno.toString());
    }
}
