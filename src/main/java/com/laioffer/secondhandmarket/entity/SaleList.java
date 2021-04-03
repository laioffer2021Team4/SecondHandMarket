package com.laioffer.secondhandmarket.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "salelist")
public class SaleList implements Serializable {

    private static final long serialVersionUID = 5859643279933388869L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(mappedBy = "saleList", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Product> productList;

    @OneToOne(mappedBy = "saleList")
    @JsonIgnore
    private Customer customer;

    public int getId() {
        return id;
    }

    public Set<Product> getProductList() {
        return productList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProductList(Set<Product> productList) {
        this.productList = productList;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
