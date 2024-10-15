package classes.media_types;

import classes.MediaItem;
import enums.Genre;
import interfaces.Playable;

import java.util.ArrayList;
import java.util.List;

public class Series extends MediaItem implements Playable {
    private int seasons;
    private List<String> episodes;
    private List<Integer> ratings;
    private List<String> reviews;

    public Series(String title, int releaseYear, Genre genre, int seasons, String trailerLink) {
        super(title, releaseYear, genre, trailerLink);
        this.seasons = seasons;
        this.episodes = new ArrayList<>();
        this.ratings = new ArrayList<>();
        this.reviews = new ArrayList<>();
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public List<String> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<String> episodes) {
        this.episodes = episodes;
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

    @Override
    public void play() {
        System.out.println("Now playing series: " + getTitle());

        // Logic to open and play trailer in the UI

        System.out.println("Trailer link: " + getTrailerLink());
    }

    public void addEpisode(String episodeTitle) {
        if (!episodes.contains(episodeTitle)) {
            episodes.add(episodeTitle);
            System.out.println("Episode added: " + episodeTitle);
        } else {
            System.out.println("Episode " + episodeTitle + " already exists.");
        }
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
}
