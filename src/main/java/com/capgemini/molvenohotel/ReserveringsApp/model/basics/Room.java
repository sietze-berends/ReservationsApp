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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private boolean childFriendly;
    private boolean disabledFriendly;

    private ArrayList<String> imageUrls;

    public Room () {

    }
    public Room(String roomNr, String roomType, double price, int singleBeds, int doubleBeds, int babyBeds,
                int capacityRoom, int capacityAdults, int capacityBaby, boolean clean, boolean childFriendly,
                boolean disabledFriendly, ArrayList<String> imageUrls) {
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
        this.disabledFriendly = disabledFriendly;
        this.childFriendly = childFriendly;
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
                ", imageUrls=" + imageUrls +
                '}';
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

    public boolean isChildFriendly() {
        return childFriendly;
    }

    public boolean isDisabledFriendly() {
        return disabledFriendly;
    }

    public void setRoomNr(String roomNr) {
        this.roomNr = roomNr;
    }

    public void setChildFriendly(boolean childFriendly) {
        this.childFriendly = childFriendly;
    }

    public void setDisabledFriendly(boolean disabledFriendly) {
        this.disabledFriendly = disabledFriendly;
    }
}
