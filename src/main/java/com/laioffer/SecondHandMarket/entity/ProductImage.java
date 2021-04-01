package com.laioffer.SecondHandMarket.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "image")
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String url;

    @ManyToOne
    @JsonIgnore
    private Product product;

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public Product getProduct() {
        return product;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
