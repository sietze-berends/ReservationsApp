package search;

import hotel.Hotel;
import hotel.InitializeHotel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class SearchModuleTest {

    private InitializeHotel initializeHotel;
    @Before
    public void initialize() {
        this.initializeHotel = new InitializeHotel();

    }

    @Test
    public void searchFault() {
        Hotel molveno = initializeHotel.makeMolveno();
        String result = molveno.search(LocalDateTime.now(), LocalDateTime.now().plusDays(3), 80, 3);
        Assert.assertEquals("Call the receptionist on " + molveno.getTelNo(), result );
    }

    @Test
    public void searchAll() {
        Hotel molveno = initializeHotel.makeMolveno();
    }

    @Test
    public void searchAttributes() {
        Hotel molveno = initializeHotel.makeMolveno();
    }
}