package com.telusko.quiz.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.quiz.entity.QuestionModel;
import com.telusko.quiz.entity.SubjectModel;
import com.telusko.quiz.exception.BadRequestException;
import com.telusko.quiz.repository.QuestionRepository;
import com.telusko.quiz.repository.SubjectRepository;

/**
 * This is a service layer which generates response
 * 
 * @author SHUBHAM JAIN
 * @since 22-06-2018
 */
@Service
public class QuestionService {

	@Autowired
	private SubjectRepository sR;
	
//	@Autowired
//	private QuestionRepository qR;
	
	public List<SubjectModel> getAllQuestions() 
	{
		return sR.findAll();
	}
	
	public SubjectModel getQuestion(String subjectID) 
	{
		return sR.findByName(subjectID);
	}
	
//	public QuestionModel getOneQuestion(int id) 
//	{
//		return qR.findByQId(id);
//	}
}
