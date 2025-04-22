package com.ScarZeus.recipe_backend.repository;

import com.ScarZeus.recipe_backend.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserModel,Long> {
}
