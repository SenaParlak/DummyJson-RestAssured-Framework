package com.senaparlak.restassured.tests.products;

import com.senaparlak.restassured.models.common.ErrorResponse;
import com.senaparlak.restassured.models.product.*;
import com.senaparlak.restassured.services.ProductsService;
import com.senaparlak.restassured.specifications.ResponseSpecs;
import com.senaparlak.restassured.utils.ResponseMapper;
import data.ProductData;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class ProductTests {

    @Test
    public void getProducts(){

        Response response = ProductsService.getAllProducts();

        response.then().spec(ResponseSpecs.successResponse());

        ProductsResponse productsResponse = ResponseMapper.parse(response, ProductsResponse.class);

        assertFalse(productsResponse.getProducts().isEmpty());

    }

    @Test
    public void getProductById(){

        Response response = ProductsService.getProductById(1);

        response.then().spec(ResponseSpecs.successResponse());

        Product product = ResponseMapper.parse(response, Product.class);

        assertEquals(product.getId(), 1);
        assertNotNull(product.getTitle());
        assertTrue(product.getPrice() > 0);
    }

    @Test
    public void getProductByInvalidId(){

        Response response = ProductsService.getProductById(9999);

        response.then().spec(ResponseSpecs.notFoundResponse());

        ErrorResponse errorResponse = ResponseMapper.parse(response, ErrorResponse.class);

        assertEquals(errorResponse.getMessage(), "Product with id '9999' not found");

    }

    @Test
    public void addProduct() {

        CreateProductRequest request = ProductData.validProduct();

        Response response = ProductsService.createProduct(request);

        response.then().spec(ResponseSpecs.createdResponse());

        Product product = ResponseMapper.parse(response, Product.class);

        assertTrue(product.getId() > 0);

    }

    @Test
    public void updateProduct() {

        UpdateProductRequest request = ProductData.validUpdateProduct();

        Response response = ProductsService.updateProduct(1, request);

        response.then().spec(ResponseSpecs.successResponse());

        Product product = ResponseMapper.parse(response, Product.class);

        assertEquals(product.getTitle(), request.getTitle());
        assertEquals(product.getDescription(), request.getDescription());
        assertEquals(product.getPrice(), request.getPrice(), 0.01);

    }

    @Test
    public void deleteProduct() {

        Response response = ProductsService.deleteProduct(1);

        response.then().spec(ResponseSpecs.successResponse());

        Product product = ResponseMapper.parse(response, Product.class);

        assertEquals(product.getId(), 1);
        assertTrue(product.isDeleted());
        assertNotNull(product.getDeletedOn());
    }

    @Test
    public void updateInvalidProduct() {

        UpdateProductRequest request = ProductData.validUpdateProduct();

        Response response = ProductsService.updateProduct(9999, request);

        response.then().spec(ResponseSpecs.notFoundResponse());

        ErrorResponse errorResponse = ResponseMapper.parse(response, ErrorResponse.class);

        assertEquals(errorResponse.getMessage(), "Product with id '9999' not found");
    }
}
