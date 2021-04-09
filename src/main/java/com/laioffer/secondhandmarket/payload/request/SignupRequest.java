package com.laioffer.secondhandmarket.payload.request;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Setter
@Getter
public class SignupRequest {

    @NotBlank
    @Size(max = 50)
    private String email;

    private Set<String> role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    private String firstname;
    private String lastname;
    //private String phone;
    private String street;
    private String city;
    private String state;
    private String zipcode;
    //private String country;

}

