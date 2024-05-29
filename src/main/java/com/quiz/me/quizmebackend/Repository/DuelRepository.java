package com.quiz.me.quizmebackend.Repository;

import com.quiz.me.quizmebackend.Model.DuelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuelRepository extends JpaRepository<DuelModel, String> {
    // Weitere Methoden nach Bedarf
}

