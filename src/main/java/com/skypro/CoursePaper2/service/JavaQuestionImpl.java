package com.skypro.CoursePaper2.service;

import com.skypro.CoursePaper2.model.Questions;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionImpl implements QuestionService {

    private final Set<Questions> questions1 = new HashSet<>();

    @PostConstruct
    public void init() {
        add("Как называется целочисленная переменная?","int");
        add("Какие области памяти вы знаете?", "Stack и Heap");
        add("Какие методы вы знаете?", "Статические и не статические");
        add("Что такое JVM?", "Java Virtual Machine");
        add("'Map' это коллекция?", "Нет");
    }

    @Override
    public Questions add(String question, String answer) {
            questions1.add(new Questions(question,answer));
        return new Questions(question,answer);
    }

    @Override
    public Questions add(Questions questions) {
            questions1.add(questions);
        return questions;
    }

    @Override
    public Questions remove(Questions questions) {
            questions1.remove(questions);
        return questions;
    }

    @Override
    public Collection<Questions> getAll() {
        return Collections.unmodifiableSet(questions1);
    }

    @Override
    public Questions getRandomQuestion() {
        Random random = new Random();
        int randomValue = random.nextInt(questions1.size());
        return new ArrayList<>(questions1).get(randomValue);
    }
}
