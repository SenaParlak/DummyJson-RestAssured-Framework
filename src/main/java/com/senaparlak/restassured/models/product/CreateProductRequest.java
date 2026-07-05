package com.senaparlak.restassured.models.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CreateProductRequest {

    private String title;
    private String description;
    private String category;
    private double price;

}
