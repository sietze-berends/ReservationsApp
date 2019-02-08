package com.capgemini.molvenohotel.ReserveringsApp.controller.service;

import com.capgemini.molvenohotel.ReserveringsApp.controller.repository.ReservationRepository;
import com.capgemini.molvenohotel.ReserveringsApp.controller.repository.RoomRepository;
import com.capgemini.molvenohotel.ReserveringsApp.dto.SearchDTO;
import com.capgemini.molvenohotel.ReserveringsApp.model.basics.Reservation;
import com.capgemini.molvenohotel.ReserveringsApp.model.basics.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@Transactional
public class SearchService {
    int currentCapacity;
    int currentAmountOfRooms;
    private List<Room> suggestion;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public SearchService() {
        this.currentCapacity = 0;
        this.currentAmountOfRooms = 0;
        this.suggestion = new ArrayList<>();
    }

    public List<Room> checkCapacityHelper(SearchDTO searchDTO) {
        List<Room> availableRooms = findAvailableRooms(searchDTO);
        int amountOfGuests = searchDTO.getAmountOfPersons();
        int amountOfRooms = searchDTO.getAmountOfRooms();
        return checkCapacity(availableRooms, amountOfGuests, amountOfRooms);
    }

    public List<Room> checkCapacity(List<Room> availableRooms, int amountOfGuests, int amountOfRooms) {
        // sorteer de lijst op capaciteit
        availableRooms.sort(Comparator.comparingInt(Room::getCapacityRoom).reversed());
        if (availableRooms.size() < amountOfRooms) {
            return null;
        }
        // loop alle kamers door
        for (int i = 0; i < availableRooms.size(); i++) {
            // begin met de eerste
            Room room = availableRooms.get(i);
            // als de capaciteit + de capaciteit van deze kamer teveel is, skip deze dan
            if (currentCapacity + room.getCapacityRoom() > amountOfGuests) {
                continue;
            }
            // anders, voeg em toe
            else {
                suggestion.add(room);
                currentCapacity += room.getCapacityRoom();
                currentAmountOfRooms += 1;
            }
            // als we genoeg capaciteit hebben en precies het juiste aantal kamers, dan zijn we klaar
            if (currentCapacity == amountOfGuests && currentAmountOfRooms == amountOfRooms) {
                return suggestion;
            }
        }
        // als we hier zijn is het nog niet gelukt. Gooi een kamer weg.
        availableRooms.remove(suggestion.get(0));
        suggestion.clear();
        currentCapacity = 0;
        currentAmountOfRooms = 0;


        return checkCapacity(availableRooms, amountOfGuests, amountOfRooms);
    }

    public List<Room> findAvailableRooms(SearchDTO searchDTO) {

        // convert the date strings to localdatetimes
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(searchDTO.getStart(), formatter);
        LocalDate endDate = LocalDate.parse(searchDTO.getEnd(), formatter);
        LocalDateTime startTime = LocalDateTime.of(startDate, LocalTime.of(14, 00));
        LocalDateTime endTime = LocalDateTime.of(endDate, LocalTime.of(11, 00));

        // get all the rooms
        Iterable<Room> allRooms = roomRepository.findAll();

        // get all the reservations
        Iterable<Reservation> allReservations = reservationRepository.findAll();

        // initialize an empty list with available rooms
        List<Room> availableRooms = new ArrayList<>();

        // for each room
        for (Room room : allRooms) {
            boolean available = true;

            // compare room with all reservations
            for (Reservation reservation : allReservations) {

                // if the reservation has the specified room in it, then start checking
                if (reservation.getRooms().contains(room)) {

                    // if it's not occupied, then it's available (for now, we still have to check all other reservations)
                    if (reservation.getStart().isAfter(endTime) || reservation.getEnd().isBefore(startTime)) {
                        available = true;
                    }
                    // als kamer niet beschikbaar is, stop met het checken van de overige reserveringen
                    else {
                        available = false;
                        break;
                    }
                } // if the room is not in the reservation, it's available (for now, we still have to check all other reservations)
                else {
                    available = true;
                }
            }

            // if the room is still available after checking all reservations, add it to the available rooms
            if (available) {
                availableRooms.add(room);
            }
        }

        // most expensive room first
        availableRooms.sort(Comparator.comparingDouble(Room::getPrice).reversed());
        return availableRooms;
    }

}
