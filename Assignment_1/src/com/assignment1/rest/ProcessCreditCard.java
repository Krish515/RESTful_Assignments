package com.assignment1.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("CreditCard")
public class ProcessCreditCard {
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnStatus() {
		String status = "<p>Give Card No as <b>path param</b></p>"
				+ "<p>E.g. http://localhost:4200/Assignment_1/api/CreditCard/<b>400</b></p>";
		return status;
	}
	@Path("/{CardNo}")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public Response returnApprovalStatus(@PathParam("CardNo") int CardNo) {
		String returnStatus=null;
		try {
			if(CardNo<=0) {
				returnStatus="<p>Invalid Card Number</p><p>Number should be greater than 0</p>";
			}
			else if(CardNo%2==0) {
				returnStatus="<p>Credit Card is valid</p><p>True</p>";
			}
			else {
				returnStatus="<p>Credit Card is Invalid</p><p>False</p>";
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("Server was unable to process your request").build();
		}
		
		return Response.ok(returnStatus).build();
		
	}
}
