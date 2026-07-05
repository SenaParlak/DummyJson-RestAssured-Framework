package com.senaparlak.restassured.models.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class ProductsRequest {

    private int id;
    private String title;
}
