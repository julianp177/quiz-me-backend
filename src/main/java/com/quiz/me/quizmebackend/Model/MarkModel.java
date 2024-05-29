package com.quiz.me.quizmebackend.Model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "marks")
@IdClass(MarkModelId.class) // Verweis auf die IdClass
public class MarkModel {
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserModel user;

    @Id
    @ManyToOne
    @JoinColumn(name = "card_id", referencedColumnName = "card_id")
    private CardModel card;

    // Getters und Setters
}
