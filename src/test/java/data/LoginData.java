package data;

import com.senaparlak.restassured.models.auth.LoginRequest;

public class LoginData {

    private LoginData(){
    }

    public static LoginRequest validUser(){

        LoginRequest request = new LoginRequest();
        request.setUsername("emilys");
        request.setPassword("emilyspass");
        request.setExpiresInMins(30);
        return  request;

    }

    public static LoginRequest invalidPassword(){

        LoginRequest request = validUser();
        request.setPassword("wrongPassword");
        return request;

    }

    public static LoginRequest invalidUsername(){

        LoginRequest request = validUser();
        request.setUsername("wrongusername");
        return request;

    }

    public static LoginRequest emptyPassword(){

        LoginRequest request = validUser();
        request.setPassword("");
        return request;

    }

    public static LoginRequest emptyUsername(){

        LoginRequest request = validUser();
        request.setUsername("");
        return request;

    }

    public static LoginRequest emptyUsernameAndPassword(){

        LoginRequest request = validUser();
        request.setUsername("");
        request.setPassword("");
        return request;

    }

    public static LoginRequest nullPassword(){

        LoginRequest request = validUser();
        request.setPassword(null);
        return request;

    }

    public static LoginRequest nullUsername(){

        LoginRequest request = validUser();
        request.setUsername(null);
        return request;

    }

    public static LoginRequest nullUsernameAndPassword(){

        LoginRequest request = validUser();
        request.setUsername(null);
        request.setPassword(null);
        return request;

    }
}
