package com.capgemini.molvenohotel.ReserveringsApp.model.payment;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that models a subinvoice. E.g: bill of the room, bill of the restaurant or bill of the bar
 * Contains lines that give more detail
 */
@Entity
public class SubInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long subInvoiceId;

    private String name;

    @OneToMany
    private List<SubInvoiceLine> subInvoiceLines;

    public SubInvoice(String name) {
        this.name = name;
        this.subInvoiceLines = new ArrayList<>();
    }
}
