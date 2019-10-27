package com.yelp;

public class QueryParam {
	private String term = null;
	private String location = null;
	private int radius;
	private String price = null;
	private float latitude;
	private float longitude;
	

	
	public QueryParam(String term, String location, int radius, String price) {
		super();
		this.term = term;
		this.location = location;
		this.radius = radius;
		this.price = price;
	}
	
	public QueryParam(String term, int radius, String price, float latitude, float longitude) {
		super();
		this.term = term;
		this.radius = radius;
		this.price = price;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	
	
}
