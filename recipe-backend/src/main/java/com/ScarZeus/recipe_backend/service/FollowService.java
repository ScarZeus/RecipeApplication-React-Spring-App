package com.ScarZeus.recipe_backend.service;

import com.ScarZeus.recipe_backend.model.FollowingModel;
import com.ScarZeus.recipe_backend.model.UserModel;
import com.ScarZeus.recipe_backend.repository.FollowingRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FollowService {

    private final FollowingRepo followingRepo;
    private final UserService userService;

    public List<UserModel> getFollower(String emailId){
        UserModel user = userService.getUser(emailId);
        List<UserModel> follower = followingRepo.findAllByFollower(user);
        return follower;
    }

    public List<UserModel> getFollowing(String emailId){
        UserModel user = userService.getUser(emailId);
        List<UserModel> follower = followingRepo.findAllByFollowing(user);
        return follower;
    }

    public FollowingModel followSomeone(long userId, long followId) {
        UserModel user = userService.getUser(userId);
        UserModel followUser = userService.getUser(followId);

        FollowingModel followingModel = new FollowingModel();
        followingModel.setFollower(user);
        followingModel.setFollowing(followUser);

        Example<FollowingModel> example = Example.of(followingModel);
        if (followingRepo.exists(example)) {
            throw new RuntimeException("Already following");
        }
        return followingRepo.save(followingModel);
    }

    public List<FollowingModel> getFollowing(long id){
        UserModel user = userService.getUser(id);
        return user.getFollowing();
    }

    public List<FollowingModel> getFollowers(long id){
        UserModel user = userService.getUser(id);
        return user.getFollowers();
    }


}
