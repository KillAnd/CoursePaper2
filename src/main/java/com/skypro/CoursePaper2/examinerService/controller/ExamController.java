package com.skypro.CoursePaper2.examinerService.controller;

import com.skypro.CoursePaper2.examinerService.service.ExaminerService;
import com.skypro.CoursePaper2.model.Questions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }
    @GetMapping("exam/get/{amount}")
    public Collection<Questions> getQuestions(@PathVariable int amount) {
        return examinerService.getQuestions(amount);
    }
}
