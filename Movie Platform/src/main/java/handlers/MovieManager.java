package handlers;

import classes.Movie;
import classes.User;

import java.util.ArrayList;
import java.util.List;

public class MovieManager {
    private List<Movie> movieCatalog = new ArrayList<>();
    private List<User> userList = new ArrayList<>();

    public MovieManager() {
        movieCatalog.add(new Movie("Inception", "Sci-Fi", 2010));
        movieCatalog.add(new Movie("The Matrix", "Action", 1999));
    }

    public List<Movie> getMovieCatalog() { return movieCatalog; }
    public List<User> getUserList() { return userList; }

    public void addUser(User user) {
        userList.add(user);
        System.out.println("User " + user.getUsername() + " added.");
    }

    public void displayMovies() {
        movieCatalog.forEach(System.out::println);
    }
}
