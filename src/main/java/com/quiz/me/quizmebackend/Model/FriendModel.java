package com.quiz.me.quizmebackend.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "friends")
@IdClass(FriendModelId.class)
public class FriendModel {
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserModel user;

    @Id
    @ManyToOne
    @JoinColumn(name = "friend_id", referencedColumnName = "user_id")
    private UserModel friend;

    // Getters und Setters
}
