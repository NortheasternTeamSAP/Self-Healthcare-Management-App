/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personnel;

/**
 *
 * @author Ankur Bywar
 */
public class Address {
    private String street;
    private String apartment;
    private String city;
    private String zipcode;
    private String state;
    private String country;  
    
    public Address(String street, String apartment, String city, String zipcode, String state, String country) {
        this.street = street;
        this.apartment = apartment;
        this.city = city;
        this.zipcode = zipcode;
        this.state = state;
        this.country = country;
    }

    public String toString() {
        return this.street + ", " +
               this.apartment + ", " +
               this.city + ", " + 
               this.zipcode + ", " +
               this.state + ", " +
               this.country;
    }
    
    public String getStreet() {
        return street;
    }

    public String getApartment() {
        return apartment;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }
  
}
