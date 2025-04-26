package com.ScarZeus.recipe_backend.service;

import com.ScarZeus.recipe_backend.model.UserModel;
import com.ScarZeus.recipe_backend.repository.UserRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public UserModel getUser(String emailId) {
        return Optional.ofNullable(userRepo.findByEmailId(emailId)).get()
                .orElseThrow(()->new UsernameNotFoundException("User Not Found"));

    }

    public UserModel addUser(UserModel user){
        if(userRepo.existsByEmailId(user.getEmailId())){
            throw new RuntimeException("User Already exists");
        }
        return userRepo.save(user);
    }

    public void deleteUser(long id){
        if(userRepo.existsById(id)){
            userRepo.deleteById(id);
        }
        else {
            throw new RuntimeException("User does not exist");
        }
    }

    public void updateUser(UserModel user){
        if(userRepo.existsByEmailId(user.getEmailId())){
            userRepo.deleteById(user.getUserId());
            userRepo.save(user);
        }
        else{
            throw new RuntimeException("User not Found Exception");
        }
    }

    public UserModel getUser(long id){
        UserModel user = Optional.ofNullable(userRepo.findById(id))
                .get()
                .orElseThrow(()->new RuntimeException("User not found"));
        return user;
    }

}
