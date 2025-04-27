package com.ScarZeus.recipe_backend.controller;

import com.ScarZeus.recipe_backend.model.UserModel;
import com.ScarZeus.recipe_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/register")
    public ResponseEntity<UserModel> saveUser(@RequestPart("user_detail") UserModel user,
                                              @RequestPart("image") MultipartFile image){
        try{
            return ResponseEntity.ok(userService.addUser(user,image));
        }
        catch (Exception e){
            return ResponseEntity
                    .badRequest()
                    .body(user);
        }
    }
}
