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

    public Room(String roomNr) {
        this.roomNr = roomNr;
    }

    public Room(String roomNr, double area, Currency price, int singleBeds, int doubleBeds, int capacity,
                boolean bookable, ArrayList<RoomAttributes> roomAttributes, ArrayList<String> imageUrls) {
        this.roomNr = roomNr;
        this.area = area;
        this.price = price;
        this.singleBeds = singleBeds;
        this.doubleBeds = doubleBeds;
        this.capacity = capacity;
        this.bookable = bookable;
        this.roomAttributes = roomAttributes;
        this.imageUrls = imageUrls;
    }
}
