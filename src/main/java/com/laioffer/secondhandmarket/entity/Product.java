package com.laioffer.secondhandmarket.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Column;

import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String category;

    private String description;

    private String manufacturer;

    private String name;

    private double price;

    @ManyToOne
    private Address address;

    @Column(name = "view_number")
    private double viewNumber;

    @Column(name = "post_date")
    private String postDate;

    @Column(name = "is_sold")
    private boolean isSold;

    @ManyToOne
    @JsonIgnore
    private SaleList saleList;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProductImage> image;

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

    public void setSaleList(SaleList saleList) {
        this.saleList = saleList;
    }

    public List<ProductImage> getImage() {
        return image;
    }

    public void setImage(List<ProductImage> image) {
        this.image = image;
    }
}
