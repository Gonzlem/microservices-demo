package com.gonzlem.moviecatalogservce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient
public class MovieCatalogServceApplication {
    @Bean
    public RestTemplate getRestTemplate() { // Provide a singleton for every class to be able to use it.
        return new RestTemplate();
    }

    @Bean
    @LoadBalanced // It enables service discovery in a load balanced way
    public WebClient.Builder getWebClientBuilder() {
        return WebClient.builder();
    }

    public static void main(String[] args) {
        SpringApplication.run(MovieCatalogServceApplication.class, args);
    }

}
