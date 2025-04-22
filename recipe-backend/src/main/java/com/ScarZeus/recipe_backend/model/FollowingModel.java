package com.ScarZeus.recipe_backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class FollowingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "follower_id")
    private UserModel follower;

    @ManyToOne
    @JoinColumn(name = "following_id")
    private UserModel following;


}
