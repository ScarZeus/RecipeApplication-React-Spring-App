package com.ScarZeus.recipe_backend.service;

import com.ScarZeus.recipe_backend.model.UserModel;
import com.ScarZeus.recipe_backend.model.authModels.AuthRequestModel;
import com.ScarZeus.recipe_backend.model.authModels.AuthResponseModel;
import com.ScarZeus.recipe_backend.repository.UserRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final UserRepo userRepo;
    private final RecipeService recipeService;
    private final CloudinaryService cloudinaryService;

    public UserModel getUser(String emailId) {
        return Optional.ofNullable(userRepo.findByEmailId(emailId)).get()
                .orElseThrow(()->new UsernameNotFoundException("User Not Found"));

    }

    public UserModel addUser(UserModel user, MultipartFile image){
        if(userRepo.existsByEmailId(user.getEmailId())){
            throw new RuntimeException("User Already exists");
        }
        Map imageDetails = cloudinaryService.uploadImage(image);
        user.setImageUrl(imageDetails.get("secure_url").toString());
        user.setImagePublicId(imageDetails.get("public_id").toString());
        return userRepo.save(user);
    }

    public void deleteUser(long id) throws Exception {
        if(userRepo.existsById(id)){
            recipeService.deleteAllRecipeOfUser(id);
            cloudinaryService.deleteImage(getUser(id).getImagePublicId());
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

//    public boolean verifyUser(AuthRequestModel request) {
//        UserModel user = getUser(request.getEmail());
//        if(user.getEmailId().equals(request.getEmail()) &&
//                user.getPassword()
//                .equals(passwordEncoder
//                        .encode(request.getPassword()))){
//            return true;
//        }
//        return false;
//    }

    public boolean isUserExist(String email){
        if(userRepo.existsByEmailId(email)){
            return true;
        }
        return false;
    }
}
