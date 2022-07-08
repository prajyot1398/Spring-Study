package study.springmvcdemo.business;

import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.LinkedHashMap;

public class Student {
	
	@NotNull
	@Size(min=1,message=" is required.")
	private String firstName;
	
	private String lastName;
	private String country;
	private Map<String, String> availableCountries;
	private String favouritePL;
	private String[] osInteracted;
	
	public Student() {
		/*availableCountries = new LinkedHashMap<String, String>();
		
		availableCountries.put("IN","India");
		availableCountries.put("BR","Brazil");
		availableCountries.put("US","USA");
		availableCountries.put("CH","China");
		availableCountries.put("PK","Pakistan");*/
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public Map<String, String> getAvailableCountries() {
		return availableCountries;
	}
	
	public String getFavouritePL() {
		return favouritePL;
	}
	public void setFavouritePL(String favouritePL) {
		this.favouritePL = favouritePL;
	}

	public String[] getOsInteracted() {
		return osInteracted;
	}
	public void setOsInteracted(String[] osInteracted) {
		this.osInteracted = osInteracted;
	}
}
