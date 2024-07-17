package com.skypro.CoursePaper2.examinerService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IncorrectNumberOfQuestions extends RuntimeException {
    public IncorrectNumberOfQuestions(String message) {
        super(message);
    }
}
