package payment;

import hotel.Reservation;
import user.Guest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class Invoice {

    private LocalDate invoiceDate;
    private Reservation reservation;
    private Guest booker;
    private ArrayList<SubInvoice> subInvoice;
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

    public ArrayList<SubInvoice> getSubInvoice() {
        return subInvoice;
    }

    public void setSubInvoice(ArrayList<SubInvoice> subInvoice) {
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
