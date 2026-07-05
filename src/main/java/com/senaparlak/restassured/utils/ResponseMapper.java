package com.senaparlak.restassured.utils;

import io.restassured.response.Response;

public class ResponseMapper {

    private ResponseMapper(){
    }

    public static <T> T parse(Response response, Class<T> clazz){

        return response.as(clazz);

    }
}
