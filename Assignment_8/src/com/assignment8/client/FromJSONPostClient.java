package com.assignment8.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class FromJSONPostClient {
	public static void main(String[] args) {

		try {
			Client client = Client.create();
			WebResource webResource = client
			   .resource("http://localhost:8080/Assignment_8/api/albums/fromJSON");
			String input = "{\"singer\":\"James Cameron\",\"title\":\"Avatar\"}";
			ClientResponse response = webResource.type("application/json")
			   .post(ClientResponse.class, input);
			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
				     + response.getStatus());
			}

			System.out.println("New Albums .... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);

		  } catch (Exception e) {

			e.printStackTrace();

		  }

		}
}
