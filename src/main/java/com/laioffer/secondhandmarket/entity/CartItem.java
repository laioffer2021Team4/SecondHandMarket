package com.laioffer.secondhandmarket.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "cart_item")
public class CartItem implements Serializable {

    private static final long serialVersionUID = 3699695338675889537L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private double price;

    @ManyToOne
    private Product product;

    @ManyToOne
    @JsonIgnore
    private Cart cart;

}
