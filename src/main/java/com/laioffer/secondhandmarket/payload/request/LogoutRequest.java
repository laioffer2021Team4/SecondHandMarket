package com.laioffer.secondhandmarket.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
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
