package ch.rohner.asusLed.daos;

import ch.rohner.asusLed.models.Movie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("mockMovieDao")
public class MockMovieDaoImpl implements MovieDao {
    private static Map<Integer, Movie> movies;

    static {
        movies = new HashMap<Integer, Movie>(){
            {
                put(1, new Movie(1, "Jarhead", "War"));
                put(2, new Movie(2, "Back to the Future", "Fantasy"));
                put(3, new Movie(3, "The Mummy Legend", "Adventure"));
                put(4, new Movie(4, "Mindhunter", "Science Fiction"));
            }
        };
    }


    @Override
    public void delete(int movieId) {
        movies.remove(movieId);
    }

    @Override
    public Collection<Movie> findAll() {
        return movies.values();
    }

    @Override
    public Movie findMovieById(int movieId) {
        return movies.get(movieId);
    }

    @Override
    public Movie insert(Movie newMovie) {
        movies.put(newMovie.getId(), newMovie);
        return movies.get((newMovie.getId()));
    }

    @Override
    public Movie update(Movie changedMovie) {
        movies.remove(changedMovie.getId());
        Movie newMovie = movies.put(changedMovie.getId(), changedMovie);
        return newMovie;
    }
}
