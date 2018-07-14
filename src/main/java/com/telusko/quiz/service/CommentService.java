package com.telusko.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.quiz.entity.CommentModel;
import com.telusko.quiz.entity.QuestionModel;
import com.telusko.quiz.exception.BadRequestException;
import com.telusko.quiz.repository.QuestionRepository;

/**
 * This is a service layer which generates response
 * 
 * @author SHUBHAM JAIN
 * @since 30-06-2018
 */
@Service
public class CommentService {

	@Autowired
	private QuestionRepository qR;
	
	/**
	 * Method to save a comment for a particular question
	 * @param questionId
	 * @param comment
	 * @return
	 */
	public QuestionModel saveComment(Integer questionId, CommentModel comment) 
	{
		QuestionModel q = qR.findById(questionId).get();
		if(null != q) 
		{
			q.getComments().add(comment);
			return qR.save(q);
		}
		throw new BadRequestException("No question found");
	}
}
