package com.capgemini.molvenohotel.ReserveringsApp.model.payment;

import com.capgemini.molvenohotel.ReserveringsApp.model.user.Guest;
import com.capgemini.molvenohotel.ReserveringsApp.model.basics.Reservation;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that models a final invoice that covers all rooms, restaurant and bar expenses
 * Contains several subinvoices to get more detail
 */

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long invoiceId;

    private LocalDate invoiceDate;

    @OneToOne
    private Reservation reservation;

    @OneToOne
    private Guest booker;

    @OneToMany
    private List<SubInvoice> subInvoice;
    private BigDecimal totalAmount;
    private BigDecimal amountAlreadyPaid;
    private boolean fullyPaid;
    private String paymentType;

    public Invoice(LocalDate invoiceDate, Reservation reservation, Guest booker, BigDecimal totalAmount,
                   BigDecimal amountAlreadyPaid, boolean fullyPaid, String paymentType) {
        this.invoiceDate = invoiceDate;
        this.reservation = reservation;
        this.booker = booker;
        this.subInvoice = new ArrayList<>();
        this.totalAmount = totalAmount;
        this.amountAlreadyPaid = amountAlreadyPaid;
        this.fullyPaid = fullyPaid;
        this.paymentType = paymentType;
    }

    public long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Guest getBooker() {
        return booker;
    }

    public void setBooker(Guest booker) {
        this.booker = booker;
    }

    public List<SubInvoice> getSubInvoice() {
        return subInvoice;
    }

    public void setSubInvoice(List<SubInvoice> subInvoice) {
        this.subInvoice = subInvoice;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getAmountAlreadyPaid() {
        return amountAlreadyPaid;
    }

    public void setAmountAlreadyPaid(BigDecimal amountAlreadyPaid) {
        this.amountAlreadyPaid = amountAlreadyPaid;
    }

    public boolean isFullyPaid() {
        return fullyPaid;
    }

    public void setFullyPaid(boolean fullyPaid) {
        this.fullyPaid = fullyPaid;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
