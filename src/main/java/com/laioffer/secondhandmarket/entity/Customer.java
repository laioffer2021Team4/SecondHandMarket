package com.laioffer.SecondHandMarket.entity;

public class Customer {

    private int id;
    private String firstName;
    private String lastName;
    private String customerPhone;

    private User user;

    private Address address;

    private Cart cart;

    private SaleList saleList;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public User getUser() {
        return user;
    }

    public Address getAddress() {
        return address;
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setSaleList(SaleList saleList) {
        this.saleList = saleList;
    }
}
