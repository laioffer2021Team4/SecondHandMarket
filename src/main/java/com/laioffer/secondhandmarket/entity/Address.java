package com.laioffer.secondhandmarket.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "address")
public class Address implements Serializable {

    private static final long serialVersionUID = -1745369143190678419L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private AddressType type;
    private String street;
    private String city;
    private String state;
    private String zipcode;
    private String country;

    @ManyToOne
    @JsonIgnore
    private Customer customer;

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

    public Customer getCustomer() {
        return customer;
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

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
