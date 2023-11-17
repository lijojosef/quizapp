package com.lijo.quizapp.controller;

import com.lijo.quizapp.model.Question;
import com.lijo.quizapp.service.QuestionService;
import jakarta.websocket.server.PathParam;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController
{

    @Autowired
    QuestionService questionService;
    // to get all the questions
    @GetMapping("allquestions")
    public List<Question> getAllQuestions()
    {

        return questionService.getAllQuestions();
    }

    // to get category wise result
    @GetMapping("category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category)
    {
        return questionService.getQuestionsByCategory(category);
    }

    // to add records
    @PostMapping("add")
    public String addQuestion(@RequestBody Question question)
    {
        return questionService.addQuestion(question);
    }

    // delete and update controllers:
    // to delete records
    @DeleteMapping("delete/{aid}")
    public String deleteQuestion(@PathVariable ("aid") int aid)
    {
        return questionService.deleteQuestion(aid);
    }

    @PutMapping("update/{aid}")
    public String updateQuestion(@PathVariable ("aid") int aid, @RequestBody Question question)
    {
        questionService.deleteQuestion(aid);
        return questionService.addQuestion(question);
    }

}
