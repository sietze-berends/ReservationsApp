package com.capgemini.molvenohotel.ReserveringsApp.basics;

import java.util.List;

/**
 * Models a room with some basic data.
 * Bookable indicates whether it's an actual room or something like a conference room;
 */

public class Room {
    private String roomId;
    private String roomType;
    private double price;
    private int singleBeds;
    private int doubleBeds;
    private int babyBeds;
    private int capacityRoom;
    private int capacityAdults;
    private int capacityBaby;
    private boolean clean;
    private List<RoomAttribute> roomAttributes;
    private List<String> imageUrls;


    public Room(String roomNr, String roomType, double price, int singleBeds, int doubleBeds, int babyBeds,
                int capacityRoom, int capacityAdults, int capacityBaby, boolean clean,
                List<RoomAttribute> roomAttributes, List<String> imageUrls) {
        this.roomId = roomNr;
        this.roomType = roomType;
        this.price = price;
        this.singleBeds = singleBeds;
        this.doubleBeds = doubleBeds;
        this.babyBeds = babyBeds;
        this.capacityRoom = capacityRoom;
        this.capacityAdults = capacityAdults;
        this.capacityBaby = capacityBaby;
        this.clean = clean;
        this.roomAttributes = roomAttributes;
        this.imageUrls = imageUrls;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId='" + roomId + '\'' +
                ", roomType='" + roomType +
                ", price=" + price +
                ", singleBeds=" + singleBeds +
                ", doubleBeds=" + doubleBeds +
                ", babyBeds=" + babyBeds +
                ", capacityRoom=" + capacityRoom +
                ", capacityAdults=" + capacityAdults +
                ", capacityBaby=" + capacityBaby +
                ", clean=" + clean +
                ", roomAttributes=" + roomAttributes.toString() +
                ", imageUrls=" + imageUrls +
                '}';
    }

    public List<RoomAttribute> getRoomAttributes() {
        return roomAttributes;
    }

    public String getRoomType() { return roomType; }

    public double getPrice() {
        return price;
    }

    public int getCapacityRoom() {
        return capacityRoom;
    }

    public int getCapacityAdults() {
        return capacityAdults;
    }

    public int getCapacityBaby() {
        return capacityBaby;
    }

    public String getRoomId() {
        return roomId;
    }

    public int getSingleBeds() {
        return singleBeds;
    }

    public int getDoubleBeds() {
        return doubleBeds;
    }

    public int getBabyBeds() {
        return babyBeds;
    }

    public boolean isClean() {
        return clean;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }
}
