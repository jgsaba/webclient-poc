package com.example.consumer.service;

import com.example.consumer.domain.Movie;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class MovieClientServiceImpl implements  MovieClientService{

    private WebClient webClient;

    public MovieClientServiceImpl(){
        this.webClient = WebClient.builder()
                .baseUrl("http://omdbapi.com")
                .defaultHeader(HttpHeaders.CONTENT_TYPE,"application/json")
                .defaultHeader(HttpHeaders.USER_AGENT, "Spring 5 WebClient")
                .build();
    }

    @Override
    public Mono<Movie> searchMovieByTitle(String apiKey, String title) {
        return webClient.post()
                .uri("/?apikey="+ apiKey + "&t="+ title)
                .retrieve()
                .bodyToMono(Movie.class);
    }

    @Override
    public Mono<Movie> searchMovieById(String apiKey, String imdbId) {

        return webClient.post()
                .uri("/?apiKey=" + apiKey + "&i=" + imdbId)
                .retrieve()
                .bodyToMono(Movie.class);
    }
}
