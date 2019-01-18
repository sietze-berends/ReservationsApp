import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;

public class Room {
    private String roomNr;
    double area;
    Currency price;
    int singleBeds;
    int doubleBeds;
    int capacity;
    boolean bookable;
    ArrayList<RoomAttributes> roomAttributes;
    ArrayList<String> imageUrls;

}
