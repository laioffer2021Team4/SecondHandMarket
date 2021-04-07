package com.laioffer.secondhandmarket.payload.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class JsonWebTokenResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String email;
    private final List<String> roles;

    public JsonWebTokenResponse(String accessToken, Long id, String email, List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.email = email;
        this.roles = roles;
    }

}