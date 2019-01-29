package com.capgemini.molvenohotel.ReserveringsApp;

import com.capgemini.molvenohotel.ReserveringsApp.hotel.Hotel;
import com.capgemini.molvenohotel.ReserveringsApp.hotel.InitializeHotel;
import com.capgemini.molvenohotel.ReserveringsApp.search.SearchModule;

import org.junit.Test;

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
        assertEquals(2000.0, totalPrice, 0.0  );
    }
}