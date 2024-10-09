package org.example;

import classes.AdminUser;
import classes.Movie;
import classes.RegularUser;
import classes.User;
import handlers.MovieManager;

public class Main {
    public static void main(String[] args) {
        MovieManager movieManager = new MovieManager();

        // Add users
        User user1 = new RegularUser("john_doe", 1);
        User admin = new AdminUser("admin_01", 2);
        movieManager.addUser(user1);
        movieManager.addUser(admin);

        // Display the current movie catalog
        movieManager.displayMovies();

        // Users rate movies
        user1.rateMovie(movieManager.getMovieCatalog().get(0), 5);  // John rates Inception
        admin.rateMovie(movieManager.getMovieCatalog().get(1), 4);  // Admin rates The Matrix

        // Admin can add a new movie (functionality to be expanded later)
        ((AdminUser) admin).addMovie(movieManager.getMovieCatalog(), new Movie("Interstellar", "Sci-Fi", 2014));

        // Display updated movie catalog
        movieManager.displayMovies();
    }
}