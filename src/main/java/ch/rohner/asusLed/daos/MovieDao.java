package ch.rohner.asusLed.daos;

import ch.rohner.asusLed.models.Movie;

import java.util.Collection;

public interface MovieDao {

    public void delete(int movieId);

    public Collection<Movie> findAll();

    public Movie findMovieById(int movieId);

    public Movie insert(Movie newMovie);

    public Movie update(Movie changedMovie);
}
