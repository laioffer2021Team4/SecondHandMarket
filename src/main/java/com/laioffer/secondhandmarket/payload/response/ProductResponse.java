package com.laioffer.secondhandmarket.payload.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder(toBuilder = true)
@Setter
@Getter
public class ProductResponse {
    String title;
    int productId;
    String uuid;
}
