package com.ScarZeus.recipe_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/recipe")
public class RecipeController {

    @GetMapping("/getIngredient")
    public ResponseEntity<?> getIngredient(@RequestParam("ingredient") String ingredient){
        return null;
    }
}
