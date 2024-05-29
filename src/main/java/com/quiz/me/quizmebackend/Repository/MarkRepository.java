package com.quiz.me.quizmebackend.Repository;

import com.quiz.me.quizmebackend.Model.MarkModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkRepository extends JpaRepository<MarkModel, String> {
    // Methoden für spezifische Markierungen und Abfragen
}
