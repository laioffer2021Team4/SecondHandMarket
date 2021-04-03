package com.laioffer.secondhandmarket.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = -8334783496425773445L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String firstName;
    private String lastName;
    private String customerPhone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private User user;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Address> address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Cart cart;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
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

    public Set<Address> getAddress() {
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

    public void setAddress(Set<Address> address) {
        this.address = address;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setSaleList(SaleList saleList) {
        this.saleList = saleList;
    }
}
