package com.ScarZeus.recipe_backend.repository;

import com.ScarZeus.recipe_backend.model.RecipeModel;
import com.ScarZeus.recipe_backend.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepo extends JpaRepository<RecipeModel,Long> {
    @Query(value = "SELECT r FROM recipes r WHERE m.recipe_name %:recipeName%")
    List<RecipeModel> findAllByRecipeName(@Param("recipeName") String recipeName);

    List<RecipeModel> findAllByUser(UserModel user);
}
