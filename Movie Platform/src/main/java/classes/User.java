package classes;

public class User {
    private String username;
    private int id;

    public User(String username, int id) {
        this.username = username;
        this.id = id;
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public void rateMovie(Movie movie, int rating) {
        movie.addRating(rating);
        System.out.println(username + " rated " + movie.getTitle() + " with " + rating + " stars.");
    }
}
