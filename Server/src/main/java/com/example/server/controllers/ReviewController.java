package com.example.server.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    // Endpoint to get reviews for a specific movie
    @GetMapping("/movie/{movieId}")
    public List<Review> getReviewsByMovieId(@PathVariable int movieId) {
        return Arrays.asList(
                new Review(1, movieId, "Great movie, a must-watch!", 5),
                new Review(2, movieId, "A timeless classic!", 4)
        );
    }

    // POST method for testing purposes
    @PostMapping("/test")
    public String testPostMethod(@RequestBody String message) {
        System.out.println("POST method accessed: " + message);
        return "Received POST request with message: " + message;
    }

    // Review data model
    static class Review {
        private int reviewId;
        private int movieId;
        private String comment;
        private int rating;

        public Review(int reviewId, int movieId, String comment, int rating) {
            this.reviewId = reviewId;
            this.movieId = movieId;
            this.comment = comment;
            this.rating = rating;
        }

        public int getReviewId() { return reviewId; }
        public int getMovieId() { return movieId; }
        public String getComment() { return comment; }
        public int getRating() { return rating; }
    }
}
