package com.ScarZeus.recipe_backend.model.authModels;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AuthRequestModel {
    private String email;
    private String password;
}
