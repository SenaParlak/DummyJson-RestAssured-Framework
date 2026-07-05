package com.senaparlak.restassured.services;

import com.senaparlak.restassured.endpoints.ProductRoutes;
import com.senaparlak.restassured.models.product.CreateProductRequest;
import com.senaparlak.restassured.models.product.Product;
import com.senaparlak.restassured.models.product.UpdateProductRequest;
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

    public static Response getProductById(int id){
        return given()
                .spec(RequestSpecs.getRequestSpec())
                .pathParam("id", id)
                .when()
                .get(ProductRoutes.PRODUCT);
    }

    public static Response createProduct(CreateProductRequest request){
        return given()
                .spec(RequestSpecs.getRequestSpec())
                .when()
                .post(ProductRoutes.ADD_PRODUCT);
    }

    public static Response updateProduct(int id, UpdateProductRequest request){
        return given()
                .spec(RequestSpecs.getRequestSpec())
                .pathParam("id", id)
                .body(request)
                .when()
                .put(ProductRoutes.UPDATE_PRODUCT);
    }
}
