package com.senaparlak.restassured.models.product;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Builder
public class UpdateProductRequest {

    private String title;
    private String description;
    private double price;

}
