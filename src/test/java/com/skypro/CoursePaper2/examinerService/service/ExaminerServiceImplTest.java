package com.skypro.CoursePaper2.examinerService.service;

import com.skypro.CoursePaper2.examinerService.exception.IncorrectNumberOfQuestions;
import com.skypro.CoursePaper2.model.Questions;
import com.skypro.CoursePaper2.service.JavaQuestionImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionImpl javaQuestion;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void checkingForRandomConclusionQuestions() {
        int amount = 2;
        List<Questions> cheklist = new ArrayList<>(List.of(
                new Questions("question1", "answer1"),
                new Questions("question2", "answer2"),
                new Questions("question3", "answer3")
        ));

        Mockito.when(javaQuestion.getAll()).thenReturn(cheklist);
        Mockito.when(javaQuestion.getRandomQuestion()).thenReturn(
                cheklist.get(0),
                cheklist.get(0),
                cheklist.get(0),
                cheklist.get(1)
        );

        Collection<Questions> actual = examinerService.getQuestions(amount);

        Assertions.assertEquals(Set.of(cheklist.get(0),cheklist.get(1)),actual);

        Mockito.verify(javaQuestion,times(4)).getRandomQuestion();
    }

    @Test
    public void checkingForIncorrectNumberOfQuestions() {
        int amount = 6;
        List<Questions> cheklist = new ArrayList<>(List.of(
                new Questions("question1", "answer1"),
                new Questions("question2", "answer2"),
                new Questions("question3", "answer3")
        ));

        Mockito.when(javaQuestion.getAll()).thenReturn(cheklist);

        Assertions.assertThrows(
                IncorrectNumberOfQuestions.class,
                () -> examinerService.getQuestions(amount)
        );
    }
}