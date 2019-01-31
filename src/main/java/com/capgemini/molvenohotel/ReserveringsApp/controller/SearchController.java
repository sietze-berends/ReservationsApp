package com.capgemini.molvenohotel.ReserveringsApp.controller;

import com.capgemini.molvenohotel.ReserveringsApp.basics.Room;
import com.capgemini.molvenohotel.ReserveringsApp.hotel.Hotel;
import com.capgemini.molvenohotel.ReserveringsApp.hotel.InitializeHotel;
import com.capgemini.molvenohotel.ReserveringsApp.search.SearchDetails;
import com.capgemini.molvenohotel.ReserveringsApp.search.SearchModule;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import static java.time.LocalDateTime.of;


@RestController
@RequestMapping(value = "/hotel")
public class SearchController {
    private InitializeHotel initializeHotel = new InitializeHotel();
    private Hotel hotel = initializeHotel.makeMolveno();
    private SearchModule searchModule = new SearchModule();

    @PostMapping(path = "/search")
    public List<Room> searchRoom(@RequestBody SearchDetails searchDetails) {
        System.out.println(searchDetails.getStart());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate startDate = LocalDate.parse(searchDetails.getStart(), formatter);
        LocalDate endDate = LocalDate.parse(searchDetails.getEnd(), formatter);

        LocalDateTime startTime = LocalDateTime.of(startDate, LocalTime.of(14,00));
        LocalDateTime endTime = LocalDateTime.of(endDate, LocalTime.of(11,00));


        return searchModule.searchSuggestion(startTime, endTime, searchDetails.getAmountOfPersons(),
                searchDetails.getAmountOfRooms(), hotel);
    }
}
