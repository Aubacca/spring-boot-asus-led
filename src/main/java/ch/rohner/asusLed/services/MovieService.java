package ch.rohner.asusLed.services;

import ch.rohner.asusLed.daos.MovieDao;
import ch.rohner.asusLed.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MovieService {
    @Qualifier("mockMovieDao")
    @Autowired
    private MovieDao movieDao;

    public Collection<Movie> getAllMovies() {
        return movieDao.findAll();
    }

    public Movie getMoviewByid(int movieId) {
        return movieDao.findMovieById(movieId);
    }

    public void deleteMovie(int movieId) {
        movieDao.delete(movieId);
    }

    public Movie updateMovie(Movie updateMovie) {
        return movieDao.update(updateMovie);
    }

    public Movie addMovie(Movie newMovie) {
        return movieDao.insert(newMovie);
    }
}
