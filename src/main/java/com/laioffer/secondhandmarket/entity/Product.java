package com.laioffer.secondhandmarket.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "product")
public class Product implements Serializable {

    private static final long serialVersionUID = 5859643279933388869L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String category;

    private String description;

    private String manufacturer;

    private String title;

    @Column(name = "product_condition")
    private String condition;

    private double price;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Address address;

    @Column(name = "view_number")
    private double viewNumber;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "post_date")
    private Date postDate;

    @Column(name = "is_sold")
    private boolean isSold;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @Builder.Default
    private Set<ProductImage> image = new HashSet<>();

    @ManyToOne
    @JsonIgnore
    private Customer customer;

}
