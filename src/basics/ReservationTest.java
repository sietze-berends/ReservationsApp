package basics;

import hotel.BasicHotel;
import hotel.Hotel;
import hotel.InitializeHotel;
import hotel.InitializeReservations;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ReservationTest {
    private BasicHotel basicHotel = new BasicHotel();
    private Reservation res;
    private Reservation res2;
    private Reservation res3;
    private Reservation reservation;
    private InitializeReservations initializeReservations;
    private InitializeHotel hotel;

    @Before
    public void before(){
        List<RoomAttribute> room1Attributes = new ArrayList<>();
        List<RoomAttribute> room2Attributes = new ArrayList<>();

        Room room1 = new Room("101", 20.0, 100.0, 0, 1, 2, true, room1Attributes, null);
        Room room2 = new Room("102", 40.0, 200.0, 2, 1, 4, true, room2Attributes, null);

        InitializeHotel initializeHotel = new InitializeHotel();
        Hotel molveno = initializeHotel.makeMolveno();

        LocalDateTime startDate = LocalDateTime.of(2019,1,27,0,0);
        LocalDateTime endDate = LocalDateTime.of(2019,1,29,0,0);
        LocalDateTime startDate2 = LocalDateTime.of(2019,1,25,0,0);
        LocalDateTime endDate2 = LocalDateTime.of(2019,1,23,0,0);

        List<Room> roomReservering1 = new ArrayList<>();
        roomReservering1.add(room1);
        res = new Reservation(roomReservering1, startDate, endDate, basicHotel.getGuests().get(0) );
        res2 = new Reservation(roomReservering1, startDate2, endDate2, basicHotel.getGuests().get(0) );
//        res3 = new Reservation(roomReservering1, startDate, endDate, basicHotel.getGuests().get(2) );

    }

    @Test
    public void isValid() {
        //Given
        // see before
        //When
        try {
            res.isValid();
            System.out.println(res);
        } catch (Exception e){
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void isNotValid() {
        //Given
        // see before
        //When
        try {
            res2.isValid();
            Assert.fail("Reservation not valid");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
//
    @Test
    public void startDateIsInFuture(){
        try {
            res.isValid();
        } catch (Exception e){
            System.out.println("startDateIsInFuture exception: " + e.getMessage());
            Assert.fail();
        }
    }



}