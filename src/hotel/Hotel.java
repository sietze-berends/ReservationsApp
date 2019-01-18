package hotel;

import payment.Invoice;
import user.Guest;

import java.util.ArrayList;

public class Hotel {

    // some basic details about the hotel.Hotel
    private String name;
    private String telNo;
    private String email;

    private ArrayList<Room> rooms;
    private ArrayList<Guest> guests;
    private ArrayList<Invoice> invoices;
    private ArrayList<Reservation> reservations;

    public Hotel(String name, String telNo, String email) {
        this.name = name;
        this.telNo = telNo;
        this.email = email;
    }

    public Hotel(String name, String telNo, String email, ArrayList<Room> rooms, ArrayList<Guest> guests, ArrayList<Invoice> invoices, ArrayList<Reservation> reservations) {
        this.name = name;
        this.telNo = telNo;
        this.email = email;
        this.rooms = rooms;
        this.guests = guests;
        this.invoices = invoices;
        this.reservations = reservations;
    }
}
