package com.quiz.me.quizmebackend.Repository;

import com.quiz.me.quizmebackend.Model.SetModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetRepository extends JpaRepository<SetModel, String> {
    // Eigene Abfragemethoden für Kartensets
}
