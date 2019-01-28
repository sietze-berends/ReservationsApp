package com.capgemini.molvenohotel.ReserveringsApp.payment;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that models a subinvoice. E.g: bill of the room, bill of the restaurant or bill of the bar
 * Contains lines that give more detail
 */
public class SubInvoice {

    private String name;
    private List<SubInvoiceLine> subInvoiceLines;

    public SubInvoice(String name) {
        this.name = name;
        this.subInvoiceLines = new ArrayList<>();
    }

}
