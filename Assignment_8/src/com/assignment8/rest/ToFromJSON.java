package com.assignment8.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.assignment8.util.Album;

@Path("/albums")
public class ToFromJSON {
	@GET
	@Path("/toJSON")
	@Produces(MediaType.APPLICATION_JSON)
	public Album getTrackInJSON() {
		Album album = new Album();
		album.setTitle("Batman The Dark Knight");
		album.setSinger("Christopher Nolan");
		return album;
	}
	@POST
	@Path("/fromJSON")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createAlbumInJSON(Album album) {

		String result = "Album saved : " + album;
		return Response.status(201).entity(result).build();
		
	}
	
}
