package com.skypro.CoursePaper2.examinerService.service;

import com.skypro.CoursePaper2.model.Questions;

import java.util.Collection;

public interface ExaminerService {

    Collection<Questions> getQuestions(int amount);

}
