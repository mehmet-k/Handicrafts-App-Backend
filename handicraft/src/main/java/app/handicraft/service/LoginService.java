package app.handicraft.service;

import app.handicraft.dto.login.LoginRequest;

public class LoginService {
    private Boolean checkCredientials(LoginRequest loginRequest){
        return loginRequest.password().equals("admin") && loginRequest.username().equals("admin@gmail.com");
    }

}
