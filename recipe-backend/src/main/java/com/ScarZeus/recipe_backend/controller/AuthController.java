package com.ScarZeus.recipe_backend.controller;

import com.ScarZeus.recipe_backend.model.authModels.AuthRequestModel;
import com.ScarZeus.recipe_backend.model.authModels.AuthResponseModel;
import com.ScarZeus.recipe_backend.service.authServices.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authService;

    @GetMapping("/login")
    public ResponseEntity<AuthResponseModel> login(@RequestBody AuthRequestModel request){
        try{
            AuthResponseModel authResponseModel = authService.authenticate(request);
            return ResponseEntity.ok(authResponseModel);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
