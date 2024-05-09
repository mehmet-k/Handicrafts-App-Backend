package app.handicraft.controller;

import app.handicraft.dto.login.LoginRequest;
import app.handicraft.service.LoginService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public Boolean checkCredientials(@RequestBody LoginRequest loginRequest){
        return loginService.checkCredientials(loginRequest);
    }
}
