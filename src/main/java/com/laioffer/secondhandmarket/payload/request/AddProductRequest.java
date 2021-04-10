package com.laioffer.secondhandmarket.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Setter
@Getter
public class AddProductRequest {

    @NotBlank
    private String email;

    @NotBlank
    private String description;

    @NotBlank
    private String title;

    @NotBlank
    private double price;

    private String street;
    private String city;
    private String state;
    private String zipcode;

    @NotBlank
    private String condition;

    @NotBlank
    private List<String> uuids;


}
