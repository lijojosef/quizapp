package com.lijo.quizapp.controller;

import com.lijo.quizapp.model.Question;
import com.lijo.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Question>> getAllQuestions()
    {

        return questionService.getAllQuestions();
    }

    // to get category wise result
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category)
    {
        return questionService.getQuestionsByCategory(category);
    }

    // to add records
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question)
    {
        return questionService.addQuestion(question);
    }

    // to delete records
    @DeleteMapping("delete/{aid}")
    public ResponseEntity<String> deleteQuestion(@PathVariable ("aid") int aid)
    {
        return questionService.deleteQuestion(aid);
    }

    // to update records
    @PutMapping("update/{aid}")
    public ResponseEntity<String> updateQuestion(@RequestBody Question question)
    {
        return questionService.saveOrUpdateQuestion(question);
    }

}
