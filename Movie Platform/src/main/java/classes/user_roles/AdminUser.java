package classes.user_roles;

import classes.User;
import classes.media_types.Movie;
import classes.media_types.Series;
import enums.Genre;

import java.util.List;

public class AdminUser extends User {

    public AdminUser(String username, int id) {
        super(username, id);
    }

    public void addMovie(List<Movie> movieList, Movie movie) {
        if (!movieList.contains(movie)) {
            movieList.add(movie);
            System.out.println("Admin " + getUsername() + " added the movie: " + movie.getTitle());
        } else {
            System.out.println(movie.getTitle() + " already exists in the list.");
        }
    }

    public void removeMovie(List<Movie> movieList, Movie movie) {
        if (movieList.contains(movie)) {
            movieList.remove(movie);
            System.out.println("Admin " + getUsername() + " removed the movie: " + movie.getTitle());
        } else {
            System.out.println(movie.getTitle() + " does not exist in the list.");
        }
    }

    public void editMovieDetails(Movie movie, String newTitle, Genre newGenre, int newDuration, String newDirector, List<String> newCast) {
        movie.setTitle(newTitle);
        movie.setGenre(newGenre);
        movie.setDuration(newDuration);
        movie.setDirector(newDirector);
        movie.getCast().clear();
        movie.getCast().addAll(newCast);

        System.out.println("Admin " + getUsername() + " updated movie details:");
        System.out.println("Title: " + movie.getTitle() + " | Genre: " + movie.getGenre() + " | Duration: " + movie.getDuration() + " minutes");
        System.out.println("Director: " + movie.getDirector() + " | Cast: " + String.join(", ", movie.getCast()));
    }

    public void addSeries(List<Series> seriesList, Series series) {
        if (!seriesList.contains(series)) {
            seriesList.add(series);
            System.out.println("Admin " + getUsername() + " added the series: " + series.getTitle());
        } else {
            System.out.println(series.getTitle() + " already exists in the list.");
        }
    }

    public void removeSeries(List<Series> seriesList, Series series) {
        if (seriesList.contains(series)) {
            seriesList.remove(series);
            System.out.println("Admin " + getUsername() + " removed the series: " + series.getTitle());
        } else {
            System.out.println(series.getTitle() + " does not exist in the list.");
        }
    }

    public void editSeriesDetails(Series series, String newTitle, Genre newGenre, int newSeasons, List<String> newEpisodes) {
        series.setTitle(newTitle);
        series.setGenre(newGenre);
        series.setSeasons(newSeasons);
        series.getEpisodes().clear();
        series.getEpisodes().addAll(newEpisodes);

        System.out.println("Admin " + getUsername() + " updated series details:");
        System.out.println("Title: " + series.getTitle() + " | Genre: " + series.getGenre() + " | Seasons: " + series.getSeasons());
        System.out.println("Episodes: " + String.join(", ", series.getEpisodes()));
    }
}
