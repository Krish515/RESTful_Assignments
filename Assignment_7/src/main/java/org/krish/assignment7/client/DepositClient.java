package org.krish.assignment7.client;

import javax.ws.rs.core.MediaType;

import org.krish.assignment7.model.Account;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class DepositClient {
	public static void main(String[] args) {
		  String accNo="A101";
		  double deposit=5000.55;
	      ClientConfig clientConfig = new DefaultClientConfig();
	 
	      // Create Client based on Config
	      Client client = Client.create(clientConfig);
	      
	      WebResource webResource = client.resource("http://localhost:8080/Assignment_7/api/accounts/deposit?acc="+accNo+"&deposit="+deposit);
	 
	      Builder builder = webResource.accept(MediaType.APPLICATION_JSON) //
	              .header("content-type", MediaType.APPLICATION_JSON);
	 
	      ClientResponse response = builder.get(ClientResponse.class);
	 
	      // Status 200 is successful.
	      if (response.getStatus() != 200) {
	          System.out.println("Failed with HTTP Error code: " + response.getStatus());
	         String error= response.getEntity(String.class);
	         System.out.println("Error: "+error);
	          return;
	      }
	 
	      System.out.println("Deposit .... \n");
	 
	      Account acc = (Account) response.getEntity(Account.class);
	 
	      System.out.println("Acc No .... " + acc.getAccNo());
	      System.out.println("Name .... " + acc.getName());
	      System.out.println("Balance .... " + acc.getBalance());
	 
	  }
}
