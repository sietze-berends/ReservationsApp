package com.capgemini.molvenohotel.ReserveringsApp.model.basics;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Models a room with some basic data.
 * Bookable indicates whether it's an actual room or something like a conference room;
 */

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String roomNr;
    private String roomType;
    private double price;
    private int singleBeds;
    private int doubleBeds;
    private int babyBeds;
    private int capacityRoom;
    private int capacityAdults;
    private int capacityBaby;
    private boolean clean;

    @OneToMany
    private List<RoomAttribute> roomAttributes;
    private ArrayList<String> imageUrls;

    public Room () {

    }
    public Room(String roomNr, String roomType, double price, int singleBeds, int doubleBeds, int babyBeds,
                int capacityRoom, int capacityAdults, int capacityBaby, boolean clean,
                List<RoomAttribute> roomAttributes, ArrayList<String> imageUrls) {
        this.roomNr = roomNr;
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
                "id='" + id + '\'' +
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
          //      ", imageUrls=" + imageUrls +
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

    public String getRoomNr() {
        return roomNr;
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

    public void setId(String roomNr) {
        this.roomNr = roomNr;
    }

    public void setImageUrls(ArrayList<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSingleBeds(int singleBeds) {
        this.singleBeds = singleBeds;
    }

    public void setDoubleBeds(int doubleBeds) {
        this.doubleBeds = doubleBeds;
    }

    public void setBabyBeds(int babyBeds) {
        this.babyBeds = babyBeds;
    }

    public void setCapacityRoom(int capacityRoom) {
        this.capacityRoom = capacityRoom;
    }

    public void setCapacityAdults(int capacityAdults) {
        this.capacityAdults = capacityAdults;
    }

    public void setCapacityBaby(int capacityBaby) {
        this.capacityBaby = capacityBaby;
    }

    public void setClean(boolean clean) {
        this.clean = clean;
    }

    public void setRoomAttributes(List<RoomAttribute> roomAttributes) {
        this.roomAttributes = roomAttributes;
    }
}
