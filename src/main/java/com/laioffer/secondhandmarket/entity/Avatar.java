package com.laioffer.secondhandmarket.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "avatar")
public class Avatar implements Serializable {

    private static final long serialVersionUID = 5590648007364082800L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String url;

    @OneToOne
    @JsonIgnore
    private Customer customer;

}
