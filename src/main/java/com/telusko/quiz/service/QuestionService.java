package com.telusko.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.quiz.entity.SubjectModel;
import com.telusko.quiz.repository.QuestionRepository;
import com.telusko.quiz.repository.SubjectRepository;

/**
 * This is a service layer which generates response
 * 
 * @author SHUBHAM JAIN
 * @since 26-04-2018
 */
@Service
public class QuestionService {

	@Autowired
	private QuestionRepository qR;
	
	@Autowired
	private SubjectRepository sR;
	
	public SubjectModel getQuestion() 
	{
		return sR.findByName("JAVA");
	}
}
