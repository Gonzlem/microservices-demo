package com.gonzlem.moviecatalogservce.resources;

import com.gonzlem.moviecatalogservce.models.CatalogItem;
import com.gonzlem.moviecatalogservce.models.Movie;
import com.gonzlem.moviecatalogservce.models.Rating;
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

    @GetMapping("/{userId}")
    private List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject("http://localhost:8081/movies/foo", Movie.class);

        List<Rating> ratings = Arrays.asList(
                new Rating("PepaPig", 4),
                new Rating("Terminator", 3));

        return ratings.stream().map(rating -> new CatalogItem("Terminator", "Test", 4))
                .collect(Collectors.toList());
    }
}
