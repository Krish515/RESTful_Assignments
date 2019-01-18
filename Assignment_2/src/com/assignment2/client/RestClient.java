package com.assignment2.client;

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

	private static final String webServiceURI = "http://localhost:8080/Assignment_2";

	public static void main(String[] args) {
		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);
		URI serviceURI = UriBuilder.fromUri(webServiceURI).build();
		WebTarget webTarget = client.target(serviceURI);
		System.out.println("Enter Date Of Birth in following format");
		Scanner sc = new Scanner(System.in);
		System.out.println("(DAY) E.g.20");
		Integer day = sc.nextInt();
		System.out.println("(MONTH) - E.g.02");
		Integer month = sc.nextInt();
		System.out.println("(YEAR) - E.g.1996");
		Integer year = sc.nextInt();
		if(day<=0||day>31||month<=0||month>12||year<0){
	
		System.out.println("DOB is Invalid");
		
		}
		else{
			// response
			System.out.println(webTarget.path("api").path("Date").queryParam("day", day).queryParam("month", month).queryParam("year", year).request()
					.accept(MediaType.TEXT_PLAIN).get(Response.class).toString());
			
			// html
			System.out.println(webTarget.path("api").path("Date").queryParam("day", day).queryParam("month", month).queryParam("year", year).request()
					.accept(MediaType.TEXT_HTML).get(String.class));
			}
			
	}
}