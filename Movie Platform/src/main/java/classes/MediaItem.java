package classes;

import enums.Genre;

public abstract class MediaItem {
    private String title;
    private int releaseYear;
    private Genre genre;
    private String trailerLink;

    public MediaItem(String title, int releaseYear, Genre genre, String trailerLink) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.trailerLink = trailerLink;
    }

    public abstract void play();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getTrailerLink() {
        return trailerLink;
    }

    public void setTrailerLink(String trailerLink) {
        this.trailerLink = trailerLink;
    }
}

