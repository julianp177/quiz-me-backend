package com.quiz.me.quizmebackend.Model;
import java.io.Serializable;
import jakarta.persistence.*;

public class MarkModelId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "card_id", referencedColumnName = "card_id")
    private CardModel card;

    // Konstruktoren, equals(), hashCode() müssen implementiert werden
}
