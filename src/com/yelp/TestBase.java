// comment added
package com.yelp;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class TestBase {

	public static void main(String[] args) throws IOException {
		
		JsonParser parser = new JsonParser();										// from GSON library
		JsonObject json = new JsonObject();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String apiKey = "Bearer pDUXmeWPp9Ed410PRhxfs8pKzGCxOV_620IlF5xrIgkzWptYyrxHuk2xs_KeW9-o1smO2dDET6rvpeYKiWxsBeKfybvxS7nI3Ss6Aw-vi05ILRjXBd9IHnphqy-zXXYx";
		String endpoint = "https://api.yelp.com/v3/businesses/search";
		QueryParam qp = new QueryParam("restaurants", "Oakland,CA", 3280, "1,2,3");
		URL url = new URL(endpoint + "?term="+qp.getTerm() + "&location="+qp.getLocation() + "&radius="+qp.getRadius() +
				"&price="+qp.getPrice());
		
		// Http config
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestProperty("Authorization", apiKey);							// new Yelp Fusion API in 2018 - no more using OAuth2 / getting access token
		conn.setRequestMethod("GET");
		conn.setDoInput(true);														// set request body
//		conn.getOutputStream();
		conn.connect();
		
		InputStream is = conn.getInputStream();										// read response
		Scanner scan = new Scanner(is, "UTF-8");
		String jsonString = scan.useDelimiter("//Z").next();
		int resp = conn.getResponseCode();
		String method = conn.getRequestMethod();
		scan.close();
		conn.disconnect();
		
		// print JSON string
		System.out.println(jsonString);
		
		// make JSON pretty + print
		json = (JsonObject) parser.parse(jsonString);
		String prettyJson = gson.toJson(json);
		System.out.println(prettyJson);
		
		// get array value for key="businesses"
		JsonArray jsonArray = (JsonArray) json.get("businesses");
		System.out.println(json.get("businesses"));
		
		// display each search result in full
		for(JsonElement j: jsonArray) {
			System.out.println(j);
		}
		
		// display 'name' only
		for(int i=0;i<jsonArray.size();i++) {
			json = (JsonObject) jsonArray.get(i);
			System.out.println("id: " + json.get("name"));
		}
		
	}

}
