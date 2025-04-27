package com.ScarZeus.recipe_backend.controller;

import com.ScarZeus.recipe_backend.model.RecipeModel;
import com.ScarZeus.recipe_backend.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/recipe")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @PostMapping("/{id}/createRecipe")
    public ResponseEntity<RecipeModel> createRecipe(@PathVariable("id") long id,
                                                    @RequestPart("recipe") RecipeModel recipe,
                                                    @RequestPart("image") MultipartFile image
                                                    ){
        try{
            return ResponseEntity.ok(recipeService
                    .saveRecipe(id,recipe,image));
        }
        catch (Exception e){
       return ResponseEntity
                    .badRequest()
                    .body(recipeService.saveRecipe(id,recipe,image));
        }
    }

    @DeleteMapping("/{userID}/deleteRecipe/{recipeID}")
    public ResponseEntity<String> deleteRecipe(@PathVariable("userID") long userID,@PathVariable("recipeID") long recipeID){
        try{
            recipeService.deleteRecipe(userID,recipeID);
            return ResponseEntity.ok("Success");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("delete operation failed");
        }
    }
}
