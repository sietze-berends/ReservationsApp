package hotel;

import hotel.Hotel;
import user.Guest;

import java.time.LocalDate;
import java.util.ArrayList;

public class InitializeHotel {
    
    public Hotel makeMolveno() {
        ArrayList<RoomAttributes> roomAttributes = new ArrayList<>();
        ArrayList<RoomAttributes> roomAttributes2 = new ArrayList<>();
        ArrayList<Guest> guests = new ArrayList<>();
        ArrayList<Room> rooms = new ArrayList<>();

        roomAttributes.add(new RoomAttributes("Jacuzzi", "This room has a jacuzzi"));
        roomAttributes2.add(new RoomAttributes("Child friendly", "A room which is childfriendly"));

        guests.add(new Guest("1", "Sietze", "Berends", LocalDate.of(1993, 6,
                9),"sietze.berends@capgemini.com", "wwCapK42csd"));

        guests.add(new Guest ("2", "Pim", "Groenveld", LocalDate.of(1992, 2,
                11), "pim.groeneveld@capgemini.com", "wwCapScrumMaster42"));


        rooms.add(new Room("101", 20.0, 100.0, 0, 1, 2, true, roomAttributes, null));
        rooms.add(new Room("102", 40.0, 200.0, 2, 1, 4, true, roomAttributes2, null));

        Hotel molveno = new Hotel("Molveno test", "", "", rooms, null, null, null);

        return molveno;
    }

}
