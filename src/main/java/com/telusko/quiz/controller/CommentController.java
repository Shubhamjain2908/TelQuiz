package com.telusko.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.quiz.entity.CommentModel;
import com.telusko.quiz.entity.QuestionModel;
import com.telusko.quiz.service.CommentService;

@RestController
@RequestMapping(value="/questions/{questionId}/comments")
public class CommentController {
	
	@Autowired
	private CommentService cS;
	
	@PostMapping
	public QuestionModel co(@PathVariable("questionId") int questionId, @RequestBody CommentModel comment) 
	{
		return cS.saveComment(questionId, comment);
	}
}
