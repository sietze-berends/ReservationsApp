package com.capgemini.molvenohotel.ReserveringsApp.hotel;

import com.capgemini.molvenohotel.ReserveringsApp.basics.Reservation;
import com.capgemini.molvenohotel.ReserveringsApp.basics.Room;
import com.capgemini.molvenohotel.ReserveringsApp.user.Guest;
import com.capgemini.molvenohotel.ReserveringsApp.payment.Invoice;
import com.capgemini.molvenohotel.ReserveringsApp.payment.PaymentModule;
import com.capgemini.molvenohotel.ReserveringsApp.search.SearchModule;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Singleton class that models the Molveno lake resort. Hotel holds all the rooms, guests, invoices and reservations.
 * Hotel has some methods to perform searches, make bookings, etc
 */


public class Hotel {

    // some basic details about the hotel.Hotel
    private String name;
    private String telNo;
    private String email;

    private List<Room> rooms;
    private List<Guest> guests;
    private List<Invoice> invoices;
    private List<Reservation> reservations;

    private SearchModule searchModule = new SearchModule();
    private PaymentModule paymentModule = new PaymentModule();

    public Hotel(String name, String telNo, String email) {
        this.name = name;
        this.telNo = telNo;
        this.email = email;
    }

    public Hotel(String name, String telNo, String email, List<Room> rooms, List<Guest> guests
            , List<Invoice> invoices, List<Reservation> reservations) {
        this.name = name;
        this.telNo = telNo;
        this.email = email;
        this.rooms = rooms;
        this.guests = guests;
        this.invoices = invoices;
        this.reservations = reservations;
    }

    public Hotel(String name, String telNo, String email, List<Room> rooms, List<Guest> guests
            , List<Reservation> reservations) {
        this.name = name;
        this.telNo = telNo;
        this.email = email;
        this.rooms = rooms;
        this.guests = guests;
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

    public String search(LocalDateTime start, LocalDateTime end, int amountOfGuests, int amountOfRooms) {
        List<Room> suggestion = searchModule.searchSuggestion(start, end, amountOfGuests, amountOfRooms, this);

        if (suggestion == null) {

            return "Call the receptionist on " + telNo;
        }
        String result = "";
        result += "eerst suggestie \n";

        for (Room room : suggestion) {
            result += room.toString() + "\n";
        }

        result += "Dan de rest:\n";

        List<Room> availableRooms = searchModule.searchAll(start, end, this);
        for (Room room : availableRooms) {
            result += room.toString() + "\n";
        }
        return result;
    }

    public void addReservation(Reservation reservation) throws Exception{
        if (reservation.isValid()){
            reservations.add(reservation);
        }
    }

    public double makeInvoice(Reservation reservation) {
        double totalPrice = this.paymentModule.makeInvoice(reservation);
        return totalPrice;
    }

    @Override
    public String toString() {
        String output;
        output = "This hotel has the following rooms:\n";
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
            if (room.getRoomId().equalsIgnoreCase(roomNr)) {
                return room;
            }
        }
        return null;
    }
}
