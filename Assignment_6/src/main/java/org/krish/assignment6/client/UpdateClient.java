package org.krish.assignment6.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class UpdateClient {

	  public static void main(String[] args) {
	 
	      Client client = Client.create();
	 
	      WebResource webResource = client.resource("http://localhost:8080/Assignment_6/rest/employees");
	 
	      // Data send to web service.
	      String input = "<employee>"//
	                      + "<empNo>E05</empNo>"//
	                      + "<empName>New Emp 1</empName>"//
	                      + "<position>Senior Manager</position>"
	                      + "</employee>";
	 
	       // Send XML and receive XML
	       ClientResponse response = webResource.type("application/xml")//
	               .accept("application/xml")//
	               .put(ClientResponse.class, input);
	 
	      if (response.getStatus() != 200) {
	          System.out.println("Failed : HTTP error code : " + response.getStatus());
	 
	          String error = response.getEntity(String.class);
	          System.out.println("Error: " + error);
	          return;
	      }
	 
	      System.out.println("Update .... \n");
	 
	      String output = response.getEntity(String.class);
	 
	      System.out.println(output);
	 
	  }
}
