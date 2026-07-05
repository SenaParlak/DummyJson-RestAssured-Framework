package com.senaparlak.restassured.tests.products;

import com.senaparlak.restassured.models.product.ProductsResponse;
import com.senaparlak.restassured.services.ProductsService;
import com.senaparlak.restassured.specifications.ResponseSpecs;
import com.senaparlak.restassured.utils.ResponseMapper;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertFalse;

public class ProductTests {

    @Test
    public void getProducts(){

        Response response = ProductsService.getAllProducts();

        response.then().spec(ResponseSpecs.successResponse());

        ProductsResponse productsResponse = ResponseMapper.parse(response, ProductsResponse.class);

        assertFalse(productsResponse.getProducts().isEmpty());


    }
}
