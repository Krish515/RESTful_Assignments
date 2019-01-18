package com.assignment1.client;

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

	private static final String webServiceURI = "http://localhost:8080/Assignment_1";

	public static void main(String[] args) {
		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);
		URI serviceURI = UriBuilder.fromUri(webServiceURI).build();
		WebTarget webTarget = client.target(serviceURI);
		System.out.println("Enter the Credit Card Number");
		Scanner sc = new Scanner(System.in);
		Integer value = sc.nextInt();
		String k = Integer.toString(value);
		if (value<0){
			System.out.println("Card Numberis Invalid");
		}
		
		else{
			// response
		System.out.println(webTarget.path("api").path("CreditCard").path(k).request()
				.accept(MediaType.TEXT_PLAIN).get(Response.class).toString());

		

		// html
		System.out.println(webTarget.path("api").path("CreditCard").path(k).request()
				.accept(MediaType.TEXT_HTML).get(String.class));
		}
	}
}