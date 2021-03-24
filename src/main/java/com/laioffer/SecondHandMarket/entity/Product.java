package com.laioffer.SecondHandMarket.entity;

public class Product {

    private int id;

    private String category;

    private String description;

    private String manufacturer;

    private String name;

    private double price;

    private Address address;

    private double viewNumber;

    private String postDate;

    private boolean isSold;

    private Cart cart;

    private SaleList saleList;

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Address getAddress() {
        return address;
    }

    public double getViewNumber() {
        return viewNumber;
    }

    public String getPostDate() {
        return postDate;
    }

    public boolean isSold() {
        return isSold;
    }

    public Cart getCart() {
        return cart;
    }

    public SaleList getSaleList() {
        return saleList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setViewNumber(double viewNumber) {
        this.viewNumber = viewNumber;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setSaleList(SaleList saleList) {
        this.saleList = saleList;
    }
}
