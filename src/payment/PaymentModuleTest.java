package payment;

import basics.RoomAttribute;
import hotel.Hotel;
import hotel.InitializeHotel;
import org.junit.Assert;
import org.junit.Test;
import search.SearchModule;

import java.util.List;

import static org.junit.Assert.*;

public class PaymentModuleTest {
    private InitializeHotel initializeHotel;
    private SearchModule searchModule;
    private Hotel molveno;

    public PaymentModuleTest() {
        initializeHotel = new InitializeHotel();
        searchModule = new SearchModule();
    }

    @Test public void subInvoiceAmount() {
        molveno = initializeHotel.makeMolveno();
        double totalPrice = molveno.makeInvoice(molveno.getReservations().get(0));
        Assert.assertEquals(500.0, totalPrice, 0.0  );
    }
}