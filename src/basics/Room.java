package basics;

import java.util.ArrayList;
import java.util.List;

/**
 * Models a room with some basic data.
 * Bookable indicates whether it's an actual room or something like a conference room;
 */

public class Room {
    private String roomId;
    private double area;
    private double price;
    private int singleBeds;
    private int doubleBeds;
    private int capacity;
    private boolean bookable;
    private boolean clean;
    private List<RoomAttribute> roomAttributes;
    private List<String> imageUrls;

    public Room(String roomNr, double area, double price, int singleBeds, int doubleBeds, int capacity,
                boolean bookable, List<RoomAttribute> roomAttributes, List<String> imageUrls) {
        this.roomId = roomNr;
        this.area = area;
        this.price = price;
        this.singleBeds = singleBeds;
        this.doubleBeds = doubleBeds;
        this.capacity = capacity;
        this.bookable = bookable;
        this.clean = true;
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

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSingleBeds() {
        return singleBeds;
    }

    public void setSingleBeds(int singleBeds) {
        this.singleBeds = singleBeds;
    }

    public int getDoubleBeds() {
        return doubleBeds;
    }

    public void setDoubleBeds(int doubleBeds) {
        this.doubleBeds = doubleBeds;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isBookable() {
        return bookable;
    }

    public void setBookable(boolean bookable) {
        this.bookable = bookable;
    }

    public boolean isClean() {
        return clean;
    }

    public void setClean(boolean clean) {
        this.clean = clean;
    }

    public List<RoomAttribute> getRoomAttributes() {
        return roomAttributes;
    }

    public void setRoomAttributes(List<RoomAttribute> roomAttributes) {
        this.roomAttributes = roomAttributes;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }
}
