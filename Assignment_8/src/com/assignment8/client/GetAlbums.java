package com.assignment8.client;


import javax.ws.rs.core.MediaType;

import com.assignment8.util.Album;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
 
public class GetAlbums {
 
  public static void main(String[] args) {
 
      ClientConfig clientConfig = new DefaultClientConfig();
 
      // Create Client based on Config
      Client client = Client.create(clientConfig);
 
      WebResource webResource = client.resource("http://localhost:8080/Assignment_8/api/albums/toJSON");
 
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
 
      System.out.println("To Access Album details \n");
     
      Album album = (Album) response.getEntity(Album.class);
 
      System.out.println("Title .... " + album.getTitle());
      System.out.println("Singer .... " + album.getSinger());
 
  }
 
}

