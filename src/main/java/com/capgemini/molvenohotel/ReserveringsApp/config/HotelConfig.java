package com.capgemini.molvenohotel.ReserveringsApp.config;

import com.capgemini.molvenohotel.ReserveringsApp.hotel.Hotel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HotelConfig {

    @Value("${hotel.name}")
    private String name;
    @Value("${hotel.telno:4567}")
    private String telNo;
    @Value("${hotel.email}")
    private String email;

    @Bean
    Hotel initHotel() {
            return new Hotel(name, telNo, email);
}
}
