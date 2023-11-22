package com.laioffer.secondhandmarket.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class ProfileRequest {

  @NotBlank
  private String email;
}
