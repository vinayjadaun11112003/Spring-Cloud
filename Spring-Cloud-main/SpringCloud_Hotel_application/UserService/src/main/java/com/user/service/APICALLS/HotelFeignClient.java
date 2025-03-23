package com.user.service.APICALLS;

import com.user.service.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="HotelService")
public interface HotelFeignClient {

    @GetMapping("/hotels/{hotelID}")
     Hotel getHotel(@PathVariable String hotelID);
}
