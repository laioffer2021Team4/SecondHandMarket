package com.laioffer.SecondHandMarket.entity;

public class ProductImage {
    private int id;
    private String url;
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
