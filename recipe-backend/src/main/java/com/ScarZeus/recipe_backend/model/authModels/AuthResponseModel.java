package com.ScarZeus.recipe_backend.model.authModels;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class AuthResponseModel {
    private String jwtToken;
}
