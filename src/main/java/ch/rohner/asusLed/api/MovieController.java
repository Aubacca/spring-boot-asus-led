package ch.rohner.asusLed.api;

import ch.rohner.asusLed.models.Movie;
import ch.rohner.asusLed.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @RequestMapping(value = "/{movieId}", method = RequestMethod.GET)
    public Movie getMovieByid(@PathVariable("movieId") int movieId) {
        return movieService.getMoviewByid(movieId);
    }

    @RequestMapping(value = "/{movieId}", method = RequestMethod.DELETE)
    public Response deleteMovie(@PathVariable("movieId") int movieId) {
        movieService.deleteMovie(movieId);
        return Response.status(Response.Status.OK).build();
    }

    @RequestMapping(value = "/{movieId}", method = RequestMethod.PUT)
    public Response updateMovie(@PathVariable("movieId") int movieId, @RequestBody Movie newMovie) {
        if (newMovie == null || movieId == 0) {
            return Response.status(Response.Status.NO_CONTENT).entity("ERROR: No movie defined!").build();
        }
        return Response.status(Response.Status.OK).entity(movieService.updateMovie(newMovie)).build();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON)
    public Response addMovie(@RequestBody Movie newMovie) {
        if (newMovie == null) {
            return Response.status(Response.Status.NO_CONTENT).entity("ERROR: No movie defined!").build();
        }
        return Response.status(Response.Status.CREATED).entity(movieService.addMovie(newMovie)).build();
    }
}
