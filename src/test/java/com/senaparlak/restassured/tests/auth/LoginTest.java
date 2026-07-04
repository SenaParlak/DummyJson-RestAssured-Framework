package com.senaparlak.restassured.tests.auth;

import com.senaparlak.restassured.models.auth.LoginRequest;
import com.senaparlak.restassured.models.auth.LoginResponse;
import com.senaparlak.restassured.services.AuthService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class LoginTest {

    @Test
    public void userShouldLoginSuccessfully() {

        LoginRequest request = new LoginRequest();

        request.setUsername("emilys");
        request.setPassword("emilyspass");
        request.setExpiresInMins(30);

        LoginResponse response = AuthService.login(request);

        assertEquals(response.getUsername(), "emilys");
        assertEquals(response.getFirstName(), "Emily");
        assertNotNull(response.getAccessToken());

        System.out.println(request);
        System.out.println(response);

    }
}
