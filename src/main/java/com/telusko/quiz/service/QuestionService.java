package com.telusko.quiz.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.quiz.entity.QuestionModel;
import com.telusko.quiz.entity.SubjectModel;
import com.telusko.quiz.entity.TopicModel;
import com.telusko.quiz.exception.BadRequestException;
import com.telusko.quiz.repository.TopicRepository;
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
	
	@Autowired
	private TopicRepository tR;
	
	public List<SubjectModel> getAllQuestions() 
	{
		return sR.findAll();
	}

	public SubjectModel getQuestions(String subjectID, Map<String, String> allRequestParams) 
	{
		if(allRequestParams.containsKey("topic") && !allRequestParams.get("topic").isEmpty()) 
		{
			if(tR.findById(allRequestParams.get("topic")).isPresent()) 
			{
				SubjectModel s = new SubjectModel();
				s.setName(subjectID);
				Set<TopicModel> topic = new HashSet<>(Arrays.asList(sR.findByName(subjectID).getTopics().stream().filter(t -> t.getName().equals(allRequestParams.get("topic"))).findFirst().get()));
				s.setTopics(topic);
				return s;
			}
			throw new BadRequestException("No topic with name " + allRequestParams.get("topic") + " present");
		}
		return sR.findByName(subjectID);
	}
	
	public QuestionModel getOneQuestion(int id) 
	{
		return null;
	}
}
