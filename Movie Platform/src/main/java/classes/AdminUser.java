package classes;

import java.util.List;

public class AdminUser extends User {
    public AdminUser(String username, int id) {
        super(username, id);
    }

    public void addMovie(List<Movie> movieList, Movie movie) {
        movieList.add(movie);
        System.out.println("Admin added the movie: " + movie.getTitle());
    }

    public void removeMovie(List<Movie> movieList, Movie movie) {
        movieList.remove(movie);
        System.out.println("Admin removed the movie: " + movie.getTitle());
    }
}