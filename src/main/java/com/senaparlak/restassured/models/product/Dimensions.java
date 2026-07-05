package com.senaparlak.restassured.models.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Dimensions {

    private double width;
    private double height;
    private double depth;

}