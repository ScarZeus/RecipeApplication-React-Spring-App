package com.ScarZeus.recipe_backend.model;

import com.ScarZeus.recipe_backend.model.enumModels.Cuisine;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashMap;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "recipes")
public class RecipeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private long recipeId;

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

    @Column(name = "dateTime")
    private Date dateTime;

    @Column(name = "cuisine")
    @Enumerated(EnumType.STRING)
    private Cuisine cuisine;

    @PrePersist
    private void setDateAndTime(){
        this.dateTime = new Date();
    }
}
