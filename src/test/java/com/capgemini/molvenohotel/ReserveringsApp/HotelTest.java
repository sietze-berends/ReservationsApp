package com.capgemini.molvenohotel.ReserveringsApp;

import com.capgemini.molvenohotel.ReserveringsApp.model.basics.Hotel;
import com.capgemini.molvenohotel.ReserveringsApp.model.basics.Reservation;
import com.capgemini.molvenohotel.ReserveringsApp.model.basics.Room;
import com.capgemini.molvenohotel.ReserveringsApp.model.basics.RoomAttribute;
import com.capgemini.molvenohotel.ReserveringsApp.model.user.Guest;

import org.junit.Before;
import java.util.ArrayList;
import java.util.List;

public class HotelTest {

    private List<Room> rooms = new ArrayList<>();
    private List<Guest> guests = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();
    private Hotel molveno;
    private Reservation reservation1;

    @Before
    public void before(){

//        Room room1 = new Room("101", 20.0, 100.0, 0, 1, 2, true, room1Attributes, null);
//        Room room2 = new Room("102", 40.0, 200.0, 2, 1, 4, true, room2Attributes, null);
//        Guest guest1 = new Guest("1", "Sietze", "Berends", LocalDate.of(1993, 6,
//                9), "sietze.b@gmail.com", "toEncrypt", "Dutch");
//        Guest guest2 = new Guest("2", "Pim", "Groenveld", LocalDate.of(1992, 2,
//                11), "pim.g@gmail.com", "toEncrypt", "Dutch");
//
//        rooms.add(room1);
//        rooms.add(room2);
//        guests.add(guest1);
//        guests.add(guest2);
//
//        reservation1 = new Reservation(rooms, LocalDateTime.of(2019, 01, 28, 01, 00),
//                LocalDateTime.of(2019,01,24,01,00), guest1);

//        System.out.println("before reservation: " + reservation1);
    }

//    @Test
//    public void addReservationTest() {
//        molveno.addReservation(reservation1);
//        Assert.assertEquals(1, reservations.size());
//    }
}