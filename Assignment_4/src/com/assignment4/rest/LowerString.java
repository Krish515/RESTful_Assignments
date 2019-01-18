package com.assignment4.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("lowercase")
public class LowerString {
	@GET
	@Produces(MediaType.TEXT_HTML)
	public Response returnMultilier(@QueryParam("str") String str) throws Exception{
		String lowercase =null;
		try {
			if(str==null) {
				lowercase="<p>Invalid String</p>";
			}
			
			else
				lowercase="<p>Lower Case String:"+str.toLowerCase()+"</p>";
		}
		catch(Exception e) {
			e.printStackTrace();
			return Response.status(400).entity("Server was unable to process your request").build();
		}
		return Response.ok(lowercase).build();
		
	}
}
