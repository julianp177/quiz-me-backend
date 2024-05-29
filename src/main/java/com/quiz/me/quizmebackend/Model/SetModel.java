package com.quiz.me.quizmebackend.Model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "sets")
public class SetModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer set_id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "owner", referencedColumnName = "user_id")
    private UserModel owner;

    // Getters and setters
}
