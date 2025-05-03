package com.ScarZeus.recipe_backend.controller;

import com.ScarZeus.recipe_backend.model.authModels.AuthRequestModel;
import com.ScarZeus.recipe_backend.model.authModels.AuthResponseModel;
import com.ScarZeus.recipe_backend.service.authServices.JWTServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

//    private final JWTServices jwtService;

//    @GetMapping("/login")
//    public ResponseEntity<AuthResponseModel> login(@RequestBody AuthRequestModel request){
//        try(AuthResponseModel response = jwtService.getJwtToken(request)){
//            return ResponseEntity.ok(response);
//        }
//        catch (Exception e){
//            return ResponseEntity.badRequest().body(null);
//        }
//    }

}
