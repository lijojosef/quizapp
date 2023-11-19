package com.lijo.quizapp.dao;

import com.lijo.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository <Question, Integer>
{
    List<Question> findByCategory(String category);

    @Query(value="SELECT * FROM QUESTION Q WHERE Q.CATEGORY =:category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numQ);
    /*List<Question> findByCategory(String category);*/
}
