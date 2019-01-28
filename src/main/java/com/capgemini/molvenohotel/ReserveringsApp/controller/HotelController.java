package com.capgemini.molvenohotel.ReserveringsApp.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hotel")
public class HotelController {

    @GetMapping(path = "/contact")
    public String getHotelContactInfo() {
        return "Look! Here's some useless hotel info. It is somewhere in China. Bye Bye";
    }

    @RequestMapping(value = "/index")
    public String helloWord(){
        return "Spring is running!";
    }


}
