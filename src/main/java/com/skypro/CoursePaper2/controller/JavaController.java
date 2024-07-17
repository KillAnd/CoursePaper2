package com.skypro.CoursePaper2.controller;

import com.skypro.CoursePaper2.model.Questions;
import com.skypro.CoursePaper2.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaController {

    private final QuestionService questionService;

    public JavaController(QuestionService questionService) {
        this.questionService = questionService;
    }
    @GetMapping("/add")
    public Questions addQuestion(@RequestParam String question,@RequestParam String answer) {
        return questionService.add(question, answer);
    }
    @GetMapping
    public Collection<Questions> getQuestions() {
        return questionService.getAll();
    }
    @GetMapping("/remove")
    public Questions removeQuestion(@RequestParam String question,@RequestParam String answer) {
        return questionService.remove(new Questions(question,answer));
    }
}
