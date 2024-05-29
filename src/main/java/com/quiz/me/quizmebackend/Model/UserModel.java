package com.quiz.me.quizmebackend.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
@Entity
@Table(name="users")
public class UserModel {
    @Id
    @Column(name = "user_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "private_mode")
    private Boolean privateMode;

    public Long getUserId() {
        return user_id;
    }

    // Setter für userId, falls benötigt
    public void setUserId(long user_id) {
        this.user_id = user_id;
    }
}
