package com.laioffer.secondhandmarket.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

    @NotNull
    private List<String> uuids;

}
