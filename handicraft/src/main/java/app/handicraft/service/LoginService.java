package app.handicraft.service;

import app.handicraft.dto.login.LoginRequest;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public Boolean checkCredientials(LoginRequest loginRequest){
        return loginRequest.password().equals("admin") && loginRequest.username().equals("admin@gmail.com");
    }

}
