package com.capgemini.molvenohotel.ReserveringsApp.initializer;

import com.capgemini.molvenohotel.ReserveringsApp.model.basics.user.ExtraGuest;
import java.util.ArrayList;
import java.util.List;

/**
 * Initializes extra guests for molveno
 */

public class InitializeExtraGuests {

    private List<ExtraGuest> extraGuests = new ArrayList<>();

    public InitializeExtraGuests() {
        extraGuests.add(new ExtraGuest("Kelvin", "Kalt", "American"));
        extraGuests.add(new ExtraGuest("Avinash", "Soerdjbali", "Hindustani"));
        extraGuests.add(new ExtraGuest("Leon", "Zwakenberg", "Dutch"));
    }

    public List<ExtraGuest> getExtraGuests() {
        return extraGuests;
    }
}
