package com.quiz.me.quizmebackend.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "duels")
public class DuelModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer duel_id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "friend_id", referencedColumnName = "user_id")
    private UserModel friend;

    private Integer userWins;
    private Integer friendWins;
    private Integer turn;
    private Integer current_set;

    // Getters and setters
}