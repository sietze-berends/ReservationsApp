package com.capgemini.molvenohotel.ReserveringsApp.api;

import com.capgemini.molvenohotel.ReserveringsApp.controller.service.SearchService;
import com.capgemini.molvenohotel.ReserveringsApp.model.basics.Room;
import com.capgemini.molvenohotel.ReserveringsApp.dto.SearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping("/hotel")
public class SearchEndPoint {

    @Autowired
    private SearchService searchService;

    @Consumes(MediaType.APPLICATION_JSON)
    @PostMapping("/search")
    public List<Room> search(@RequestBody SearchDTO searchDTO) {
        return searchService.checkCapacityHelper(searchDTO);
    }

}