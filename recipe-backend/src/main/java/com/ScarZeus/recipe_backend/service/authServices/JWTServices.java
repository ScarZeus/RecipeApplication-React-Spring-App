package com.ScarZeus.recipe_backend.service.authServices;

import com.ScarZeus.recipe_backend.model.authModels.AuthRequestModel;
import com.ScarZeus.recipe_backend.model.authModels.AuthResponseModel;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JWTServices {

    public AuthResponseModel getJwtToken(AuthRequestModel request) {
        return null;
    }



    public String extractEmailFromJwt(String jwtToken) {
        return null;
    }

    public boolean isValidToken(String jwtToken, UserDetails userDetails) {
        return false;
    }
}
