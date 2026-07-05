package com.senaparlak.restassured.models.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductsResponse {

    private List<Product> products;
    private int total;
    private int skip;
    private int limit;
}
