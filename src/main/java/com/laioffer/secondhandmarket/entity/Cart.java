package com.laioffer.secondhandmarket.entity;

import java.util.List;

public class Cart {
    private int id;
    private double totalPrice;
    private List<Product> productList;
    private Customer customer;

    public int getId() {
        return id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
