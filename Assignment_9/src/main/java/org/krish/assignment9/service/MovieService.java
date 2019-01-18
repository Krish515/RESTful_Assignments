package org.krish.assignment9.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.krish.assignment9.dao.MovieDAO;
import org.krish.assignment9.model.Movie;

@Path("/movies")
public class MovieService {
	@GET
    @Produces({MediaType.APPLICATION_XML})
    public List<Movie> getApplicationXML() {
        List<Movie> listOfMovies = MovieDAO.getAllMovies();
        return listOfMovies;
    }
	@GET
	@Path("/text_xml")
    @Produces({ MediaType.TEXT_XML})
    public List<Movie> getTextXML() {
        List<Movie> listOfMovies = MovieDAO.getAllMovies();
        return listOfMovies;
    }
	@GET
	@Path("/application_json")
    @Produces({ MediaType.APPLICATION_JSON})
    public List<Movie> getApplicationJSON() {
        List<Movie> listOfMovies = MovieDAO.getAllMovies();
        return listOfMovies;
    }
	@GET
	@Path("/{movieId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Movie getOneMovie(@PathParam("movieId") String movieId) {
	    return MovieDAO.getMovie(movieId);
	}
}
