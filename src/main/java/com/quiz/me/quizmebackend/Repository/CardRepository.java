package com.quiz.me.quizmebackend.Repository;

import com.quiz.me.quizmebackend.Model.CardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<CardModel, String> {
    // Zusätzliche Methoden für spezifische Abfragen können hier definiert werden
}

