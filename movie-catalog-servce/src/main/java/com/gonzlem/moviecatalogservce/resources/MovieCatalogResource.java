package com.gonzlem.moviecatalogservce.resources;

import com.gonzlem.moviecatalogservce.models.CatalogItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/catalogs")
public class MovieCatalogResource {

    @GetMapping("/{userId}")
    private List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        return Arrays.asList(
                new CatalogItem("Test movie", "Test", 5),
                new CatalogItem("Test movie 2", "Test 2", 4)
        );
    }
}
