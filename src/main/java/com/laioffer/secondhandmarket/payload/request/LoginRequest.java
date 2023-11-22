package com.laioffer.secondhandmarket.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class LoginRequest {

  @NotBlank
  private String email;

  @NotBlank
  private String password;
}