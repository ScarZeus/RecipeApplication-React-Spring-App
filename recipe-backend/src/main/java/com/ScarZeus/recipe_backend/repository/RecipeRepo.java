package com.ScarZeus.recipe_backend.repository;

import com.ScarZeus.recipe_backend.model.RecipeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepo extends JpaRepository<RecipeModel,Long> {
}
