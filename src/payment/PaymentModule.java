package payment;

import basics.Reservation;
import basics.Room;

public class PaymentModule {
    public PaymentModule() {

    }

    public double makeInvoice(Reservation reservation) {
        double totalPrice = 0;
        for (int i = 0; i < reservation.getRooms().size(); i++) {
            Room room = reservation.getRooms().get(i);
            totalPrice += room.getPrice();
        }
        return totalPrice;
    }
}
