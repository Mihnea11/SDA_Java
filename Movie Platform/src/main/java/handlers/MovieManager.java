package handlers;

import classes.media_types.Movie;
import classes.media_types.Series;
import classes.User;

import java.util.ArrayList;
import java.util.List;

public class MovieManager {
    private List<Movie> movieCatalog;
    private List<Series> seriesCatalog;
    private List<User> users;

    public MovieManager() {
        movieCatalog = new ArrayList<>();
        seriesCatalog = new ArrayList<>();
        users = new ArrayList<>();
    }

    public List<Movie> getMovieCatalog() {
        return movieCatalog;
    }

    public List<Series> getSeriesCatalog() {
        return seriesCatalog;
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("Added user: " + user.getUsername());
    }

    public void displayMovies() {
        System.out.println("\nMovie Catalog:");
        for (Movie movie : movieCatalog) {
            System.out.println("Title: " + movie.getTitle() + " | Genre: " + movie.getGenre() + " | Duration: " + movie.getDuration() + " minutes");
        }
    }

    public void displaySeries() {
        System.out.println("\nSeries Catalog:");
        for (Series series : seriesCatalog) {
            System.out.println("Title: " + series.getTitle() + " | Genre: " + series.getGenre() + " | Seasons: " + series.getSeasons());
            System.out.println("Episodes: " + String.join(", ", series.getEpisodes()));
        }
    }
}
