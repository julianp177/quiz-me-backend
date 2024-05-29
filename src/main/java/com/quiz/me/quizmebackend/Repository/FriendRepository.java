package com.quiz.me.quizmebackend.Repository;

import com.quiz.me.quizmebackend.Model.FriendModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository extends JpaRepository<FriendModel, String> {
    // Zusätzliche Abfragen für die Freundesbeziehungen können hier eingefügt werden
}