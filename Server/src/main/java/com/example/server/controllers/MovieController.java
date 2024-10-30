package com.example.server.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    // Endpoint to get a list of movies
    @GetMapping
    public List<Movie> getAllMovies() {
        return Arrays.asList(
                new Movie(1, "The Shawshank Redemption", "Drama", 1994),
                new Movie(2, "The Godfather", "Crime", 1972),
                new Movie(3, "Inception", "Sci-Fi", 2010)
        );
    }

    // Endpoint to get a movie by ID
    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable int id) {
        return new Movie(id, "The Shawshank Redemption", "Drama", 1994);
    }

    // Movie data model
    static class Movie {
        private int id;
        private String title;
        private String genre;
        private int year;

        public Movie(int id, String title, String genre, int year) {
            this.id = id;
            this.title = title;
            this.genre = genre;
            this.year = year;
        }

        public int getId() { return id; }
        public String getTitle() { return title; }
        public String getGenre() { return genre; }
        public int getYear() { return year; }
    }
}
