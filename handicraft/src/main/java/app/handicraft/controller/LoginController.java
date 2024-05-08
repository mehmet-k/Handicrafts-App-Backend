package app.handicraft.controller;

import app.handicraft.dto.login.LoginRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginController loginController;

    public LoginController(LoginController loginController) {
        this.loginController = loginController;
    }

    @PostMapping
    public Boolean checkCredientials(@RequestBody LoginRequest loginRequest){
        return loginController.checkCredientials(loginRequest);
    }
}
