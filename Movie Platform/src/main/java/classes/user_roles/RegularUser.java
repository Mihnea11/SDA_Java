package classes.user_roles;

import classes.User;
import classes.media_types.Movie;
import java.util.ArrayList;
import java.util.List;

public class RegularUser extends User {
    private List<Movie> watchlist;

    public RegularUser(String username, int id) {
        super(username, id);
        this.watchlist = new ArrayList<>();
    }

    public List<Movie> getWatchlist() {
        return watchlist;
    }

    public void setWatchlist(List<Movie> watchlist) {
        this.watchlist = watchlist;
    }

    public void addToWatchlist(Movie movie) {
        if (!watchlist.contains(movie)) {
            watchlist.add(movie);
            System.out.println(getUsername() + " added " + movie.getTitle() + " to their watchlist.");
        } else {
            System.out.println(movie.getTitle() + " is already in the watchlist.");
        }
    }

    public void removeFromWatchlist(Movie movie) {
        if (watchlist.contains(movie)) {
            watchlist.remove(movie);
            System.out.println(getUsername() + " removed " + movie.getTitle() + " from their watchlist.");
        } else {
            System.out.println(movie.getTitle() + " is not in the watchlist.");
        }
    }

    @Override
    public void rateMovie(Movie movie, int rating) {
        if (!hasRated(movie)) {
            super.rateMovie(movie, rating);
        } else {
            System.out.println(getUsername() + " has already rated " + movie.getTitle() + ".");
        }
    }
}
