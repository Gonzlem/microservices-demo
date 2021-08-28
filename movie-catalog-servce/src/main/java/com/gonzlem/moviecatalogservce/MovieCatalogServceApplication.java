package com.gonzlem.moviecatalogservce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MovieCatalogServceApplication {
    @Bean
    public RestTemplate getRestTemplate(){ // Provide a singleton for every class to be able to use it.
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(MovieCatalogServceApplication.class, args);
    }

}
