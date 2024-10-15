package classes.media_types;

import classes.MediaItem;
import enums.Genre;
import interfaces.Playable;

import java.util.ArrayList;
import java.util.List;

public class Movie extends MediaItem implements Playable {
    private int duration; // Duration in minutes
    private List<Integer> ratings; // Stores the movie ratings
    private List<String> reviews; // Stores user reviews
    private String director; // Director of the movie
    private List<String> cast; // Cast members

    public Movie(String title, int releaseYear, Genre genre, int duration, String trailerLink, String director) {
        super(title, releaseYear, genre, trailerLink);
        this.duration = duration;
        this.ratings = new ArrayList<>();
        this.reviews = new ArrayList<>();
        this.director = director;
        this.cast = new ArrayList<>();
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<Integer> getRatings() {
        return ratings;
    }

    public void setRatings(List<Integer> ratings) {
        this.ratings = ratings;
    }

    public List<String> getReviews() {
        return reviews;
    }

    public void setReviews(List<String> reviews) {
        this.reviews = reviews;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<String> getCast() {
        return cast;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    @Override
    public void play() {
        System.out.println("Now playing movie: " + getTitle());

        // Logic to open and play trailer in the UI

        System.out.println("Trailer link: " + getTrailerLink());
    }

    public void addRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            ratings.add(rating);
            System.out.println("Rating added: " + rating + " stars.");
        } else {
            System.out.println("Invalid rating. It must be between 1 and 5 stars.");
        }
    }

    public double getAverageRating() {
        if (ratings.isEmpty()) return 0;
        int sum = ratings.stream().mapToInt(Integer::intValue).sum();
        return (double) sum / ratings.size();
    }

    public void addReview(String review) {
        reviews.add(review);
        System.out.println("Review added: " + review);
    }

    public void addCastMember(String castMember) {
        if (!cast.contains(castMember)) {
            cast.add(castMember);
            System.out.println(castMember + " added to the cast.");
        } else {
            System.out.println(castMember + " is already in the cast.");
        }
    }
}
