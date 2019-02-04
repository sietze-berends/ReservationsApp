package com.capgemini.molvenohotel.ReserveringsApp.payment;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Class that models a line on a subinvoice.
 * E.g:
 * 1 - Item: Coca cola - amount: 2 - datetime: 11-01-2019 : 11:00 - price: € 4.40
 * 2 - Item: Merlot - amount: 1 - date: 12-01-2019 : 21:30 - price: € 7.40
 */

public class SubInvoiceLine {

    private String name;
    private int amount;
    private BigDecimal price;
    private LocalDateTime timeOfPurchase;

    public SubInvoiceLine(String name, int amount, BigDecimal price, LocalDateTime timeOfPurchase) {
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.timeOfPurchase = timeOfPurchase;
    }

}
