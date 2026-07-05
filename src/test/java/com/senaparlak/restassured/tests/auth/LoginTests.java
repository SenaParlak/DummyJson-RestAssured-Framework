package com.senaparlak.restassured.tests.auth;

import com.senaparlak.restassured.models.auth.ErrorResponse;
import com.senaparlak.restassured.models.auth.LoginResponse;
import com.senaparlak.restassured.services.AuthService;
import com.senaparlak.restassured.specifications.ResponseSpecs;
import com.senaparlak.restassured.utils.ResponseMapper;
import data.LoginData;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class LoginTests {

    @Test
    public void userShouldLoginSuccessfully() {

        Response response = AuthService.login(LoginData.validUser());

        response.then()
                .spec(ResponseSpecs.successResponse());

        LoginResponse loginResponse = ResponseMapper.parse(response, LoginResponse.class);

        assertEquals(loginResponse.getUsername(), "emilys");
        assertNotNull(loginResponse.getAccessToken());
        assertNotNull(loginResponse.getRefreshToken());

    }

    @Test
    public void userShouldNotLoginWithInvalidPassword() {

        Response response = AuthService.login(LoginData.invalidPassword());

        response.then()
                .spec(ResponseSpecs.badRequestResponse());

        ErrorResponse errorResponse = ResponseMapper.parse(response, ErrorResponse.class);

        assertEquals(errorResponse.getMessage(), "Invalid credentials");
    }

    @Test
    public void userShouldNotLoginWithInvalidUsername() {

        Response response = AuthService.login(LoginData.invalidUsername());

        response.then()
                .spec(ResponseSpecs.badRequestResponse());

        ErrorResponse errorResponse = ResponseMapper.parse(response, ErrorResponse.class);

        assertEquals(errorResponse.getMessage(), "Invalid credentials");
    }

    @Test
    public void userShouldNotLoginWithEmptyPassword() {

        Response response = AuthService.login(LoginData.emptyPassword());

        response.then()
                .spec(ResponseSpecs.badRequestResponse());

        ErrorResponse errorResponse = ResponseMapper.parse(response, ErrorResponse.class);

        assertEquals(errorResponse.getMessage(), "Username and password required");

    }

    @Test
    public void userShouldNotLoginWithEmptyUsername() {

        Response response = AuthService.login(LoginData.emptyUsername());

        response.then()
                .spec(ResponseSpecs.badRequestResponse());

        ErrorResponse errorResponse = ResponseMapper.parse(response, ErrorResponse.class);

        assertEquals(errorResponse.getMessage(), "Username and password required");

    }

    @Test
    public void userShouldNotLoginWithEmptyUsernameAndPassword() {

        Response response = AuthService.login(LoginData.emptyUsernameAndPassword());

        response.then()
                .spec(ResponseSpecs.badRequestResponse());

        ErrorResponse errorResponse = ResponseMapper.parse(response, ErrorResponse.class);

        assertEquals(errorResponse.getMessage(), "Username and password required");
    }

    @Test
    public void userShouldNotLoginWithNullPassword() {

        Response response = AuthService.login(LoginData.nullPassword());

        response.then()
                .spec(ResponseSpecs.badRequestResponse());

        ErrorResponse errorResponse = ResponseMapper.parse(response, ErrorResponse.class);

        assertEquals(errorResponse.getMessage(), "Username and password required");
    }

    @Test
    public void userShouldNotLoginWithNullUsername() {

        Response response = AuthService.login(LoginData.nullUsername());

        response.then()
                .spec(ResponseSpecs.badRequestResponse());

        ErrorResponse errorResponse = ResponseMapper.parse(response, ErrorResponse.class);

        assertEquals(errorResponse.getMessage(), "Username and password required");
    }

    @Test
    public void userShouldNotLoginWithNullUsernameAndPassword() {

        Response response = AuthService.login(LoginData.nullUsernameAndPassword());

        response.then()
                .spec(ResponseSpecs.badRequestResponse());

        ErrorResponse errorResponse = ResponseMapper.parse(response, ErrorResponse.class);

        assertEquals(errorResponse.getMessage(), "Username and password required");
    }
}
