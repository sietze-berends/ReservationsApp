package payment;

import java.math.BigDecimal;
import java.util.Currency;

public class SubInvoiceLine {

    private String name;
    private int amount;
    private BigDecimal price;

    public SubInvoiceLine(String name, int amount, BigDecimal price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
