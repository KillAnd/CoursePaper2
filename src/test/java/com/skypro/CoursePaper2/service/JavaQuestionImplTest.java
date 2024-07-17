package com.skypro.CoursePaper2.service;

import com.skypro.CoursePaper2.model.Questions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionImplTest {

    private final QuestionService questionService = new JavaQuestionImpl();


    @Test
    void checkingCorrectlyAddQuestions() {
        String question = "Зачем?";
        String answer = "Надо";


        Questions actualyQuestion = questionService.add(question,answer);
        Assertions.assertEquals(question,actualyQuestion.getQuestion());
        Assertions.assertEquals(answer,actualyQuestion.getAnswer());
    }

    @Test
    void testAddQuestions() {
        Questions extendedQuestion = new Questions("Зачем?", "Надо");
        Questions actualQuestion = questionService.add(extendedQuestion);

        Assertions.assertEquals(extendedQuestion,actualQuestion);
    }

    @Test
    void remove() {
        Questions questions = new Questions("Зачем?", "Надо");
        questionService.add(questions);

        Questions actual = questionService.remove(questions);

        Assertions.assertEquals(questions,actual);
    }

    @Test
    void getAll() {
        Questions questions = new Questions("Зачем?", "Надо");
        Questions questions1 = new Questions("Почему?", "Потому");

        questionService.add(questions);
        questionService.add(questions1);

        Collection<Questions> actualCollection = questionService.getAll();

        Assertions.assertEquals(Set.of(questions,questions1),actualCollection);
    }

    @Test
    void getRandomQuestion() {
        Questions questions = new Questions("Зачем?", "Надо");
        Questions questions1 = new Questions("Почему?", "Потому");

        questionService.add(questions);
        questionService.add(questions1);

        Questions actual = questionService.getRandomQuestion();

        Assertions.assertTrue(Set.of(questions,questions1).contains(actual));
    }
}