package com.capgemini.molvenohotel.ReserveringsApp.model.basics;

import com.capgemini.molvenohotel.ReserveringsApp.model.basics.user.ExtraGuest;
import com.capgemini.molvenohotel.ReserveringsApp.model.basics.user.Guest;
import com.capgemini.molvenohotel.ReserveringsApp.model.payment.Invoice;
import com.capgemini.molvenohotel.ReserveringsApp.model.payment.PaymentModule;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Singleton class that models the Molveno lake resort. Hotel holds all the rooms, guests, invoices and reservations.
 * Hotel has some methods to perform searches, make bookings, etc
 */

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    // some basic details about the rooms.Hotel
    private String name;
    private String telNo;
    private String email;

    @OneToMany
    private List<Room> rooms;

    @OneToMany
    private List<Guest> guests;

    @OneToMany
    private List<ExtraGuest> extraGuests;

    @OneToMany
    private List<Invoice> invoices;

    @OneToMany
    private List<Reservation> reservations;

    @Transient
    private PaymentModule paymentModule = new PaymentModule();

    public Hotel(String name, String telNo, String email) {
        this.name = name;
        this.telNo = telNo;
        this.email = email;
    }

    public Hotel(String name, String telNo, String email, List<Room> rooms, List<Guest> guests
            , List<ExtraGuest> extraGuests, List<Invoice> invoices, List<Reservation> reservations) {
        this.name = name;
        this.telNo = telNo;
        this.email = email;
        this.rooms = rooms;
        this.guests = guests;
        this.extraGuests = extraGuests;
        this.invoices = invoices;
        this.reservations = reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public String getTelNo() {
        return telNo;
    }

    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }

    public double makeInvoice(Reservation reservation) {
        double totalPrice = this.paymentModule.makeInvoice(reservation);
        return totalPrice;
    }

    @Override
    public String toString() {
        String output;
        output = "This rooms has the following rooms:\n";
        for (Room room : rooms) {
            output += room.toString() + "\n";
        }
        return output;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }


    public void addRoom(Room room){
        rooms.add(room);
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    public void setExtraGuests(List<ExtraGuest> extraGuests) {
        this.extraGuests = extraGuests;
    }

    public Guest getGuestByName(String name) {
        for (Guest guest : this.guests) {
            if (name.equalsIgnoreCase(guest.getFirstName() + " " + guest.getLastName())) {
                return guest;
            }
        }
        return this.guests.get(0);
    }

    public Guest addGuest(Guest guest) {
        this.guests.add(guest);
        return guest;
    }

    public List<Reservation> getAllReservationsPerBooker(int id){
        List<Reservation> match = new ArrayList<>();
        for (Reservation reservation : reservations){
            if (id == reservation.getBookerId(id)){
                match.add(reservation);
            }
        }
        return match;
    }
  
    public Room getOneRoom(String roomNr) {
        for (Room room : this.rooms) {
            if (room.getRoomNr().equalsIgnoreCase(roomNr)) {
                return room;
            }
        }
        return null;
    }

    public List<ExtraGuest> getExtraGuests() {
        return extraGuests;
    }
}
