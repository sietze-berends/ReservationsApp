package payment;

import java.util.ArrayList;

/**
 * Class that models a subinvoice. E.g: bill of the room, bill of the restaurant or bill of the bar
 * Contains lines that give more detail
 */
public class SubInvoice {

    private String name;
    private ArrayList<SubInvoiceLine> subInvoiceLines;

    public SubInvoice(String name) {
        this.name = name;
        this.subInvoiceLines = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<SubInvoiceLine> getSubInvoiceLines() {
        return subInvoiceLines;
    }

    public void setSubInvoiceLines(ArrayList<SubInvoiceLine> subInvoiceLines) {
        this.subInvoiceLines = subInvoiceLines;
    }
}
