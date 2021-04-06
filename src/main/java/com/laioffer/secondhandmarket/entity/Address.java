package com.laioffer.secondhandmarket.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
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

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "address")
public class Address implements Serializable {

    private static final long serialVersionUID = -1745369143190678419L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private AddressType type;
    private String street;
    private String city;
    private String states;
    private String zipcode;
    private String country;

    @ManyToOne
    @JsonIgnore
    private Customer customer;

}
