package com.lijo.quizapp.service;

import com.lijo.quizapp.dao.QuestionDao;
import com.lijo.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class QuestionService
{
    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions()
    {
        return questionDao.findAll();
    }
    public List<Question> getQuestionsByCategory(String category)
    {
        return questionDao.findByCategory(category);
    }


    public String addQuestion(Question question)
    {
        questionDao.save(question);
        return "success";
    }
}
