package com.ScarZeus.recipe_backend.repository;

import com.ScarZeus.recipe_backend.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserModel,Long> {
    Optional<UserModel> findByEmailId(String emailId);

    boolean existsByEmailId(String emailId);
}
