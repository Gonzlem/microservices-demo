package com.gonzlem.ratingsdataservice.repository;

import com.gonzlem.ratingsdataservice.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
}
