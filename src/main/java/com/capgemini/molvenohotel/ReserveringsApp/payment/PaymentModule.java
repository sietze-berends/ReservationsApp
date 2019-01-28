package com.capgemini.molvenohotel.ReserveringsApp.payment;

import com.capgemini.molvenohotel.ReserveringsApp.basics.Reservation;
import com.capgemini.molvenohotel.ReserveringsApp.basics.Room;

public class PaymentModule {
    public PaymentModule() {

    }

    // TODO
    // add day aspect of rooms (book for 100 eur x 5 days instead of just price)
    public double makeInvoice(Reservation reservation) {
        double totalPrice = 0;
        for (int i = 0; i < reservation.getRooms().size(); i++) {
            Room room = reservation.getRooms().get(i);
            totalPrice += room.getPrice();
        }
        return totalPrice;
    }
}
