package com.user.service.APICALLS;

import com.user.service.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RatingService")
public interface RatingFeignClient {

    @GetMapping("ratings/user/{userId}")
    List<Rating> getRatingsByUserId(@PathVariable("userId") String userId);
}