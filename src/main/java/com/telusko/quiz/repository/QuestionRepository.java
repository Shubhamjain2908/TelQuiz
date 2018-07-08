package com.telusko.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telusko.quiz.entity.QuestionModel;

/**
 * Repository for Question entity
 * 
 * @author SHUBHAM JAIN
 * @since 22-06-2018
 */
public interface QuestionRepository extends JpaRepository<QuestionModel, Integer>{
	//public QuestionModel findByQId(Integer id);
}
