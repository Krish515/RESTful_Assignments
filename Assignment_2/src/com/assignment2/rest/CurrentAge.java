package com.assignment2.rest;

import java.time.LocalDate;
import java.time.Period;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("Date")
public class CurrentAge {
@GET
@Produces(MediaType.TEXT_HTML)
public Response returnAge(@QueryParam("day") int day,@QueryParam("month") int month,@QueryParam("year") int year) throws Exception{
	
	String returnCrAge= null;
	try {
	LocalDate current= LocalDate.now();
	LocalDate bDay = LocalDate.of(year, month, day);
	Period p = Period.between(bDay, current);
	int check=bDay.compareTo(current);
	if(check>0) {
	returnCrAge="<p>Age is invalid</p>";
	}
	else
	returnCrAge="<p><b>Current Date : </b>"+current+"</p>"+"<p><b>Birth Date : </b>"+bDay+"</p>"+"<p><b>Current Age : </b>" +p.getYears()+" Years "+p.getMonths()+ " Months "+ p.getDays()+" Days</p>";
	}
	catch(Exception e) {
		e.printStackTrace();
		return Response.status(500).entity("Server was unable to process your request"
				+ " Query Format Eg: http://localhost:4200/Assignment_2/api/Date?day=15&month=11&year=1985").build();
	}
	
	return Response.ok(returnCrAge).build();
}
}
