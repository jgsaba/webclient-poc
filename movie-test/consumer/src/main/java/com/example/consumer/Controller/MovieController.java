package com.example.consumer.Controller;

import com.example.consumer.domain.Movie;
import com.example.consumer.service.MovieClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class MovieController {

    @Autowired
    private MovieClientService movieClientService;

    @GetMapping("/title/{name}")
    public Mono<Movie> getMovieByTitle(@PathVariable String name){
        String apiKey = "bb20d2b9";
        return movieClientService.searchMovieByTitle(apiKey, name);
    }
}
