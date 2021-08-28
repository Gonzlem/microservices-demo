package com.gonzlem.ratingsdataservice.models;

import java.util.LinkedList;
import java.util.List;

public class UserRating {
    private List<Rating> userRatings;

    public UserRating() {
        userRatings = new LinkedList<>();
    }

    public List<Rating> getUserRatings() {
        return userRatings;
    }

    public void setUserRatings(List<Rating> userRatings) {
        this.userRatings = userRatings;
    }
}
