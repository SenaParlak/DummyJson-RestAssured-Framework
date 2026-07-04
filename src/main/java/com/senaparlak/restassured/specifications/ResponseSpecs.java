package com.senaparlak.restassured.specifications;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecs {

    private ResponseSpecs() {

    }
    public static ResponseSpecification successResponse() {
        return responseWithStatus(200);
    }

    public static ResponseSpecification createdResponse() {
        return responseWithStatus(201);
    }

    public static ResponseSpecification badRequestResponse() {
        return responseWithStatus(400);
    }

    public static ResponseSpecification unauthorizedResponse() {
        return responseWithStatus(401);
    }

    public static ResponseSpecification notFoundResponse() {
        return responseWithStatus(404);
    }

    private static ResponseSpecification responseWithStatus(int statusCode) {

        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .expectContentType(ContentType.JSON)
                .build();

    }
}
