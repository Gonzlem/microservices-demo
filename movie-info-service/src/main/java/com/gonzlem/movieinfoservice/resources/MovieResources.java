package com.gonzlem.movieinfoservice.resources;

import com.gonzlem.movieinfoservice.models.Movie;
import com.gonzlem.movieinfoservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieResources {
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable Integer movieId) {
        return movieRepository.findById(movieId).get();
    }
}
