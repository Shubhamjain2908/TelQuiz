package com.telusko.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.quiz.entity.CommentModel;
import com.telusko.quiz.entity.QuestionModel;
import com.telusko.quiz.exception.BadRequestException;
import com.telusko.quiz.repository.QuestionRepository;

@Service
public class CommentService {

	@Autowired
	private QuestionRepository qR;
	
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
