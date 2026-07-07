package com.senaparlak.restassured.models.product;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CreateProductRequest {

    private String title;
    private String description;
    private String category;
    private double price;

}
