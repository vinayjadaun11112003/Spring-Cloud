package com.lcwe.rating.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Data
@Entity
@Table(name= "user_ratings")
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class Rating  {

    @Id
    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;

    public int getRating() {
        return rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public String getRatingId() {
        return ratingId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getUserId() {
        return userId;
    }

    public void setRatingId(String id){
        this.ratingId=id;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
