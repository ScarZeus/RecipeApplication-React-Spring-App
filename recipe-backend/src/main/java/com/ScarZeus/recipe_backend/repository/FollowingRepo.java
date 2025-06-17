package com.ScarZeus.recipe_backend.repository;

import com.ScarZeus.recipe_backend.model.FollowingModel;
import com.ScarZeus.recipe_backend.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowingRepo extends JpaRepository<FollowingModel,Long> {
    List<UserModel> findAllByFollower(UserModel user);

    List<UserModel> findAllByFollowing(UserModel user);

//    List<UserModel> findAllByFollowers(Long id);
}
