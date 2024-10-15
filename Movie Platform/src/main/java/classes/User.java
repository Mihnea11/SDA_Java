package classes;

import classes.media_types.Movie;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String username;
    private int id;
    private Map<Movie, Integer> ratedMovies;

    public User(String username, int id) {
        this.username = username;
        this.id = id;
        this.ratedMovies = new HashMap<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Movie, Integer> getRatedMovies() {
        return ratedMovies;
    }

    public void setRatedMovies(Map<Movie, Integer> ratedMovies) {
        this.ratedMovies = ratedMovies;
    }

    public void rateMovie(Movie movie, int rating) {
        if (rating < 1 || rating > 5) {
            System.out.println("Rating should be between 1 and 5 stars.");
            return;
        }

        ratedMovies.put(movie, rating);
        movie.addRating(rating);
        System.out.println(username + " rated " + movie.getTitle() + " with " + rating + " stars.");
    }

    public boolean hasRated(Movie movie) {
        return ratedMovies.containsKey(movie);
    }
}
