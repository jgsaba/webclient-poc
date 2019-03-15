package com.example.consumer.service;

import com.example.consumer.domain.Movie;
import reactor.core.publisher.Mono;

public interface MovieClientService {

    public Mono<Movie> searchMovieByTitle(String apiKey, String title);
    public Mono<Movie> searchMovieById(String apiKey, String imdbId);
}
