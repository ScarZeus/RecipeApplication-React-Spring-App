package com.ScarZeus.recipe_backend.controller;

import com.ScarZeus.recipe_backend.model.UserModel;
import com.ScarZeus.recipe_backend.model.authModels.AuthRequestModel;
import com.ScarZeus.recipe_backend.model.authModels.AuthResponseModel;
import com.ScarZeus.recipe_backend.service.UserService;
import com.ScarZeus.recipe_backend.service.authServices.JWTServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JWTServices jwtService;
//    @GetMapping("/login")
//    public ResponseEntity<UserModel> login(@RequestBody AuthRequestModel request){
//        try {
//            return ResponseEntity.ok(jwtService.getJwtToken(request));
//        }
//        catch (Exception e){
//            return ResponseEntity.badRequest().body(null);
//        }
//    }

    @PostMapping("/register")
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

    @PostMapping("/{userId}/update")
    public ResponseEntity<UserModel> updateUser(@RequestBody UserModel user){
        try{
            userService.updateUser(user);
            return ResponseEntity.ok(user);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(user);
        }
    }

//    @DeleteMapping("{userId}/delete")
//    public ResponseEntity<String> deleteUser(@PathVariable("userId") long id){
//        try {
//            userService.deleteUser(id);
//            return ResponseEntity.ok("Success");
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Failed");
//        }
//    }
}
