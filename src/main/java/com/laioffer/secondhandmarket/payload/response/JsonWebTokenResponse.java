package com.laioffer.secondhandmarket.payload.response;

import com.laioffer.secondhandmarket.entity.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class JsonWebTokenResponse {
    private String accessToken;
    private String type = "Bearer";
    private Long id;
    private String email;
    private final List<String> roles;
    private Customer customer;

    public JsonWebTokenResponse(String accessToken, Long id, String email, List<String> roles, Customer customer) {
        this.accessToken = accessToken;
        this.id = id;
        this.email = email;
        this.roles = roles;
        this.customer = customer;
    }

}