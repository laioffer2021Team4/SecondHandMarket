package com.laioffer.secondhandmarket.payload.request;

import javax.validation.constraints.NotBlank;

public class LogoutRequest {
    @NotBlank
    private String email;

    public String getEmail() {
        return email;
    }

    public void setUsername(String email) {
        this.email = email;
    }

    public String getUsername() {
        return email;
    }

}
