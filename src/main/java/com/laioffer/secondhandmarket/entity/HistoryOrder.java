package com.laioffer.secondhandmarket.entity;

import java.util.List;

public class HistoryOrder {

    private int id;

    private double totalPrice;

    private Customer customer;

    private Address address;

    private List<Product> productList;

    public int getId() {
        return id;
    }


    public Customer getCustomer() {
        return customer;
    }

    public Address getAddress() {
        return address;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
