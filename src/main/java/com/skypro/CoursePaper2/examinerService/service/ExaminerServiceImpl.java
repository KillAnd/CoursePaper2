package com.skypro.CoursePaper2.examinerService.service;

import com.skypro.CoursePaper2.examinerService.exception.IncorrectNumberOfQuestions;
import com.skypro.CoursePaper2.model.Questions;
import com.skypro.CoursePaper2.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }


    @Override
    public Collection<Questions> getQuestions(int amount) {
        int size = questionService.getAll().size();

        if (amount > size) {
            throw new IncorrectNumberOfQuestions("Введено вопросов больше чем " + size + " !");
        }
        Set<Questions> randomQuestions = new HashSet<>();

        while (randomQuestions.size() < amount) {
            randomQuestions.add(questionService.getRandomQuestion());
        }
        return randomQuestions;
    }
}
