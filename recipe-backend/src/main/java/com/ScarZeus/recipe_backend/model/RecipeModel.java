package com.ScarZeus.recipe_backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashMap;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RecipeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private long recipe_id;

    @Column(name = "recipe_name")
    private String recipeName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    @Column(name = "noOfServings")
    private int noOfServings;

    @Column(name = "ingredients")
    private HashMap<String,Integer> ingridients;

    @Column(name = "rating")
    private int rating;
}
