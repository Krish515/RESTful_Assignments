package com.assignment5.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("Calculate")
@Produces(MediaType.TEXT_HTML)
public class AddSub {
	@Path("add")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public Response returnAddResult(@QueryParam("num1") int num1,@QueryParam("num2") int num2) {
		String returnAdd=null;
		try {
	
			returnAdd="<p>Addition Result : </p>"+(num1+num2);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("Server was unable to process your request").build();
		}
		
		return Response.ok(returnAdd).build();
	}
	@Path("subtract")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public Response returnSubResult(@QueryParam("num1") int num1,@QueryParam("num2") int num2) {
		String returnSub=null;
		try {
	
			returnSub="<p>Subtraction Result : </p>"+(num1-num2);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("Server was unable to process your request").build();
		}
		
		return Response.ok(returnSub).build();
	}
}
