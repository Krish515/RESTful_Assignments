package com.assignment3.client;

import java.net.URI;
import java.util.Scanner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

public class RestClient {

	private static final String webServiceURI = "http://localhost:8080/Assignment_3";

	public static void main(String[] args) {
		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);
		URI serviceURI = UriBuilder.fromUri(webServiceURI).build();
		WebTarget webTarget = client.target(serviceURI);
		System.out.println("Enter the integer to be doubled");
		Scanner sc = new Scanner(System.in);
		Integer value = sc.nextInt();
	
		// response
		System.out.println(webTarget.path("api").path("integer").queryParam("value", value).request()
				.accept(MediaType.TEXT_PLAIN).get(Response.class).toString());

		

		// html
		System.out.println(webTarget.path("api").path("integer").queryParam("value", value).request()
				.accept(MediaType.TEXT_HTML).get(String.class));
		
		sc.close();
	}
}