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

/**
 * This is a controller for handling/delegating requests to service layer.
 * 
 * @author SHUBHAM JAIN
 * @since 29-06-2018
 * 
 */
@RestController
@RequestMapping(value="/questions/{questionId}/comments")
public class CommentController {
	
	@Autowired
	private CommentService cS;
	
	/**
	 * Method to post a comment
	 * @param questionId
	 * @param comment
	 * @return
	 */
	@PostMapping
	public QuestionModel saveComment(@PathVariable("questionId") int questionId, @RequestBody CommentModel comment) 
	{
		return cS.saveComment(questionId, comment);
	}
}
