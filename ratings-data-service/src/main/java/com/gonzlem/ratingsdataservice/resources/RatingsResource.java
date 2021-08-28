package com.gonzlem.ratingsdataservice.resources;

import com.gonzlem.ratingsdataservice.models.Rating;
import com.gonzlem.ratingsdataservice.models.UserRating;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingsResource {

    @GetMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 4);
    }

    @GetMapping("/users/{userId}")
    // Changed the method to be more flexible by using an Object with a List of ratings rather than a List of ratings by itself.
    public UserRating getUsersRating(@PathVariable("userId") String userId) {
        List<Rating> ratings = Arrays.asList(
                new Rating("PepaPig", 4),
                new Rating("Terminator", 3));
        UserRating userRating = new UserRating();
        userRating.setUserRatings(ratings);
        return userRating;
    }
}
