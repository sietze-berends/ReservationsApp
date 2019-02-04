package com.capgemini.molvenohotel.ReserveringsApp.model.payment;

import com.capgemini.molvenohotel.ReserveringsApp.model.basics.Reservation;
import com.capgemini.molvenohotel.ReserveringsApp.model.basics.Room;

import java.time.Duration;

public class PaymentModule {
    public PaymentModule() {

    }

    // TODO
    // add day aspect of rooms (book for 100 eur x 5 days instead of just price)
    public double makeInvoice(Reservation reservation) {
        double totalPrice = 0;
        long amountOfNights = Duration.between(reservation.getStart().toLocalDate().atStartOfDay()
                , reservation.getEnd().toLocalDate().atStartOfDay()).toDays();

        for (int i = 0; i < reservation.getRooms().size(); i++) {
            Room room = reservation.getRooms().get(i);
            totalPrice += room.getPrice();
        }

        return totalPrice * amountOfNights;
    }
}
