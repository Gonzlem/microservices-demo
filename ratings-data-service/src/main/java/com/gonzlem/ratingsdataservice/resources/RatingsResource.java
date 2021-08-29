package com.gonzlem.ratingsdataservice.resources;

import com.gonzlem.ratingsdataservice.models.Rating;
import com.gonzlem.ratingsdataservice.models.UserRating;
import com.gonzlem.ratingsdataservice.repository.RatingRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingsResource {

    @Autowired
    private RatingRepository ratingRepository;

    @GetMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") Integer movieId) {
        return ratingRepository.findById(movieId).get();
    }

    @GetMapping
    public List<Rating> getAllRatings(){
        return ratingRepository.findAll();
    }

    // TODO: Create User entity to not hardcode this
    @GetMapping("/users/{userId}")
    // Changed the method to be more flexible by using an Object with a List of ratings rather than a List of ratings by itself.
    public UserRating getUsersRating(@PathVariable("userId") String userId) {
        List<Rating> ratings = ratingRepository.findAll();

        UserRating userRating = new UserRating();
        userRating.setUserRatings(ratings);
        return userRating;
    }
}
