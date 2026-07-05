package com.senaparlak.restassured.endpoints;

public class ProductRoutes {

    private  ProductRoutes() {
    }

    public static final String PRODUCTS = "/products";

    public static final String PRODUCT = "/products/{id}";

    public static final String ADD_PRODUCT = "/products/add";

    public static final String UPDATE_PRODUCT = "/products/{id}";

    public static final String DELETE_PRODUCT = "/products/{id}";
}
