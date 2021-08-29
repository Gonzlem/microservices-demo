package com.gonzlem.moviecatalogservce.models;

import javax.persistence.*;

@Entity
@Table(name = "ratings")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer movieId;
    @Column
    private int rating;

    public Rating(Integer movieId, int rating) {
        this.movieId = movieId;
        this.rating = rating;
    }

    public Rating() {
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "movieId=" + movieId +
                ", rating=" + rating +
                '}';
    }
}
