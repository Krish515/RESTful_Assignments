package org.krish.assignment9.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "movie")
@XmlAccessorType(XmlAccessType.FIELD)
public class Movie {
  private String movieId;
  private String movieName;
  private String movieActor;
  private float movieCollection;
  
  public Movie(){};
  public Movie(String movieId,String movieName,String movieActor,float movieCollection){
	  this.movieId=movieId;
	  this.movieName=movieName;
	  this.movieActor=movieActor;
	  this.movieCollection=movieCollection;
  };
public String getMovieId() {
	return movieId;
}
public void setMovieId(String movieId) {
	this.movieId = movieId;
}
public String getMovieName() {
	return movieName;
}
public void setMovieName(String movieName) {
	this.movieName = movieName;
}
public String getMovieActor() {
	return movieActor;
}
public void setMovieActor(String movieActor) {
	this.movieActor = movieActor;
}
public float getMovieCollection() {
	return movieCollection;
}
public void setMovieCollection(float movieCollection) {
	this.movieCollection = movieCollection;
}
}
