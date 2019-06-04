package ch.rohner.asusLed.daos;

import ch.rohner.asusLed.models.Movie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("neoMovieDao")
//@Primary
public class NeoMovieDaoImpl implements MovieDao {
    private static Map<Integer, Movie> movieDB;

    static {
        movieDB = new HashMap<Integer, Movie>(){
            {
                put(100, new Movie(100, "The Mummy legends", "Action"));
                put(101, new Movie(101, "Jarhead", "War"));
            }};
    }

    @Override
    public void delete(int movieId) {
        movieDB.remove(movieId);
    }

    @Override
    public Collection<Movie> findAll() {
        return movieDB.values();
    }

    @Override
    public Movie findMovieById(int movieId) {
        return movieDB.get(movieId);
    }

    @Override
    public Movie insert(Movie newMovie) {
        return movieDB.put(newMovie.getId(), newMovie);
    }

    @Override
    public Movie update(Movie changedMovie) {
        movieDB.remove(changedMovie.getId());
        movieDB.put(changedMovie.getId(), changedMovie);
        return findMovieById(changedMovie.getId());
    }
}
