package com.laioffer.SecondHandMarket.entity;

public class Address {

    private int id;
    private AddressType type;
    private String street;
    private String city;
    private String state;
    private String zipcode;
    private String country;

    public int getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public AddressType getType() {
        return type;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(AddressType type) {
        this.type = type;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
