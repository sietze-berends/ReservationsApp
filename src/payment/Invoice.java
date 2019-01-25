package payment;

import basics.Reservation;
import user.Guest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that models a final invoice that covers all hotel, restaurant and bar expenses
 * Contains several subinvoices to get more detail
 */
public class Invoice {

    private LocalDate invoiceDate;
    private Reservation reservation;
    private Guest booker;
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
}
