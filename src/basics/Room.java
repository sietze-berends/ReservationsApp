package basics;

import java.util.ArrayList;

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

    public Room(String roomNr) {
        this.roomId = roomNr;
    }

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

    public ArrayList<RoomAttributes> getRoomAttributes() {
        return roomAttributes;
    }

    public void setRoomAttributes(ArrayList<RoomAttributes> roomAttributes) {
        this.roomAttributes = roomAttributes;
    }

    public ArrayList<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(ArrayList<String> imageUrls) {
        this.imageUrls = imageUrls;
    }
}
