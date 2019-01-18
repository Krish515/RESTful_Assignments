package com.assignment5.client;

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

	private static final String webServiceURI = "http://localhost:8080/Assignment_5";

	public static void main(String[] args) {
		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);
		URI serviceURI = UriBuilder.fromUri(webServiceURI).build();
		WebTarget webTarget = client.target(serviceURI);
		System.out.println("Enter Add/Subtract");
		Scanner sc = new Scanner(System.in);
		String process = sc.nextLine();
		System.out.println("Enter First Number");
		int num1= sc.nextInt();
		System.out.println("Enter Second Number");
		int num2= sc.nextInt();
		if(process.toLowerCase().equals("add")){
			// response
		System.out.println(webTarget.path("api").path("Calculate").path("add").queryParam("num1", num1).queryParam("num2", num2).request()
				.accept(MediaType.TEXT_PLAIN).get(Response.class).toString());
		// html
		System.out.println(webTarget.path("api").path("Calculate").path("add").queryParam("num1", num1).queryParam("num2", num2).request()
				.accept(MediaType.TEXT_HTML).get(String.class));
		}
		else if (process.toLowerCase().equals("subtract")){
				// response
			System.out.println(webTarget.path("api").path("Calculate").path("subtract").queryParam("num1", num1).queryParam("num2", num2).request()
					.accept(MediaType.TEXT_PLAIN).get(Response.class).toString());
			// html
			System.out.println(webTarget.path("api").path("Calculate").path("subtract").queryParam("num1", num1).queryParam("num2", num2).request()
					.accept(MediaType.TEXT_HTML).get(String.class));
		}
		else
			System.out.println("Invalid process type");
		
	}
}