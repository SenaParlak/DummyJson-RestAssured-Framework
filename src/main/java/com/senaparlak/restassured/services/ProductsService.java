package com.senaparlak.restassured.services;

import com.senaparlak.restassured.endpoints.ProductRoutes;
import com.senaparlak.restassured.specifications.RequestSpecs;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ProductsService {

    private ProductsService() {
    }

    public static Response getAllProducts() {

        return given()
                .spec(RequestSpecs.getRequestSpec())
                .when()
                .get(ProductRoutes.PRODUCTS);
    }
}
