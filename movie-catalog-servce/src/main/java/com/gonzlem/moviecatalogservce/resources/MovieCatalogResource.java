package com.gonzlem.moviecatalogservce.resources;

import com.gonzlem.moviecatalogservce.models.CatalogItem;
import com.gonzlem.moviecatalogservce.models.Movie;
import com.gonzlem.moviecatalogservce.models.Rating;
import com.gonzlem.moviecatalogservce.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalogs")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webBuilder;

    @GetMapping("/{userId}")
    private List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
//        RestTemplate restTemplate = new RestTemplate(); // We no longer need this as we created a Bean to provide the singleton for us.
        UserRating ratings = webBuilder.build().get().uri(String.format("http://localhost:8082/ratings/users/%s", userId)).
                retrieve().
                bodyToMono(UserRating.class).
                block();
//
//        return ratings.stream().map(rating -> {
//            Movie movie = restTemplate.getForObject("http://localhost:8081/movies/" + rating.getMovieId(), Movie.class);
//            return new CatalogItem(movie.getTitle(), movie.getDescription(), rating.getRating());
//        }).collect(Collectors.toList());

        // Newer way to do the rest call with WebClient counterpart to RestTemplate w/async.
        return ratings.getUserRatings().stream().map(rating -> {
            Movie movie = webBuilder.build().get().
                    uri(String.format("http://localhost:8081/movies/%s", rating.getMovieId())).
                    retrieve().
                    bodyToMono(Movie.class). // Mono is a reactive way to say we're getting the object asynchronously.
                    block(); // As we are not doing the method return a Mono<> instance, we have to wait till we have the object already created before we can return it. So we're not fully using async.
            return new CatalogItem(movie.getTitle(), movie.getDescription(), rating.getRating());
        }).collect(Collectors.toList());
    }
}
