package com.senaparlak.restassured.services;

import com.senaparlak.restassured.endpoints.AuthRoutes;
import com.senaparlak.restassured.models.auth.LoginRequest;
import com.senaparlak.restassured.specifications.RequestSpecs;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthService {

    private  AuthService() {
    }

    public static Response login(LoginRequest loginRequest){

        return given()
                .spec(RequestSpecs.getRequestSpec())
                .body(loginRequest)
                .when()
                .post(AuthRoutes.LOGIN);
    }
}
