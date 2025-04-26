package com.ScarZeus.recipe_backend.service;

import com.ScarZeus.recipe_backend.model.RecipeModel;
import com.ScarZeus.recipe_backend.model.UserModel;
import com.ScarZeus.recipe_backend.model.enumModels.Cuisine;
import com.ScarZeus.recipe_backend.repository.RecipeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepo recipeRepo;
    private final UserService userService;

    public RecipeModel saveRecipe(RecipeModel recipe){
        return recipeRepo.save(recipe);
    }

    public void deleteRecipe(long id) throws Exception {
        if(recipeRepo.existsById(id)){
            recipeRepo.deleteById(id);
        }
        else{
            throw new RuntimeException("Recipe Does not Exist");
        }
    }

    public void updateRecipe(RecipeModel recipe){
        if(recipeRepo.existsById(recipe.getRecipeId())){
            recipeRepo.delete(recipe);
            recipeRepo.save(recipe);
        }
        else {
            throw new RuntimeException("Recipe does not exist");
        }
    }

    public RecipeModel getRecipe(long id){
        Optional<RecipeModel> recipe = recipeRepo.findById(id);
        return Optional.of(recipe)
                .get()
                .orElseThrow(()->new RuntimeException("Recipe not found"));
    }

    public List<RecipeModel> findAllRecipes(String recipeName){
        List<RecipeModel> allRecipes = recipeRepo.findAllByRecipeName(recipeName);
        if(allRecipes.isEmpty()){
            throw new RuntimeException("No Recipes where found");
        }
        return allRecipes;
    }

    public List<RecipeModel> getAllRecipes(String emailId){
        UserModel user = userService.getUser(emailId);
        List<RecipeModel> allRecipes = recipeRepo.findAllByUser(user);
        if(allRecipes.isEmpty()){
            throw new RuntimeException("No recipes are found");
        }
        return allRecipes;
    }

    public List<RecipeModel> getAllRecipeByCuisine(List<Cuisine> cuisines,String recipeName){
        List<RecipeModel> allRecipes = findAllRecipes(recipeName);
        allRecipes.removeIf(recipe-> cuisines.contains(recipe.getCuisine()));
        if(allRecipes.isEmpty()){
            throw new RuntimeException("No Recipes are found");
        }
        return allRecipes;
    }

    public List<RecipeModel> getAllRecipes(long id){
        UserModel user = userService.getUser(id);
        List<RecipeModel> userRecipes = recipeRepo.findAllByUser(user);
        if(userRecipes.isEmpty()){
            throw new RuntimeException("No recipes are found");
        }
        return userRecipes;
    }
}
