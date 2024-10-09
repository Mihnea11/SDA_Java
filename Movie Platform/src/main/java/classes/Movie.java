package classes;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String title;
    private String genre;
    private int releaseYear;
    private final List<Integer> ratings;

    public Movie(String title, String genre, int releaseYear) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.ratings = new ArrayList<>();
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public int getReleaseYear() { return releaseYear; }
    public void setReleaseYear(int releaseYear) { this.releaseYear = releaseYear; }

    public List<Integer> getRatings() { return ratings; }

    public void addRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            ratings.add(rating);
        } else {
            System.out.println("Invalid rating. Must be between 1 and 5.");
        }
    }

    public double getAverageRating() {
        return ratings.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    @Override
    public String toString() {
        return title + " (" + releaseYear + ") - " + genre + " - Avg Rating: " + getAverageRating();
    }
}
