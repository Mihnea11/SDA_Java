package org.example;

import classes.user_roles.AdminUser;
import classes.media_types.Movie;
import classes.media_types.Series;
import classes.user_roles.RegularUser;
import classes.User;
import enums.Genre;
import handlers.MovieManager;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MovieManager movieManager = new MovieManager();

        // Create movies and series
        Movie inception = new Movie("Inception", 2010, Genre.SCI_FI, 148, "https://link-to-inception-trailer", "Christopher Nolan");
        Movie matrix = new Movie("The Matrix", 1999, Genre.SCI_FI, 136, "https://link-to-matrix-trailer", "The Wachowskis");
        Series breakingBad = new Series("Breaking Bad", 2008, Genre.DRAMA, 5, "https://link-to-breaking-bad-trailer");

        // Add initial episodes to the series
        breakingBad.addEpisode("Pilot");
        breakingBad.addEpisode("Cat's in the Bag...");
        breakingBad.addEpisode("...And the Bag's in the River");

        // Add users
        User regularUser = new RegularUser("john_doe", 1);
        AdminUser admin = new AdminUser("admin_01", 2);

        // Add users to the movie manager
        movieManager.addUser(regularUser);
        movieManager.addUser(admin);

        // Admin adds movies and series to the catalog
        admin.addMovie(movieManager.getMovieCatalog(), inception);
        admin.addMovie(movieManager.getMovieCatalog(), matrix);
        admin.addSeries(movieManager.getSeriesCatalog(), breakingBad);

        // Display the current movie and series catalog
        movieManager.displayMovies();
        movieManager.displaySeries();

        // Regular user rates a movie
        regularUser.rateMovie(inception, 5);
        regularUser.rateMovie(matrix, 4);
        admin.rateMovie(matrix, 5); // Admin also rates a movie

        // Regular user adds a movie to the watchlist
        ((RegularUser) regularUser).addToWatchlist(inception);
        ((RegularUser) regularUser).addToWatchlist(matrix);

        // Admin edits a movie's details
        admin.editMovieDetails(inception, "Inception (Extended)", Genre.SCI_FI, 152, "Christopher Nolan", Arrays.asList("Leonardo DiCaprio", "Joseph Gordon-Levitt"));

        // Admin edits the series details
        admin.editSeriesDetails(breakingBad, "Breaking Bad (Special Edition)", Genre.DRAMA, 5, Arrays.asList("Pilot", "Felina"));

        // Display updated movie and series catalog after edits
        movieManager.displayMovies();
        movieManager.displaySeries();

        // Display watchlist of the regular user
        System.out.println("Watchlist of " + regularUser.getUsername() + ": ");
        ((RegularUser) regularUser).getWatchlist().forEach(movie -> System.out.println(movie.getTitle()));
    }
}
