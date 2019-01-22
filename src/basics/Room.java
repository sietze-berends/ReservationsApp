package basics;

import java.util.ArrayList;

/**
 * Models a room with some basic data.
 * Bookable indicates whether it's an actual room or something like a conference room;
 */

public class Room {
    private String roomId;
    double area;
    double price;
    int singleBeds;
    int doubleBeds;
    int capacity;
    boolean bookable;
    ArrayList<RoomAttributes> roomAttributes;
    ArrayList<String> imageUrls;
    
    public Room(String roomNr, double area, double price, int singleBeds, int doubleBeds, int capacity,
                boolean bookable, ArrayList<RoomAttributes> roomAttributes, ArrayList<String> imageUrls) {
        this.roomId = roomNr;
        this.area = area;
        this.price = price;
        this.singleBeds = singleBeds;
        this.doubleBeds = doubleBeds;
        this.capacity = capacity;
        this.bookable = bookable;
        this.roomAttributes = roomAttributes;
        this.imageUrls = imageUrls;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId='" + roomId + '\'' +
                ", area=" + area +
                ", price=" + price +
                ", singleBeds=" + singleBeds +
                ", doubleBeds=" + doubleBeds +
                ", capacity=" + capacity +
                ", bookable=" + bookable +
                ", roomAttributes=" + roomAttributes.toString() +
                ", imageUrls=" + imageUrls +
                '}';
    }
}
