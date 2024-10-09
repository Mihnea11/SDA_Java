package classes;

public class RegularUser extends User {
    public RegularUser(String username, int id) {
        super(username, id);
    }

    @Override
    public void rateMovie(Movie movie, int rating) {
        super.rateMovie(movie, rating);
    }
}

