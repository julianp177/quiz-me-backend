package com.quiz.me.quizmebackend.Services;

import com.quiz.me.quizmebackend.Model.CardModel;
import com.quiz.me.quizmebackend.Model.MarkModel;
import com.quiz.me.quizmebackend.Model.SetModel;
import com.quiz.me.quizmebackend.Repository.CardRepository;
import com.quiz.me.quizmebackend.Repository.MarkRepository;
import com.quiz.me.quizmebackend.Repository.SetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardsService {

    private final SetRepository setRepository;
    private final CardRepository cardRepository;
    private final MarkRepository markRepository;

    public CardsService(SetRepository setRepository, CardRepository cardRepository, MarkRepository markRepository) {
        this.setRepository = setRepository;
        this.cardRepository = cardRepository;
        this.markRepository = markRepository;
    }

    public List<SetModel> getSets(){
        return this.setRepository.findAll();
    }
    public List<CardModel> getCards() { return this.cardRepository.findAll(); }
    public List<MarkModel> getMarks() { return this.markRepository.findAll(); }

}
