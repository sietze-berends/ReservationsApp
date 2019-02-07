package com.capgemini.molvenohotel.ReserveringsApp;

import com.capgemini.molvenohotel.ReserveringsApp.model.basics.Hotel;
import com.capgemini.molvenohotel.ReserveringsApp.model.basics.Room;
import com.capgemini.molvenohotel.ReserveringsApp.model.basics.RoomAttribute;
import com.capgemini.molvenohotel.ReserveringsApp.initializer.InitializeHotel;
import com.capgemini.molvenohotel.ReserveringsApp.search.SearchModule;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SearchModuleTest {

    private InitializeHotel initializeHotel;
    private SearchModule searchModule;

    @Before
    public void initialize() {
        this.initializeHotel = new InitializeHotel();
        this.searchModule = new SearchModule();
    }

    @Test
    public void searchFault() {
        Hotel molveno = initializeHotel.makeMolveno();
        String result = molveno.search(LocalDateTime.now(), LocalDateTime.now().plusDays(3), 80,
                3);
        Assert.assertEquals("Call the receptionist on " + molveno.getTelNo(), result);
    }

    @Test
    public void searchNormal() {
        Hotel molveno = initializeHotel.makeMolveno();
        List<Room> suggestion = searchModule.searchSuggestion(LocalDateTime.now(), LocalDateTime.now().plusDays(3),
                8, 3, molveno);

        assertEquals(3, suggestion.size());

    }

    @Test
    public void searchAll() {
        Hotel molveno = initializeHotel.makeMolveno();
        List<Room> suggestion = searchModule.searchAll(LocalDateTime.now(), LocalDateTime.now().plusDays(3), molveno);

        assertEquals(4, suggestion.size());
    }
    @Test
    public void searchAttributes() {
        Hotel molveno = initializeHotel.makeMolveno();
        List<Room> allRooms = molveno.getRooms();
//        List<Room> suggestion = searchModule.searchAttributes(roomAttributes, allRooms);
//        for (Room room : suggestion) {
//            System.out.println(room.toString());
//        }
//        assertEquals(1, suggestion.size());
    }
}
