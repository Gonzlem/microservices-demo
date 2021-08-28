package com.gonzlem.moviecatalogservce.resources;

import com.gonzlem.moviecatalogservce.models.CatalogItem;
import com.gonzlem.moviecatalogservce.models.Movie;
import com.gonzlem.moviecatalogservce.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalogs")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")
    private List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
//        RestTemplate restTemplate = new RestTemplate(); // We no longer need this as we created a Bean to provide the singleton for us.

        List<Rating> ratings = Arrays.asList(
                new Rating("PepaPig", 4),
                new Rating("Terminator", 3));

        return ratings.stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://localhost:8081/movies/" + rating.getMovieId(), Movie.class);
            return new CatalogItem(movie.getTitle(), movie.getDescription(), rating.getRating());
        }).collect(Collectors.toList());
    }
}
