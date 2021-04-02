package com.laioffer.secondhandmarket.entity;

import java.util.List;

public class SaleList {

    private int id;

    private List<Product> productList;

    private Customer customer;

    public int getId() {
        return id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
