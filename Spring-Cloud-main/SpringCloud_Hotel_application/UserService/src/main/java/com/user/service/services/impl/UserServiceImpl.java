package com.user.service.services.impl;

import com.user.service.APICALLS.HotelFeignClient;
import com.user.service.APICALLS.RatingFeignClient;
import com.user.service.entities.Hotel;
import com.user.service.entities.Rating;
import com.user.service.entities.User;
import com.user.service.exception.ResourceNotFountException;
import com.user.service.repositories.UserRepository;
import com.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {


     @Autowired
     private RatingFeignClient ratingFeignClient;

     @Autowired
     private HotelFeignClient hotelFeignClient;

     @Autowired
     private UserRepository userRepository;

     @Override
     public User saveUser(User user) {
          String randomUserId = UUID.randomUUID().toString();
          user.setUserId(randomUserId);
          return userRepository.save(user);
     }



     @Override
     public List<User> getAllUser() {
          List<User> users = userRepository.findAll();

          // Fetch ratings for each user and set them
          users.forEach(user -> {
               List<Rating> ratings = ratingFeignClient.getRatingsByUserId(user.getUserId());
               ratings.forEach(rating->{
                    Hotel hotel = hotelFeignClient.getHotel(rating.getHotelId());
                    rating.setHotel(hotel);
               });
               user.setRatings(ratings);
          });

          return users;
     }

     @Override
     public User getUser(String userId) {
           User user=userRepository.findById(userId).orElseThrow(()-> new ResourceNotFountException("User with given id is not found on server !!" + userId));
           List<Rating> rating = ratingFeignClient.getRatingsByUserId(user.getUserId());
           user.setRatings(rating);
           return user;
     }
}
