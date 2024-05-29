package com.quiz.me.quizmebackend.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "cards")
public class CardModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer card_id;

    @ManyToOne
    @JoinColumn(name = "card_set", referencedColumnName = "set_id")
    private SetModel set;

    private Boolean private_mode;
    private String question;
    private String answer_1;
    private String answer_2;
    private String answer_3;
    private String answer_4;
    private Integer correct_answer;
    private Integer up;
    private Integer down;

    // Getters and setters
}