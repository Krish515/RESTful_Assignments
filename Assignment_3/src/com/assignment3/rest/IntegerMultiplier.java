package com.assignment3.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("integer")
public class IntegerMultiplier {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public Response returnMultilier(@QueryParam("value") int value) throws Exception{
		String multiplier =null;
		try {
			if(value<-1073741824) {
				multiplier="<p>Number should be greater than - 1073741824</p>";
			}
			else if(value >1073741823) {
				multiplier="<p>Integer should be less than 1073741823</p>";
			}
			else
				multiplier="<p>Doubled Integer:"+2*value+"</p>";
		}
		catch(Exception e) {
			e.printStackTrace();
			return Response.status(400).entity("Server was unable to process your request").build();
		}
		return Response.ok(multiplier).build();
		
	}
}
