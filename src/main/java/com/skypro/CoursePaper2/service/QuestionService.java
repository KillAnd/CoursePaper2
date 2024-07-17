package com.skypro.CoursePaper2.service;

import com.skypro.CoursePaper2.model.Questions;

import java.util.Collection;

public interface QuestionService {

    Questions add(String question, String answer);

    Questions add(Questions questions);

    Questions remove(Questions questions);

    Collection<Questions> getAll();

    Questions getRandomQuestion();

}
