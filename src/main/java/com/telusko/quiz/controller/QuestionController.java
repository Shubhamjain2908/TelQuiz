package com.telusko.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.quiz.entity.QuestionModel;
import com.telusko.quiz.entity.SubjectModel;
import com.telusko.quiz.service.QuestionService;

/**
 * This is a controller for handling/delegating requests to service layer.
 * 
 * @author SHUBHAM JAIN
 * @since 22-06-2018
 * 
 */
@RestController
@RequestMapping("/questions")
public class QuestionController {
	
	@Autowired
	private QuestionService qS;
	
	@GetMapping
	public SubjectModel getQuestions() 
	{
		return qS.getQuestion();
	}
	
}
