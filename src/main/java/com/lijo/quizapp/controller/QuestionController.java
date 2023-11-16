package com.lijo.quizapp.controller;

import com.lijo.quizapp.model.Question;
import com.lijo.quizapp.service.QuestionService;
import jakarta.websocket.server.PathParam;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController
{

    @Autowired
    QuestionService questionService;
    @GetMapping("allquestions")
    public List<Question> getAllQuestions()
    {

        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category)
    {
        return questionService.getQuestionsByCategory(category);
    }
}
