package com.senaparlak.restassured.models.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateProductRequest {

    private String title;
    private String description;
    private double price;

}
