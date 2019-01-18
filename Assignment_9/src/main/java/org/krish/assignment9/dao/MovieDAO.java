package org.krish.assignment9.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.krish.assignment9.model.Movie;

public class MovieDAO {
	 private static final Map<String, Movie> movMap = new HashMap<String, Movie>();
	   
	    static {
	        initEmps();
	    }

	    private static void initEmps() {
	        Movie m1 = new Movie("M001", "Top Gun", "Tom Cruise",350000000.00f);
	        Movie m2 = new Movie("M002", "Spiderman HomeComing", "Tom Holland",350000000.00f);
	        Movie m3 = new Movie("M003", "Batmann Begins", "Christian Bale",450000000.00f);
	        Movie m4 = new Movie("M004", "Iron Man 1", "Robert Downey Jr",550000000.00f);
	        Movie m5 = new Movie("M005", "Avengers 1", "Multiple Leads",650000000.00f);
	        Movie m6 = new Movie("M006", "Iron Man 2", "Robert Downey Jr",750000000.00f);
	        Movie m7 = new Movie("M007", "Avengers Age Of Ultron", "Multiple Leads",150000000.00f);
	        Movie m8 = new Movie("M008", "Captain Marvel", "Brie Larson",760000000.00f);
	        Movie m9 = new Movie("M009", "Iron Man 3", "Robert Downey Jr",880000000.00f);
	        Movie m10 = new Movie("M010", "Avengers End Game", "Multiple Leads",1050000000.00f);
	 
	        movMap.put(m1.getMovieId(), m1);
	        movMap.put(m2.getMovieId(), m2);	    
	        movMap.put(m3.getMovieId(), m3);
	        movMap.put(m4.getMovieId(), m4);
	        movMap.put(m5.getMovieId(), m5);
	        movMap.put(m6.getMovieId(), m6);
	        movMap.put(m7.getMovieId(), m7);
	        movMap.put(m8.getMovieId(), m8);
	        movMap.put(m9.getMovieId(), m9);
	        movMap.put(m10.getMovieId(), m10);
	  }

		public static List<Movie> getAllMovies() {
			Collection<Movie> c = movMap.values();
	        List<Movie> list = new ArrayList<Movie>();
	        list.addAll(c);
	        return list;
		}

		public static Movie getMovie(String movieId) {
			return movMap.get(movieId);
		}
}
